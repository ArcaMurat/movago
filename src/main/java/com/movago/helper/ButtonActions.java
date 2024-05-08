/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movago.helper;

import com.movago.connection.DatabaseConnection;
import com.movago.dashboard;
import com.movago.forms.SignUpForm;
import com.movago.forms.createTripForm;
import com.movago.startFrame;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Arca
 */
public class ButtonActions {
    
    private Component parentComponent;
    
    public ButtonActions(Component parentComponent){
        this.parentComponent = parentComponent;
    }
    
    public ButtonActions(){
        
    }
    
    public void insertAction (String username, String password, String bio, SignUpForm form){
        try {
            if(!username.isEmpty() && !password.isEmpty() && !bio.isEmpty()){
                Connection con = DatabaseConnection.getDataSource().getConnection();
                Statement s = con.createStatement();
                s.executeUpdate("INSERT INTO movago.usertable (username, password, bio) VALUES ('"+username+"', '"+password+"', '"+bio+"')");
                JOptionPane.showMessageDialog(form,"You successfully signed up!", "System Message", JOptionPane.INFORMATION_MESSAGE);
                form.dispose();
            } else{
                if(username.isEmpty()){
                    JOptionPane.showMessageDialog(form, "username field is empty, please fill it!");
                }
                if(password.isEmpty()){
                    JOptionPane.showMessageDialog(form, "password field is empty, please fill it!");
                }
                if(bio.isEmpty()){
                    JOptionPane.showMessageDialog(form, "biography field is empty, please fill it!");                    
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void createTripAction (String titleString ,int participantsCount, String fromString, String firstCityString, String secondCityString,
            String thirdCityString, String accomodationString, String accomodation2String, String accomodation3String,String firstDateString, String dateString, String date2String, String date3String,
            double budget, double budget2, double budget3, createTripForm form){
        try {
            if(!titleString.isEmpty() && !fromString.isEmpty() && !firstCityString.isEmpty() && !accomodationString.isEmpty() && !dateString.isEmpty()){
                Connection con = DatabaseConnection.getDataSource().getConnection();
                Statement s = con.createStatement();
                s.executeUpdate("INSERT INTO movago.triptable (title, participantCount, `from`, firstCity, secondCity, thirdCity, accomodation, accomodation2, accomodation3, firstDate, `date`, date2, date3, budget, budget2, budget3) " +
                                "VALUES ('"+titleString+"', '"+participantsCount+"','"+fromString+"','"+firstCityString+"','"+secondCityString+"','"+thirdCityString+"', '"+accomodationString+"', '"+accomodation2String+"', '"+accomodation3String+"', '"+firstDateString+"', '"+dateString+"', '"+date2String+"', '"+date3String+"', '"+budget+"', '"+budget2+"', '"+budget3+"')");
                JOptionPane.showMessageDialog(form, "You successfully created a trip!", "System Message", JOptionPane.INFORMATION_MESSAGE);
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
public void signIn(String username, String password, JLabel warningLabel,  startFrame form) {
    try {
        Connection con = DatabaseConnection.getDataSource().getConnection();
        String sql = "SELECT password FROM movago.usertable WHERE username = ?";
        String warningMessage = "";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, username);
        ResultSet rs = p.executeQuery();
        
        if (rs.next()) { // Move the cursor to the first row
            String storedPassword = rs.getString("password");
            System.out.println(storedPassword + "   " + password);
            
            if (storedPassword.equals(password)) {
                JOptionPane.showMessageDialog(form, "Welcome to Voyago");
                form.dispose();
                dashboard dashboard = new dashboard();
                dashboard.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(form, "Incorrect password please try again.");
                warningLabel.setText("Incorrect password please try again.");
            }
        } else {
            JOptionPane.showMessageDialog(form, "Username not found please try again or sign up.");
            warningLabel.setText("Username not found please try again or sign up.");
        }
        
        rs.close();
        p.close();
        con.close();
    } catch (SQLException e) {
        System.out.println(e);
    }
}

}
