/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movago.helper;

import com.movago.User;
import com.movago.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Arca
 */
public class RatioManager {
    public ArrayList<String> getAnswers(String username){
        ArrayList<String> answers = new ArrayList<String>();
        try {
            Connection con = DatabaseConnection.getDataSource().getConnection();
            Statement s = con.createStatement();
            String sql = "SELECT * FROM movago.questiontable WHERE username = '"+username+"'";
            ResultSet rs = s.executeQuery(sql);
            
            if(rs.next()){
                answers.add(rs.getString("question1"));
                answers.add(rs.getString("question2"));
                answers.add(rs.getString("question3"));
                answers.add(rs.getString("question4"));
                answers.add(rs.getString("question5"));
                answers.add(rs.getString("question6"));
                answers.add(rs.getString("question7"));
                answers.add(rs.getString("question8"));
                answers.add(rs.getString("question9"));
                answers.add(rs.getString("question10"));
                answers.add(rs.getString("question11"));
                answers.add(rs.getString("question12"));
                answers.add(rs.getString("question13"));
                answers.add(rs.getString("question14"));
            }
       
        } catch (SQLException e) {
            System.out.println(e);
        }
        return answers;
    }
    
    public int calculateRatio(String username, String otherUserName){
        ArrayList<String> userAnswers = getAnswers(username);
        ArrayList<String> otherAnswers = getAnswers(otherUserName);
        int ratio = 58;
        
        for(int i = 0; i < userAnswers.size(); i++){
            if(userAnswers.get(i).equals(otherAnswers.get(i))){
                ratio += 3;
            }
        }
        return ratio;
    }
    
    public ArrayList<String> getUserNames(){
        ArrayList<String> usernames = new ArrayList<String>();
        try {
            Connection con = DatabaseConnection.getDataSource().getConnection();
            Statement s = con.createStatement();
            String sql  = "SELECT username FROM movago.questiontable";
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
    
    public void fillRatioTable(String username){
        try {
            Connection con = DatabaseConnection.getDataSource().getConnection();
            Statement s = con.createStatement();
           
            ArrayList<String> usernames = getUserNames();
            
            for(int i = 0; i < usernames.size(); i++){
                int ratio;
                ratio = calculateRatio(username, usernames.get(i));
                System.out.println(username + " " + usernames.get(i) + ratio);
                String sql = "INSERT INTO movago.ratio_table (user, usertwo, ratio) VALUES ('"+username+"', '"+usernames.get(i)+"', '"+ratio+"')";
                s.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
    
    
}
