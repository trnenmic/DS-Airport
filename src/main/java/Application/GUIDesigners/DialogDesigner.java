/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
