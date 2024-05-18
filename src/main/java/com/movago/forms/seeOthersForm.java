/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.movago.forms;

import com.movago.MainForm;
import com.movago.Trip;
import com.movago.User;
import com.movago.connection.DatabaseConnection;
import com.movago.helper.RatioManager;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Arca
 */
public class seeOthersForm extends javax.swing.JPanel {
    ArrayList<String> usernames;
    Trip t;
    User user;
    MainForm mainform;
    /**
     * Creates new form seeOthersForm
     */
    public seeOthersForm(User user, Trip t, MainForm mainform) {
        this.t = t;
        this.user = user;
        this.mainform = mainform;
        initComponents();
        fillScrollPane();
    }
    
    
    public ArrayList<String> retrieveParticipants(){
        ArrayList<String> usernames = new ArrayList<String>();
        try {
            Connection con = DatabaseConnection.getDataSource().getConnection();
            String sql = "SELECT username FROM movago.participant_table WHERE triptitle = '"+t.getTitle()+"'";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
                String username = rs.getString("username");
                usernames.add(username);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return usernames;
    }
    
    public void fillScrollPane(){
        RatioManager rm  = new RatioManager();
        usernames = retrieveParticipants();

        for(String username : usernames){
            
            JPanel jpanel = new JPanel();
            jpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            Dimension panelSize = new Dimension(700,150);
            jpanel.setPreferredSize(panelSize);
            jpanel.setMinimumSize(panelSize);
            jpanel.setMaximumSize(panelSize);
            
            JLabel label = new JLabel();
            Dimension labelSize = new Dimension(600,120);
            label.setPreferredSize(labelSize);
            label.setMinimumSize(labelSize);
            label.setMaximumSize(labelSize);
            label.setText(username + "     " + rm.calculateRatio(user.getUserName(), username));
            
            JButton button = new JButton();
            Dimension buttonSize = new Dimension(50,50);
            button.setPreferredSize(buttonSize);
            button.setMinimumSize(buttonSize);
            button.setMaximumSize(buttonSize);
            
            button.setIcon(new javax.swing.ImageIcon("C:\\Users\\Arca\\Belgeler\\NetBeansProjects\\movago\\src\\main\\java\\com\\movago\\img\\Cancel.png"));
            
            jpanel.add(label);
            jpanel.add(button);
            
            jpanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            
            button.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        if(user.getUserName().equals(t.getOwnerName())){
                            discardUser(username);
                            JOptionPane.showMessageDialog(mainform, "User discarded.");
                            jPanel1.removeAll();
                            fillScrollPane();
                            
                        }
                        else{
                            JOptionPane.showMessageDialog(mainform, "Only the owner can discard participants.");
                        }
                    }
                });
            
            jPanel1.add(jpanel);
        }
        jPanel1.revalidate();
        jPanel1.repaint();
        
    }
    
    public void discardUser(String userDiscard){
        try {
            int currentCount = t.getcurrentCount() - 1;
            Connection con = DatabaseConnection.getDataSource().getConnection();
            String parsql = "DELETE FROM movago.participant_table WHERE username = '" + userDiscard + "'";

            String trSql = "UPDATE movago.triptable SET currentCount = '" + currentCount + "' WHERE title = '" + t.getTitle() + "'";
   
            Statement s = con.createStatement();
            
            s.executeUpdate(parsql);
            s.executeUpdate(trSql);

        } catch (SQLException e) {
            System.out.println(e);
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

        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titleLabel.setText("title");

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
