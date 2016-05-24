package ClientDemo;

import Model.CrewMember;
import Service.CrewMemberManager;
import Service.CrewMemberService;
import Validator.InvalidAttributeException;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin Cap
 */
public class CrewMemberAdder {

    private final BufferedReader br;
    private BufferedReader saveReader;
    private final File saveFile = new File("saves/crew_member_progress.txt");
    private final File dataFile = new File("resources/csv_crew_member.csv");
    
    
    private final CrewMemberManager crewMemberService = new CrewMemberService();

    private int numCrewMembersRead;

    public CrewMemberAdder() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        this.br = new BufferedReader(new FileReader(dataFile));
        loadProgress();
    }

    private void loadProgress() throws IOException {
        if (!saveFile.exists()) {
            saveFile.createNewFile();
            numCrewMembersRead = 0;
            saveProgress();
        } else {
            saveReader = new BufferedReader(new FileReader(saveFile));
            numCrewMembersRead = Integer.parseInt(saveReader.readLine());
//            System.out.println("Loading progress... skipping " + numAirplanesRead + " lines.");
            for (int i = 0; i < numCrewMembersRead; i++) {
                br.readLine();
            }
        }
    }

    private void saveProgress() throws IOException {
        FileWriter fw = new FileWriter(saveFile);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(numCrewMembersRead + "\n");
        }
    }

    public void addCrewMembers(int n) {
        String tmp;
        String array[];
        for (int i = 0; i < n; i++) {
            numCrewMembersRead++;
            if (numCrewMembersRead == 1000) {
                System.out.println("End of file reached, no more airplanes to add!");
                break;
            }
            try {
                tmp = br.readLine();
                array = tmp.split(",");
                
                CrewMember crewMember = CrewMember.createCrewMember(array[0], array[1], array[2]);
                
                crewMemberService.createCrewMember(crewMember);
                
            } catch (IOException | InvalidAttributeException e) {
                Logger.getLogger(AirplaneAdder.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        try {
            saveProgress();
        } catch (IOException ex) {
            Logger.getLogger(AirplaneAdder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
