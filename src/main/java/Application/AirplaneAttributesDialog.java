package Application;

import Service.RelationService;
import Application.GUIDesigners.DialogDesigner;
import Model.Airplane;
import Service.ManagementProvider;
import Validator.InvalidAttributeException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

/**
 *
 * @author M
 */
public class AirplaneAttributesDialog extends javax.swing.JDialog {

    private ManagementProvider mgProvider;
    private Object detached = null;
    private RelationService boundingUpdater;
    private boolean update = false;

    public AirplaneAttributesDialog(java.awt.Frame parent, boolean modal, ManagementProvider managementProvider, Object o) {
        super(parent, modal);
        if (o == null) {
            detached = Airplane.createAirplane("", "", 0, 0, 0, 0);
            update = false;
            this.setTitle("Create Airplane");
        } else {
            detached = o;
            update = true;
            this.setTitle("Update Airplane Attributes");
        }
        initDialog(managementProvider);
        if (update) {
            updateTextFields();
        }
    }

    public AirplaneAttributesDialog(java.awt.Frame parent, boolean modal, ManagementProvider managementProvider) {
        super(parent, modal);
        detached = Airplane.createAirplane("", "", 0, 0, 0, 0);
        update = false;
        this.setTitle("Create Airplane");
        initDialog(managementProvider);
    }

    private void initDialog(ManagementProvider managementProvider) {
        mgProvider = managementProvider;
        boundingUpdater = mgProvider.getRelationService();
        initComponents();
        setLocationRelativeTo(null);
        initLists();

    }

    private void initLists() {
        airplaneRoutesList.setSelectionMode(SINGLE_SELECTION);
        updateLists();

    }

    private void updateLists() {
        airplaneRoutesList.setListData(((Airplane) detached).getRoutes().toArray());
    }

    private void updateTextFields() {
        Airplane airplane = (Airplane) detached;
        airplaneAirlineTextField.setText(airplane.getAirline());
        airplanePassengerCapacityTextField.setText("" + airplane.getPassengerCapacity());
        airplaneCodeTextField.setText(airplane.getAirplaneCode());
        airplaneMaximumRangeTextField.setText("" + airplane.getMaximumRange());
        airplaneMaximumTakeoffWeightTextField.setText("" + airplane.getMaximumTakeoffWeight());
        airplaneMaximumCargoCapacityTextField.setText("" + airplane.getMaximumCargoCapacity());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        airportAttributesPanel = new javax.swing.JPanel();
        airplaneAttributesLabel = new javax.swing.JLabel();
        airplaneCodeLabel = new javax.swing.JLabel();
        airplaneCodeTextField = new javax.swing.JTextField();
        airplaneAirlineLabel = new javax.swing.JLabel();
        airplaneAirlineTextField = new javax.swing.JTextField();
        airplanePassengerCapacityLabel = new javax.swing.JLabel();
        airplanePassengerCapacityTextField = new javax.swing.JTextField();
        airplaneMaximumRangeLabel = new javax.swing.JLabel();
        airplaneMaximumRangeTextField = new javax.swing.JTextField();
        airplaneMaximumCargoCapacityTextField = new javax.swing.JTextField();
        airplaneCargoCapacityLabel = new javax.swing.JLabel();
        airplaneMaximumTakeoffWeightLabel = new javax.swing.JLabel();
        airplaneMaximumTakeoffWeightTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        airplaneRoutesList = new javax.swing.JList();
        airplaneSaveButton = new javax.swing.JButton();
        routesLabel = new javax.swing.JLabel();
        airplaneAddingRoutesButton = new javax.swing.JButton();
        warningLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Airplane Attributes");

        airportAttributesPanel.setBackground(new java.awt.Color(204, 204, 255));

        airplaneAttributesLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        airplaneAttributesLabel.setText("Airplane Attributes");

        airplaneCodeLabel.setText("Code:");

        airplaneCodeTextField.setBackground(new java.awt.Color(52, 52, 56));
        airplaneCodeTextField.setForeground(new java.awt.Color(255, 255, 255));

        airplaneAirlineLabel.setText("Airline:");

        airplaneAirlineTextField.setBackground(new java.awt.Color(52, 52, 56));
        airplaneAirlineTextField.setForeground(new java.awt.Color(255, 255, 255));

        airplanePassengerCapacityLabel.setText("Passenger capacity:");

        airplanePassengerCapacityTextField.setBackground(new java.awt.Color(52, 52, 56));
        airplanePassengerCapacityTextField.setForeground(new java.awt.Color(255, 255, 255));

        airplaneMaximumRangeLabel.setText("Max. Range:");

        airplaneMaximumRangeTextField.setBackground(new java.awt.Color(52, 52, 56));
        airplaneMaximumRangeTextField.setForeground(new java.awt.Color(255, 255, 255));

        airplaneMaximumCargoCapacityTextField.setBackground(new java.awt.Color(52, 52, 56));
        airplaneMaximumCargoCapacityTextField.setForeground(new java.awt.Color(255, 255, 255));
        airplaneMaximumCargoCapacityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airplaneMaximumCargoCapacityTextFieldActionPerformed(evt);
            }
        });

        airplaneCargoCapacityLabel.setText("Max. cargo capacity:");

        airplaneMaximumTakeoffWeightLabel.setText("Max. takeoff weight:");

        airplaneMaximumTakeoffWeightTextField.setBackground(new java.awt.Color(52, 52, 56));
        airplaneMaximumTakeoffWeightTextField.setForeground(new java.awt.Color(255, 255, 255));
        airplaneMaximumTakeoffWeightTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airplaneMaximumTakeoffWeightTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout airportAttributesPanelLayout = new javax.swing.GroupLayout(airportAttributesPanel);
        airportAttributesPanel.setLayout(airportAttributesPanelLayout);
        airportAttributesPanelLayout.setHorizontalGroup(
            airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(airportAttributesPanelLayout.createSequentialGroup()
                .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(airportAttributesPanelLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(airplaneAttributesLabel))
                    .addGroup(airportAttributesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(airplaneCodeLabel)
                            .addComponent(airplaneAirlineLabel)
                            .addComponent(airplanePassengerCapacityLabel)
                            .addComponent(airplaneMaximumRangeLabel)
                            .addComponent(airplaneCargoCapacityLabel)
                            .addComponent(airplaneMaximumTakeoffWeightLabel))
                        .addGap(18, 18, 18)
                        .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(airplaneMaximumCargoCapacityTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(airplaneMaximumRangeTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(airplanePassengerCapacityTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(airplaneAirlineTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(airplaneCodeTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(airplaneMaximumTakeoffWeightTextField))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        airportAttributesPanelLayout.setVerticalGroup(
            airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(airportAttributesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(airplaneAttributesLabel)
                .addGap(18, 18, 18)
                .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airplaneCodeLabel)
                    .addComponent(airplaneCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airplaneAirlineLabel)
                    .addComponent(airplaneAirlineTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airplanePassengerCapacityLabel)
                    .addComponent(airplanePassengerCapacityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airplaneMaximumRangeLabel)
                    .addComponent(airplaneMaximumRangeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airplaneCargoCapacityLabel)
                    .addComponent(airplaneMaximumCargoCapacityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(airplaneMaximumTakeoffWeightLabel)
                    .addComponent(airplaneMaximumTakeoffWeightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setMaximumSize(new java.awt.Dimension(1000, 800));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(50, 50));

        airplaneRoutesList.setBackground(new java.awt.Color(165, 165, 178));
        airplaneRoutesList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(airplaneRoutesList);

        airplaneSaveButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        airplaneSaveButton.setText("Save Airplane");
        airplaneSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airplaneSaveButtonActionPerformed(evt);
            }
        });

        routesLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        routesLabel.setText("This Airplane flies on Routes:");

        airplaneAddingRoutesButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        airplaneAddingRoutesButton.setText("Find & add new Route to fly on");
        airplaneAddingRoutesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airplaneAddingRoutesButtonActionPerformed(evt);
            }
        });

        warningLabel.setForeground(new java.awt.Color(204, 0, 0));
        warningLabel.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(warningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(routesLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(airplaneAddingRoutesButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(airportAttributesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(airplaneSaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(routesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(airplaneAddingRoutesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(airplaneSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(airportAttributesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(warningLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void airplaneMaximumCargoCapacityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airplaneMaximumCargoCapacityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airplaneMaximumCargoCapacityTextFieldActionPerformed

    private void airplaneSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airplaneSaveButtonActionPerformed
        warningLabel.setText(" ");
        try {
            Airplane airplane = (Airplane) detached;
            if (update) {
                detached = mgProvider.getAirplaneManager().updateAirplane(airplane, airplanePassengerCapacityTextField.getText(),
                        airplaneMaximumRangeTextField.getText(), airplaneAirlineTextField.getText(),
                        airplaneMaximumCargoCapacityTextField.getText(), airplaneMaximumTakeoffWeightTextField.getText(),
                        airplaneCodeTextField.getText());
            } else {
                detached = mgProvider.getAirplaneManager().createAirplane(airplane, airplanePassengerCapacityTextField.getText(),
                        airplaneMaximumRangeTextField.getText(), airplaneAirlineTextField.getText(),
                        airplaneMaximumCargoCapacityTextField.getText(), airplaneMaximumTakeoffWeightTextField.getText(),
                        airplaneCodeTextField.getText());
                update = true;
                this.setTitle("Update Airplane Attributes");
            }
            boundingUpdater.updateBoundingsTx();
        } catch (InvalidAttributeException e) {
            warningLabel.setText(e.getMessage());
            Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, e);
        }
        updateLists();
    }//GEN-LAST:event_airplaneSaveButtonActionPerformed

    private void airplaneMaximumTakeoffWeightTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airplaneMaximumTakeoffWeightTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airplaneMaximumTakeoffWeightTextFieldActionPerformed

    private void airplaneAddingRoutesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airplaneAddingRoutesButtonActionPerformed
        warningLabel.setText(" ");
        AirplaneBoundingDialog routeBoundingDialog = new AirplaneBoundingDialog(null, true, mgProvider, detached, boundingUpdater);
        DialogDesigner.centerDialog(routeBoundingDialog);
        updateLists();
    }//GEN-LAST:event_airplaneAddingRoutesButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AirplaneAttributesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AirplaneAttributesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AirplaneAttributesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AirplaneAttributesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManagementProvider managementProvider = new ManagementProvider();
//                managementProvider.setAirplaneManager(new AirplaneDAO());
//                managementProvider.setAirportManager(new AirportDAO());
//                managementProvider.setRouteManager(new RouteDAO());
                AirplaneAttributesDialog dialog = new AirplaneAttributesDialog(new javax.swing.JFrame(), true, managementProvider);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton airplaneAddingRoutesButton;
    private javax.swing.JLabel airplaneAirlineLabel;
    private javax.swing.JTextField airplaneAirlineTextField;
    private javax.swing.JLabel airplaneAttributesLabel;
    private javax.swing.JLabel airplaneCargoCapacityLabel;
    private javax.swing.JLabel airplaneCodeLabel;
    private javax.swing.JTextField airplaneCodeTextField;
    private javax.swing.JTextField airplaneMaximumCargoCapacityTextField;
    private javax.swing.JLabel airplaneMaximumRangeLabel;
    private javax.swing.JTextField airplaneMaximumRangeTextField;
    private javax.swing.JLabel airplaneMaximumTakeoffWeightLabel;
    private javax.swing.JTextField airplaneMaximumTakeoffWeightTextField;
    private javax.swing.JLabel airplanePassengerCapacityLabel;
    private javax.swing.JTextField airplanePassengerCapacityTextField;
    private javax.swing.JList airplaneRoutesList;
    private javax.swing.JButton airplaneSaveButton;
    private javax.swing.JPanel airportAttributesPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel routesLabel;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
