/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movago.helper;

import com.movago.connection.DatabaseConnection;
import com.movago.forms.SignUpForm;
import com.movago.forms.createTripForm;
import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
            String thirdCityString, String accomodationString, String accomodation2String, String accomodation3String, String dateString, String date2String, String date3String,
            long budget, long budget2, long budget3, createTripForm form){
        try {
            if(!titleString.isEmpty() && !fromString.isEmpty() && !firstCityString.isEmpty() && !accomodationString.isEmpty() && !dateString.isEmpty()){
                Connection con = DatabaseConnection.getDataSource().getConnection();
                Statement s = con.createStatement();
                //s.executeUpdate("INSERT INTO movago.triptable (titleString, participantsCount, fromString, firstCityString, secondCityString, thirdCityString, accomodationString, accomodation2String, accomodation3String, dateString, date2String, date3String, budget, budget2, budget3)"
                  //      + "VALUES ('"++"', '"++"','"++"','"++"','"++"','"++"')");
                JOptionPane.showMessageDialog(form, "You successfully created a trip!", "System Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }
    }
}
