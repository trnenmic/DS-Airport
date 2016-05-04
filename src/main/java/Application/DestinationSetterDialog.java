package Application;

import Application.GUIDesigners.BoundingUpdater;
import Model.Airport;
import Model.Route;
import Service.AirplaneService;
import Service.AirportService;
import Service.ManagementProvider;
import Service.RouteService;
import Validator.InvalidAttributeException;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

/**
 *
 * @author M
 */
public class DestinationSetterDialog extends javax.swing.JDialog {

    private ManagementProvider mgProvider;
    private Object detached = null;
    private BoundingUpdater boundingUpdater;

    private String name = null;
    private String city = null;
    private String country = null;
    private String iata = null;
    private String icao = null;

    public DestinationSetterDialog(java.awt.Frame parent, boolean modal, ManagementProvider managementProvider, Object o, BoundingUpdater boundingUpdater) {
        super(parent, modal);
        detached = o;
        this.boundingUpdater = boundingUpdater;
        initDialog(managementProvider);
    }

    private void initDialog(ManagementProvider managementProvider) {
        mgProvider = managementProvider;
        initComponents();
        setLocationRelativeTo(null);
        initLists();
    }

    private void initLists() {
        airportsList.setSelectionMode(SINGLE_SELECTION);
        updateLists();
    }

    private void updateLists() {
        airportsList.setListData(mgProvider.getAirportManager().findSpecified(name,
                city, country, icao, iata).toArray());
        updateTextFields();
    }

    private void updateTextFields() {
        Route route = (Route) detached;
        if (route.getDestination() != null) {
            destinationNameTextField.setText(route.getDestination().getAirportName());
            destinationCityTextField.setText(route.getDestination().getCity());
            destinationCountryTextField.setText(route.getDestination().getCountry());
            destinationIataTextField.setText(route.getDestination().getIata());
            destinationIcaoTextField.setText(route.getDestination().getIcao());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        destinationFilterLabel = new javax.swing.JLabel();
        routeNameLabel1 = new javax.swing.JLabel();
        routeCityLabel1 = new javax.swing.JLabel();
        routeIcaoLabel1 = new javax.swing.JLabel();
        routeIataLabel1 = new javax.swing.JLabel();
        routeIataLabel4 = new javax.swing.JLabel();
        destinationCityTextField = new javax.swing.JTextField();
        destinationIcaoTextField = new javax.swing.JTextField();
        destinationIataTextField = new javax.swing.JTextField();
        destinationCountryTextField = new javax.swing.JTextField();
        destinationNameTextField = new javax.swing.JTextField();
        airplanesScrollPane = new javax.swing.JScrollPane();
        airportsList = new javax.swing.JList();
        applyFilterAirplaneButton = new javax.swing.JButton();
        DestinationSelectorButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        airportFilterLabel = new javax.swing.JLabel();
        airportNameLabel = new javax.swing.JLabel();
        airportCityLabel = new javax.swing.JLabel();
        airportCountryLabel = new javax.swing.JLabel();
        airportCountryTextField = new javax.swing.JTextField();
        airportCityTextField = new javax.swing.JTextField();
        airportNameTextField = new javax.swing.JTextField();
        airportIcaoLabel = new javax.swing.JLabel();
        airportIataLabel = new javax.swing.JLabel();
        airportIataTextField = new javax.swing.JTextField();
        airportIcaoTextField = new javax.swing.JTextField();
        warningLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        destinationFilterLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        destinationFilterLabel.setText("Destination Airport:");

        routeNameLabel1.setText("Name:");

        routeCityLabel1.setText("City:");

        routeIcaoLabel1.setText("ICAO:");

        routeIataLabel1.setText("IATA:");

        routeIataLabel4.setText("Country:");

        destinationCityTextField.setEditable(false);
        destinationCityTextField.setBackground(new java.awt.Color(165, 165, 178));
        destinationCityTextField.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        destinationCityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationCityTextFieldActionPerformed(evt);
            }
        });

        destinationIcaoTextField.setEditable(false);
        destinationIcaoTextField.setBackground(new java.awt.Color(165, 165, 178));
        destinationIcaoTextField.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        destinationIcaoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationIcaoTextFieldActionPerformed(evt);
            }
        });

        destinationIataTextField.setEditable(false);
        destinationIataTextField.setBackground(new java.awt.Color(165, 165, 178));
        destinationIataTextField.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        destinationIataTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationIataTextFieldActionPerformed(evt);
            }
        });

        destinationCountryTextField.setEditable(false);
        destinationCountryTextField.setBackground(new java.awt.Color(165, 165, 178));
        destinationCountryTextField.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        destinationCountryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationCountryTextFieldActionPerformed(evt);
            }
        });

        destinationNameTextField.setEditable(false);
        destinationNameTextField.setBackground(new java.awt.Color(165, 165, 178));
        destinationNameTextField.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        destinationNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationNameTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(routeCityLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(destinationCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(routeIcaoLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(destinationIcaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(routeIataLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(destinationIataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(routeIataLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(destinationCountryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(routeNameLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(destinationNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(destinationFilterLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(destinationFilterLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(routeNameLabel1)
                    .addComponent(destinationNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(routeCityLabel1)
                    .addComponent(destinationCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(routeIcaoLabel1)
                    .addComponent(destinationIcaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(routeIataLabel1)
                    .addComponent(destinationIataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(routeIataLabel4)
                    .addComponent(destinationCountryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        airportsList.setBackground(new java.awt.Color(52, 52, 56));
        airportsList.setForeground(new java.awt.Color(255, 255, 255));
        airportsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        airplanesScrollPane.setViewportView(airportsList);

        applyFilterAirplaneButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        applyFilterAirplaneButton.setForeground(new java.awt.Color(25, 62, 137));
        applyFilterAirplaneButton.setText("Apply filter");
        applyFilterAirplaneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyFilterAirplaneButtonActionPerformed(evt);
            }
        });

        DestinationSelectorButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        DestinationSelectorButton.setText("Set selected");
        DestinationSelectorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinationSelectorButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        airportFilterLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        airportFilterLabel.setText("Filter settings for Airport:");

        airportNameLabel.setText("Name:");

        airportCityLabel.setText("City:");

        airportCountryLabel.setText("Country:");

        airportCountryTextField.setBackground(new java.awt.Color(52, 52, 56));
        airportCountryTextField.setForeground(new java.awt.Color(255, 255, 255));

        airportCityTextField.setBackground(new java.awt.Color(52, 52, 56));
        airportCityTextField.setForeground(new java.awt.Color(255, 255, 255));

        airportNameTextField.setBackground(new java.awt.Color(52, 52, 56));
        airportNameTextField.setForeground(new java.awt.Color(255, 255, 255));

        airportIcaoLabel.setText("ICAO:");

        airportIataLabel.setText("IATA:");

        airportIataTextField.setBackground(new java.awt.Color(52, 52, 56));
        airportIataTextField.setForeground(new java.awt.Color(255, 255, 255));

        airportIcaoTextField.setBackground(new java.awt.Color(52, 52, 56));
        airportIcaoTextField.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(airportNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(airportNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(airportCityLabel)
                                    .addComponent(airportCountryLabel))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(airportCountryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(airportCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(airportIcaoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(airportIcaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(airportIataLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(airportIataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(airportFilterLabel)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(airportFilterLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airportNameLabel)
                    .addComponent(airportIcaoLabel)
                    .addComponent(airportNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(airportIcaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airportCityLabel)
                    .addComponent(airportCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(airportIataLabel)
                    .addComponent(airportIataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airportCountryLabel)
                    .addComponent(airportCountryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        warningLabel.setForeground(new java.awt.Color(204, 0, 0));
        warningLabel.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(airplanesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(applyFilterAirplaneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DestinationSelectorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(warningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(applyFilterAirplaneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DestinationSelectorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(airplanesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(warningLabel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void destinationNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationNameTextFieldActionPerformed

    private void destinationCountryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationCountryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationCountryTextFieldActionPerformed

    private void destinationIataTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationIataTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationIataTextFieldActionPerformed

    private void destinationIcaoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationIcaoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationIcaoTextFieldActionPerformed

    private void destinationCityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationCityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationCityTextFieldActionPerformed

    private void DestinationSelectorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DestinationSelectorButtonActionPerformed
        if (airportsList.getSelectedValue() != null) {
            Route route = (Route) detached;
            Airport destination;
            if (route.getDestination() != null) {
                destination = route.getDestination();
                destination.getDestinations().remove((Route) detached);
                boundingUpdater.addAirport(destination);
            }
            destination = (Airport) airportsList.getSelectedValue();
            route.setDestination(destination);
            destination.addDestination(route);
        }
        updateTextFields();
    }//GEN-LAST:event_DestinationSelectorButtonActionPerformed

    private void applyFilterAirplaneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyFilterAirplaneButtonActionPerformed
        warningLabel.setText(" ");
        name = (airportNameTextField.getText().equals("") ? null : airportNameTextField.getText());
        city = (airportCityTextField.getText().equals("") ? null : airportCityTextField.getText());
        country = (airportCountryTextField.getText().equals("") ? null : airportCountryTextField.getText());
        iata = (airportIataTextField.getText().equals("") ? null : airportIataTextField.getText());
        icao = (airportIcaoTextField.getText().equals("") ? null : airportIcaoTextField.getText());
        updateLists();
    }//GEN-LAST:event_applyFilterAirplaneButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DestinationSetterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DestinationSetterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DestinationSetterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DestinationSetterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManagementProvider managementProvider = new ManagementProvider();
                managementProvider.setAirplaneManager(new AirplaneService());
                managementProvider.setAirportManager(new AirportService());
                managementProvider.setRouteManager(new RouteService());
                DestinationSetterDialog dialog = new DestinationSetterDialog(new javax.swing.JFrame(),
                        true, managementProvider, Airport.createAirport("", "", "", "", ""), new BoundingUpdater(managementProvider));
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
    private javax.swing.JButton DestinationSelectorButton;
    private javax.swing.JScrollPane airplanesScrollPane;
    private javax.swing.JLabel airportCityLabel;
    private javax.swing.JTextField airportCityTextField;
    private javax.swing.JLabel airportCountryLabel;
    private javax.swing.JTextField airportCountryTextField;
    private javax.swing.JLabel airportFilterLabel;
    private javax.swing.JLabel airportIataLabel;
    private javax.swing.JTextField airportIataTextField;
    private javax.swing.JLabel airportIcaoLabel;
    private javax.swing.JTextField airportIcaoTextField;
    private javax.swing.JLabel airportNameLabel;
    private javax.swing.JTextField airportNameTextField;
    private javax.swing.JList airportsList;
    private javax.swing.JButton applyFilterAirplaneButton;
    private javax.swing.JTextField destinationCityTextField;
    private javax.swing.JTextField destinationCountryTextField;
    private javax.swing.JLabel destinationFilterLabel;
    private javax.swing.JTextField destinationIataTextField;
    private javax.swing.JTextField destinationIcaoTextField;
    private javax.swing.JTextField destinationNameTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel routeCityLabel1;
    private javax.swing.JLabel routeIataLabel1;
    private javax.swing.JLabel routeIataLabel4;
    private javax.swing.JLabel routeIcaoLabel1;
    private javax.swing.JLabel routeNameLabel1;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
