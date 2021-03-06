package ClientDemo;

import Model.Airplane;
import Service.AirplaneManager;
import Service.AirplaneService;
import Validator.InvalidAttributeException;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin Cap
 */
public class AirplaneAdder {

    private final BufferedReader br;
    private BufferedReader saveReader;
    private final File saveFile = new File("saves/airplane_progress.txt");
    private final File dataFile = new File("resources/csv_airplane.csv");
    
    
    private final AirplaneManager airplaneService = new AirplaneService();

    private int numAirplanesRead;

    public AirplaneAdder() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        this.br = new BufferedReader(new FileReader(dataFile));
        loadProgress();
    }

    private void loadProgress() throws IOException {
        if (!saveFile.exists()) {
            saveFile.createNewFile();
            numAirplanesRead = 0;
            saveProgress();
        } else {
            saveReader = new BufferedReader(new FileReader(saveFile));
            numAirplanesRead = Integer.parseInt(saveReader.readLine());
//            System.out.println("Loading progress... skipping " + numAirplanesRead + " lines.");
            for (int i = 0; i < numAirplanesRead; i++) {
                br.readLine();
            }
        }
    }

    private void saveProgress() throws IOException {
        FileWriter fw = new FileWriter(saveFile);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(numAirplanesRead + "\n");
        }
    }

    public void addAirplanes(int n) {
        String tmp;
        String array[];
        for (int i = 0; i < n; i++) {
            numAirplanesRead++;
            if (numAirplanesRead == 1000) {
                System.out.println("End of file reached, no more airplanes to add!");
                break;
            }
            try {
                tmp = br.readLine();
                array = tmp.split(",");
                
                Airplane airplane = Airplane.createAirplane(array[0], array[1], Integer.parseInt(array[2].trim()),
                        Integer.parseInt(array[3].trim()), Integer.parseInt(array[4].trim()), Integer.parseInt(array[5].trim()));
                
                airplaneService.createAirplane(airplane);
                
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
