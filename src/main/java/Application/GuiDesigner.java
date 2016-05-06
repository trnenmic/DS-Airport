package Application;

import javax.swing.JDialog;

/**
 *
 * @author M
 */
public class GuiDesigner {

    public static void centerDialog(JDialog dialog) {
        dialog.setVisible(true);
        dialog.setAlwaysOnTop(true);
        dialog.setLocationRelativeTo(null);
    }
    
}
