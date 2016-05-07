package Application;

import javax.swing.UIManager;

/**
 * Created by M on 27. 4. 2016.
 */
public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        ApplicationFrame frame = new ApplicationFrame();

    }
}
