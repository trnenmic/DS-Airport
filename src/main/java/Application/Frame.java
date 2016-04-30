package Application;

import Data.AirplaneDAO;
import Model.Airplane;
import Service.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Martin
 */
public class Frame extends JFrame {

    private JPanel contentPane;

    // testing
    private JTextField idAirplaneTF;
    private JButton searchButton;
    private JTextArea searchResults;

    private AirplaneService airplaneService = new AirplaneService();
    private AirplaneDAO airplaneDAO = new AirplaneDAO();

    public Frame() {

        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setName("Airport application");

        contentPane = new JPanel();

        idAirplaneTF = new JTextField("input airplane id");
        searchButton = new JButton("Search");
        searchResults = new JTextArea();

        ButtonListener buttonListener = new ButtonListener();
        searchButton.addActionListener(buttonListener);

        searchResults.setPreferredSize(new Dimension(400, 400));

        contentPane.add(idAirplaneTF);
        contentPane.add(searchButton);
        contentPane.add(searchResults);

        this.add(contentPane);
        this.setVisible(true);
        idAirplaneTF.setFocusable(true);
    }

    public void update() {
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (!isParsable(idAirplaneTF.getText())) {
                System.out.println("Text field not parsable as integer!");
                return;
            }
            int id = Integer.parseInt(idAirplaneTF.getText());
            if (e.getSource().equals(searchButton)) {
                Airplane tmp = airplaneDAO.find(id);
                if (tmp != null) {
                    searchResults.setText(tmp.toString());
                } else {
                    searchResults.setText("Airplane with id " + id + " not found!");
                }
            }

        }

    }

    public static boolean isParsable(String input) {
        boolean parsable = true;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            parsable = false;
        }
        return parsable;
    }

}
