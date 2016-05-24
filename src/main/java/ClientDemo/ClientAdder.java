package ClientDemo;

import Model.Airport;
import Model.Client;
import Service.ClientManager;
import Service.ClientService;
import Validator.InvalidAttributeException;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin Cap
 */
public class ClientAdder {

    private final BufferedReader br;
    private BufferedReader saveReader;
    private final File saveFile = new File("saves/client_progress.txt");
    private final File dataFile = new File("resources/csv_client.csv");
    
    
    private final ClientManager clientService = new ClientService();

    private int numClientsRead;

    public ClientAdder() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        this.br = new BufferedReader(new FileReader(dataFile));
        loadProgress();
    }

    private void loadProgress() throws IOException {
        if (!saveFile.exists()) {
            saveFile.createNewFile();
            numClientsRead = 0;
            saveProgress();
        } else {
            saveReader = new BufferedReader(new FileReader(saveFile));
            numClientsRead = Integer.parseInt(saveReader.readLine());
//            System.out.println("Loading progress... skipping " + numAirplanesRead + " lines.");
            for (int i = 0; i < numClientsRead; i++) {
                br.readLine();
            }
        }
    }

    private void saveProgress() throws IOException {
        FileWriter fw = new FileWriter(saveFile);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(numClientsRead + "\n");
        }
    }

    public void addClients(int n) {
        String tmp;
        String array[];
        for (int i = 0; i < n; i++) {
            numClientsRead++;
            if (numClientsRead == 1000) {
                System.out.println("End of file reached, no more airplanes to add!");
                break;
            }
            try {
                tmp = br.readLine();
                array = tmp.split(",");
                
                Client client = Client.createClient(array[0], array[1], array[2], array[3], array[4]);
                
                clientService.createClient(client);
                
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
