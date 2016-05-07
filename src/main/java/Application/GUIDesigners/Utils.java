/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.GUIDesigners;

import javax.swing.JTextField;

/**
 *
 * @author M
 */
public class Utils {

    public static String emptyStringToNull(JTextField jTextField) {
        return (jTextField.getText().equals("") ? null : jTextField.getText());
    }

    public static Integer emptyStringToNullConvert(JTextField jTextField) throws NumberFormatException{
        return Integer.parseInt(jTextField.getText());
    }

}
