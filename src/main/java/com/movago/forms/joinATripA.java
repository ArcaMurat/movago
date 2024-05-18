/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.movago.forms;

import com.movago.MainForm;
import com.movago.Trip;
import com.movago.Trips;
import com.movago.User;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author Arca
 */
public class joinATripA extends javax.swing.JPanel {
        ArrayList<Trip> trips = new ArrayList<>();
        ArrayList<JTextPane> textPanes = new ArrayList<>();
        ArrayList<JButton> jButtons = new ArrayList<>();
        User user;
        MainForm mainForm;
    /**
     * Creates new form joinATrip
     */
    public joinATripA() {
        initComponents();
        retrieveData();
        
    }
    public joinATripA(User user, MainForm mainForm) {
        this.mainForm = mainForm;
        this.user = user;
        initComponents();
        retrieveData();
        
    }
    
    
    private void retrieveData(){
        try {
            
            
            Trips tr = new Trips();
            
            if(!budgetField1.getText().isEmpty() && !budgetField2.getText().isEmpty()){
                trips = tr.filterTripsByBudget(Double.parseDouble(budgetField1.getText()), Double.parseDouble(budgetField2.getText()));
                if(budgetIncSort.isSelected()){
                    trips = tr.getAllTripsSortedByBudget(trips);
                }
                else if(BudgetDecSort.isSelected()){
                    trips = tr.getAllTripsSortedByBudgetDescending(trips);
                }
            }
            else{
                if(budgetIncSort.isSelected()){
                    trips= tr.getAllTripsSortedByBudget();
                }
                else if(BudgetDecSort.isSelected()){
                    trips = tr.getAllTripsSortedByBudgetDescending();
                }
                else{
                    trips = tr.getAllTrips();
                }              
            }

            jPanel2.removeAll();
            for(Trip t : trips){
                
                JPanel jpanel = new JPanel();
                jpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                Dimension panelSize = new Dimension(650,170);
                jpanel.setPreferredSize(panelSize);
                jpanel.setMinimumSize(panelSize);
                jpanel.setMaximumSize(panelSize);
                
                JTextPane jTextPane = new JTextPane();
                Dimension textPaneSize = new Dimension(500,170);
                jTextPane.setPreferredSize(textPaneSize);
                jTextPane.setMinimumSize(textPaneSize);
                jTextPane.setMaximumSize(textPaneSize);
                jTextPane.setEditable(false);
                jTextPane.setHighlighter(null);
                
                JButton jButton = new JButton();
                Dimension buttonSize = new Dimension(120,150);
                jButton.setPreferredSize(buttonSize);
                jButton.setMaximumSize(buttonSize);
                jButton.setMinimumSize(buttonSize);
                jButton.setText("See Details");
                
                jpanel.add(jButton);
                jpanel.add(jTextPane);
                
                
                jpanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
                
                jButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        TripPage tripPage = new TripPage(t,user,mainForm);
                        mainForm.displayForm(tripPage);
                    }
                });
                
                
                String html = "<h2 style=\"text-align: center;\"><strong>Title: "+t.getTitle()+"</strong>&nbsp; &nbsp;&nbsp;</h2>\n" +
                              "<p>From: "+t.getFrom()+"&nbsp; &nbsp;<span style=\"color: #3366ff;\">✈</span>&nbsp; &nbsp;Arrival: "+t.getCity()+"&nbsp; <span style=\"color: #3366ff;\">✈</span>&nbsp; Arrival:"+t.getCity2()+"&nbsp; <span style=\"color: #3366ff;\"><strong>✈</strong></span>&nbsp; Final Destination: "+t.getCity3()+"</p>\n" +
                                    "<p>Start - End Date: "+t.getfirstDate()+" - "+t.getDate3()+" &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Budget: "+t.getTotalBudget()+"</p><p><span style=\"color: #800080\">Owner:</span> "+t.getOwnerName()+"&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>";
                
                jTextPane.setContentType("text/html");
                jTextPane.setText(html);
               
                jPanel2.add(jpanel);
            }

        jPanel2.revalidate();
        jPanel2.repaint();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private String formatDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date);
    }
    
    
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        FilterSortPanel = new javax.swing.JPanel();
        filterLabel = new javax.swing.JLabel();
        budgetIncSort = new javax.swing.JRadioButton();
        BudgetDecSort = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        budgetField1 = new javax.swing.JTextField();
        budgetField2 = new javax.swing.JTextField();
        applyFilterButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Arca\\Belgeler\\NetBeansProjects\\movago\\src\\main\\java\\com\\movago\\img\\Query Inner Join.png")); // NOI18N
        jLabel1.setText("Join Trips");

        jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(jPanel2);

        FilterSortPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        filterLabel.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        filterLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        filterLabel.setText("Sorts and Filters");

        buttonGroup1.add(budgetIncSort);
        budgetIncSort.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        budgetIncSort.setText("Budget Descending");
        budgetIncSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budgetIncSortActionPerformed(evt);
            }
        });

        buttonGroup1.add(BudgetDecSort);
        BudgetDecSort.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        BudgetDecSort.setText("Budget Ascending");
        BudgetDecSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BudgetDecSortActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel2.setText("Budget:");

        budgetField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budgetField1ActionPerformed(evt);
            }
        });

        applyFilterButton.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        applyFilterButton.setText("Apply Filters");
        applyFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyFilterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FilterSortPanelLayout = new javax.swing.GroupLayout(FilterSortPanel);
        FilterSortPanel.setLayout(FilterSortPanelLayout);
        FilterSortPanelLayout.setHorizontalGroup(
            FilterSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterSortPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FilterSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BudgetDecSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FilterSortPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(budgetIncSort, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FilterSortPanelLayout.createSequentialGroup()
                        .addGroup(FilterSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FilterSortPanelLayout.createSequentialGroup()
                                .addComponent(budgetField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(budgetField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(FilterSortPanelLayout.createSequentialGroup()
                .addGroup(FilterSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyFilterButton))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        FilterSortPanelLayout.setVerticalGroup(
            FilterSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterSortPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(budgetIncSort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BudgetDecSort)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FilterSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(budgetField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(budgetField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(applyFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FilterSortPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 72, Short.MAX_VALUE))
                    .addComponent(FilterSortPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 882, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void budgetIncSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetIncSortActionPerformed
        retrieveData();
    }//GEN-LAST:event_budgetIncSortActionPerformed

    private void BudgetDecSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BudgetDecSortActionPerformed
        retrieveData();
    }//GEN-LAST:event_BudgetDecSortActionPerformed

    private void budgetField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_budgetField1ActionPerformed

    private void applyFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyFilterButtonActionPerformed
        retrieveData();
    }//GEN-LAST:event_applyFilterButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BudgetDecSort;
    private javax.swing.JPanel FilterSortPanel;
    private javax.swing.JButton applyFilterButton;
    private javax.swing.JTextField budgetField1;
    private javax.swing.JTextField budgetField2;
    private javax.swing.JRadioButton budgetIncSort;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
