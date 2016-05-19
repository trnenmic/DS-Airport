package ClientDemo;

import Model.Airport;
import Service.AirportManager;
import Service.AirportService;
import Validator.InvalidAttributeException;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin Cap
 */
public class ClientDemoAirportAdder {

    private final BufferedReader br;
    private BufferedReader saveReader;
    private final File saveFile = new File("saves/airport_progress.txt");
    private final File dataFile = new File("resources/csv_airport.csv");
    
    
    private final AirportManager airportService = new AirportService();

    private int numAirportsRead;

    public ClientDemoAirportAdder() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        this.br = new BufferedReader(new FileReader(dataFile));
        loadProgress();
    }

    private void loadProgress() throws IOException {
        if (!saveFile.exists()) {
            saveFile.createNewFile();
            numAirportsRead = 0;
            saveProgress();
        } else {
            saveReader = new BufferedReader(new FileReader(saveFile));
            numAirportsRead = Integer.parseInt(saveReader.readLine());
//            System.out.println("Loading progress... skipping " + numAirplanesRead + " lines.");
            for (int i = 0; i < numAirportsRead; i++) {
                br.readLine();
            }
        }
    }

    private void saveProgress() throws IOException {
        FileWriter fw = new FileWriter(saveFile);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(numAirportsRead + "\n");
        }
    }

    public void addAirplanes(int n) {
        String tmp;
        String array[];
        for (int i = 0; i < n; i++) {
            numAirportsRead++;
            if (numAirportsRead == 1000) {
                System.out.println("End of file reached, no more airplanes to add!");
                break;
            }
            try {
                tmp = br.readLine();
                array = tmp.split(",");
                
                Airport airport = Airport.createAirport(array[0], array[1], array[2], array[3], array[4]);
                
                airportService.createAirport(airport);
                
            } catch (IOException e) {
                Logger.getLogger(ClientDemoAirplaneAdder.class.getName()).log(Level.SEVERE, null, e);
            } catch (InvalidAttributeException e) {
                Logger.getLogger(ClientDemoAirplaneAdder.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        try {
            saveProgress();
        } catch (IOException ex) {
            Logger.getLogger(ClientDemoAirplaneAdder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
