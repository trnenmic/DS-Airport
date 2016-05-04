package Application.GUIDesigners;

import javax.swing.JDialog;

/**
 *
 * @author M
 */
public class DialogDesigner {

    public static void centerDialog(JDialog dialog) {
        dialog.setVisible(true);
        dialog.setAlwaysOnTop(true);
        dialog.setLocationRelativeTo(null);
    }

}
