package Application;

import ClientDemo.ClientDemoFrame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by M on 27. 4. 2016.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationFrame frame = new ApplicationFrame();
        
        try {
            ClientDemoFrame clientDemoFrame = new ClientDemoFrame();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
