/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Service.AirplaneService;
import Service.AirportService;
import Service.ManagementProvider;
import Service.RouteService;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

/**
 *
 * @author M
 */
public class AirportAttributesDialog extends javax.swing.JDialog {

    private ManagementProvider mgProvider;
    private Object detached = null;

    public AirportAttributesDialog(java.awt.Frame parent, boolean modal, ManagementProvider managementProvider, Object o) {
        super(parent, modal);
        detached = o;
        initDialog(managementProvider);
    }

    public AirportAttributesDialog(java.awt.Frame parent, boolean modal, ManagementProvider managementProvider) {
        super(parent, modal);
        initDialog(managementProvider);
    }

    private void initDialog(ManagementProvider managementProvider) {
        mgProvider = managementProvider;
        initComponents();
        setLocationRelativeTo(null);
        initLists();
    }

    private void initLists() {
        airportDestinationList.setSelectionMode(SINGLE_SELECTION);
        airportOriginList.setSelectionMode(SINGLE_SELECTION);
        //airportOriginList.setListData(mgProvider.getAirportManager().findAll().toArray());
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
        jLabel1 = new javax.swing.JLabel();
        airportNameLabel = new javax.swing.JLabel();
        airportNameTextField = new javax.swing.JTextField();
        airportCityLabel = new javax.swing.JLabel();
        airportCityTextField = new javax.swing.JTextField();
        airportIcaoLabel = new javax.swing.JLabel();
        airportIcaoTextField = new javax.swing.JTextField();
        airportIataLabel = new javax.swing.JLabel();
        airportIataTextField = new javax.swing.JTextField();
        airportCountryTextField = new javax.swing.JTextField();
        airportCountryLabel = new javax.swing.JLabel();
        originScrollPane = new javax.swing.JScrollPane();
        airportOriginList = new javax.swing.JList();
        destinationScrollPane = new javax.swing.JScrollPane();
        airportDestinationList = new javax.swing.JList();
        airportSaveChangesButton = new javax.swing.JButton();
        airportDiscardChangesButton = new javax.swing.JButton();
        destinationsLabel = new javax.swing.JLabel();
        originsLabel = new javax.swing.JLabel();
        airportQuoteLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Airport Attributes");
        setBackground(new java.awt.Color(204, 204, 255));

        airportAttributesPanel.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Edit Airport Attributes");

        airportNameLabel.setText("Name:");

        airportNameTextField.setBackground(new java.awt.Color(52, 52, 56));
        airportNameTextField.setForeground(new java.awt.Color(255, 255, 255));

        airportCityLabel.setText("City:");

        airportCityTextField.setBackground(new java.awt.Color(52, 52, 56));
        airportCityTextField.setForeground(new java.awt.Color(255, 255, 255));

        airportIcaoLabel.setText("ICAO");

        airportIcaoTextField.setBackground(new java.awt.Color(52, 52, 56));
        airportIcaoTextField.setForeground(new java.awt.Color(255, 255, 255));

        airportIataLabel.setText("IATA");

        airportIataTextField.setBackground(new java.awt.Color(52, 52, 56));
        airportIataTextField.setForeground(new java.awt.Color(255, 255, 255));

        airportCountryTextField.setBackground(new java.awt.Color(52, 52, 56));
        airportCountryTextField.setForeground(new java.awt.Color(255, 255, 255));
        airportCountryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airportCountryTextFieldActionPerformed(evt);
            }
        });

        airportCountryLabel.setText("Country:");

        javax.swing.GroupLayout airportAttributesPanelLayout = new javax.swing.GroupLayout(airportAttributesPanel);
        airportAttributesPanel.setLayout(airportAttributesPanelLayout);
        airportAttributesPanelLayout.setHorizontalGroup(
            airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(airportAttributesPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(airportNameLabel)
                    .addComponent(airportCityLabel)
                    .addComponent(airportIcaoLabel)
                    .addComponent(airportIataLabel)
                    .addComponent(airportCountryLabel))
                .addGap(18, 18, 18)
                .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(airportCountryTextField)
                    .addComponent(airportIataTextField)
                    .addComponent(airportIcaoTextField)
                    .addComponent(airportCityTextField)
                    .addComponent(airportNameTextField))
                .addGap(25, 25, 25))
            .addGroup(airportAttributesPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        airportAttributesPanelLayout.setVerticalGroup(
            airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(airportAttributesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airportNameLabel)
                    .addComponent(airportNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airportCityLabel)
                    .addComponent(airportCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airportIcaoLabel)
                    .addComponent(airportIcaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airportIataLabel)
                    .addComponent(airportIataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(airportAttributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airportCountryLabel)
                    .addComponent(airportCountryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        airportOriginList.setBackground(new java.awt.Color(165, 165, 178));
        airportOriginList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        originScrollPane.setViewportView(airportOriginList);

        airportDestinationList.setBackground(new java.awt.Color(165, 165, 178));
        airportDestinationList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        destinationScrollPane.setViewportView(airportDestinationList);

        airportSaveChangesButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        airportSaveChangesButton.setText("Save changes");
        airportSaveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airportSaveChangesButtonActionPerformed(evt);
            }
        });

        airportDiscardChangesButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        airportDiscardChangesButton.setForeground(new java.awt.Color(179, 107, 12));
        airportDiscardChangesButton.setText("Discard changes");
        airportDiscardChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airportDiscardChangesButtonActionPerformed(evt);
            }
        });

        destinationsLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        destinationsLabel.setText("This Airport serves as  DESTINATION  in Routes:");

        originsLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        originsLabel.setText("This Airport serves as  ORIGIN  in Routes:");

        airportQuoteLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        airportQuoteLabel.setText("Configuration of Routes is done in Route tabb.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(destinationsLabel)
                    .addComponent(originsLabel)
                    .addComponent(originScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(airportQuoteLabel)
                    .addComponent(destinationScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(airportDiscardChangesButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(airportAttributesPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(airportSaveChangesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airportSaveChangesButton)
                    .addComponent(originsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(airportDiscardChangesButton)
                        .addGap(8, 8, 8)
                        .addComponent(airportAttributesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(originScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(destinationsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(destinationScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(airportQuoteLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void airportSaveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airportSaveChangesButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airportSaveChangesButtonActionPerformed

    private void airportDiscardChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airportDiscardChangesButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airportDiscardChangesButtonActionPerformed

    private void airportCountryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airportCountryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airportCountryTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(AirportAttributesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AirportAttributesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AirportAttributesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AirportAttributesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManagementProvider managementProvider = new ManagementProvider();
                managementProvider.setAirplaneManager(new AirplaneService());
                managementProvider.setAirportManager(new AirportService());
                managementProvider.setRouteManager(new RouteService());
                AirportAttributesDialog dialog = new AirportAttributesDialog(new javax.swing.JFrame(), true, managementProvider);
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
    private javax.swing.JPanel airportAttributesPanel;
    private javax.swing.JLabel airportCityLabel;
    private javax.swing.JTextField airportCityTextField;
    private javax.swing.JLabel airportCountryLabel;
    private javax.swing.JTextField airportCountryTextField;
    private javax.swing.JList airportDestinationList;
    private javax.swing.JButton airportDiscardChangesButton;
    private javax.swing.JLabel airportIataLabel;
    private javax.swing.JTextField airportIataTextField;
    private javax.swing.JLabel airportIcaoLabel;
    private javax.swing.JTextField airportIcaoTextField;
    private javax.swing.JLabel airportNameLabel;
    private javax.swing.JTextField airportNameTextField;
    private javax.swing.JList airportOriginList;
    private javax.swing.JLabel airportQuoteLabel;
    private javax.swing.JButton airportSaveChangesButton;
    private javax.swing.JScrollPane destinationScrollPane;
    private javax.swing.JLabel destinationsLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane originScrollPane;
    private javax.swing.JLabel originsLabel;
    // End of variables declaration//GEN-END:variables
}
