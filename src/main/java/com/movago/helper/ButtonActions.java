/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movago.helper;

import com.movago.User;
import com.movago.connection.DatabaseConnection;
import com.movago.dashboard;
import com.movago.forms.SignUpForm;
import com.movago.forms.createTripForm;
import com.movago.startFrame;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    
    public void createTripAction (String titleString, String ownerUserName,double participantsCount, String fromString, String firstCityString, String secondCityString,
            String thirdCityString, String accomodationString, String accomodation2String, String accomodation3String,Date firstDateString, Date date, Date date2, Date date3,
            double budget, double budget2, double budget3, createTripForm form){
        try {
            if(!titleString.isEmpty() && !fromString.isEmpty() && !firstCityString.isEmpty() && !accomodationString.isEmpty()){
                Connection con = DatabaseConnection.getDataSource().getConnection();
                Statement s = con.createStatement();
                s.executeUpdate("INSERT INTO movago.triptable (title, ownerUserName, participantCount, `from`, firstCity, secondCity, thirdCity, accomodation, accomodation2, accomodation3, firstDate, `date`, date2, date3, budget, budget2, budget3) " +
                                "VALUES ('"+titleString+"','"+ownerUserName+"', '"+participantsCount+"','"+fromString+"','"+firstCityString+"','"+secondCityString+"','"+thirdCityString+"', '"+accomodationString+"', '"+accomodation2String+"', '"+accomodation3String+"', '"+firstDateString+"', '"+date+"', '"+date2+"', '"+date3+"', '"+budget+"', '"+budget2+"', '"+budget3+"')");
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
                    User currentUser = new User(username,"biotest");
                    dashboard dashboard = new dashboard(currentUser);
                    dashboard.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(form, "Incorrect password please try again.");
                    warningLabel.setText("Incorrect password please try again.");
                    warningLabel.setForeground(Color.red);
                }
            } else {
                JOptionPane.showMessageDialog(form, "Username not found please try again or sign up.");
                warningLabel.setText("Username not found please try again or sign up.");
                warningLabel.setForeground(Color.red);
            }

            rs.close();
            p.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void sendMessage (JTextField textField, User user, JLabel receiverNameLabel){
        try (Connection con = DatabaseConnection.getDataSource().getConnection();
                Statement s = con.createStatement();){
            String message = textField.getText();
            String sender = user.getUserName();
            String receiver = receiverNameLabel.getText();
            String sql = "INSERT INTO movago.messagetable (sender, receiver, message) VALUES ('"+sender+"', '"+receiver+"', '"+message+"')";
            s.executeUpdate(sql);

        } catch (SQLException e) {
                System.out.println(e);
        }
    }

}
