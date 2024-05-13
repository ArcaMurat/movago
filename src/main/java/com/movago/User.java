package com.movago;

import com.movago.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private String userName;
    private String profilePhotoString;
    private String bio;
    private ArrayList<Trip> ownedTrips;
    private ArrayList<Trip> joinedTrips;
    private ArrayList<Message> sendedMessages;
    private ArrayList<Message> receivedMessages;
    private ArrayList<Boolean> answers; // Stores answers to questions for matching purposes
    private String password;

    // Constructor to initialize a new user with their details and an empty list for trips and messages
    public User(String userName, String profilePhotoString, String bio, String password) {
        this.userName = userName;
        this.profilePhotoString = profilePhotoString;
        this.bio = bio;
        this.password = password;
        this.answers = new ArrayList<>(answers);
        this.ownedTrips = new ArrayList<>();
        this.joinedTrips = new ArrayList<>();
        this.sendedMessages = new ArrayList<>();
        this.receivedMessages = new ArrayList<>();     
    }
    
    public User(String userName, String bio){
        this.userName = userName;
        this.bio = bio;
    }
    
    public ArrayList<Trip> getJoinedTrips(){
        ArrayList<Trip> trips = new ArrayList<>();
            try {
                Connection con = DatabaseConnection.getDataSource().getConnection();
                Statement s = con.createStatement();
                String sql = "SELECT triptitle FROM movago.participant_table WHERE username= '"+userName+"'";
                
                ResultSet rs = s.executeQuery(sql);
                Trips tr = new Trips();
                while(rs.next()){
                    trips.add(tr.getTrip(rs.getString("triptitle")));
                }
                
            } catch (SQLException e) {
                System.out.println(e);
            }
        return trips;
    }




    // Calculates the matching ratio between this user and another user based on their answers to questions
    public double calculateMatchRatio(User otherUser) {
        int totalQuestions = Math.min(this.answers.size(), otherUser.answers.size());
        int similarAnswers = 0;

        for (int i = 0; i < totalQuestions; i++) {
            if (this.answers.get(i).equals(otherUser.answers.get(i))) {
                similarAnswers++;
            }
        }

        return (double) similarAnswers / totalQuestions;
    }
    
    public String getUserName(){
        return userName;
    }
    public String getBio(){
        return bio;
    }
}
