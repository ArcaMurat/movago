/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movago;

import com.movago.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Arca
 */
public class Trips {
    public ArrayList<Trip> getAllTrips(){
        ArrayList<Trip> trips = new ArrayList<>();
        try {
            Connection con = DatabaseConnection.getDataSource().getConnection();
            String sql = "SELECT * FROM movago.triptable";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            
            while(rs.next()){

                
                String title = rs.getString("title");
                String ownerName = rs.getString("ownerUserName");
                int participantsLimit = rs.getInt("participantCount");


                String from = rs.getString("from") ;
                String startDate = rs.getString("firstDate") ;

                String city = rs.getString("firstCity") ;
                String city2 = rs.getString("secondCity") ;
                String city3 = rs.getString("thirdCity");

                String accommodation = rs.getString("accomodation");
                String accommodation2 = rs.getString("accomodation2");
                String accommodation3 = rs.getString("accomodation3");

                Date firstDate = rs.getDate("firstDate");
                Date date = rs.getDate("date");
                Date date2 = rs.getDate("date2");
                Date date3  = rs.getDate("date3");

                String photoString1;
                String photoString2;
                String photoString3;

                double budget = rs.getDouble("budget");
                double budget2 = rs.getDouble("budget2");
                double budget3 = rs.getDouble("budget3");
                
                int currentCount = rs.getInt("currentCount");

                Trip trip = new Trip(title, ownerName, participantsLimit, from, startDate, city, city2, city3, accommodation, accommodation2, accommodation3, firstDate, date, date2, date3, budget, budget2, budget3, currentCount);
                trips.add(trip);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            return trips;
        }
    }
    
    public Trip getTrip(String title){
        for(Trip t : getAllTrips()){
            if(t.getTitle().equals(title)){
                return t;
            }
        }
        return null;
    }
    
    public ArrayList<Trip> getAllTripsSortedByBudget() {
        ArrayList<Trip> trips = getAllTrips(); // Fetch the trips

        Collections.sort(trips, new Comparator<Trip>() {
            @Override
            public int compare(Trip t1, Trip t2) {
                return Double.compare(t2.getTotalBudget(), t1.getTotalBudget());
            }
        });

        return trips;
    }
    public ArrayList<Trip> getAllTripsSortedByBudget(ArrayList<Trip> trips) {
        Collections.sort(trips, new Comparator<Trip>() {
            @Override
            public int compare(Trip t1, Trip t2) {
                return Double.compare(t2.getTotalBudget(), t1.getTotalBudget());
            }
        });

        return trips;
    }
    
    public ArrayList<Trip> getAllTripsSortedByBudgetDescending() {
        ArrayList<Trip> trips = getAllTrips();

        Collections.sort(trips, new Comparator<Trip>() {
            @Override
            public int compare(Trip t1, Trip t2) {

                return Double.compare(t1.getTotalBudget(), t2.getTotalBudget());
            }
        });

        return trips;
    }
    public ArrayList<Trip> getAllTripsSortedByBudgetDescending(ArrayList<Trip> trips) {

        Collections.sort(trips, new Comparator<Trip>() {
            @Override
            public int compare(Trip t1, Trip t2) {
                return Double.compare(t1.getTotalBudget(), t2.getTotalBudget());
            }
        });

        return trips;
    }
    
    public ArrayList<Trip> filterTripsByBudget(double minBudget, double maxBudget) {
        Trips tr = new Trips();
        ArrayList<Trip> trips = tr.getAllTrips(); // Fetch all trips
        ArrayList<Trip> filteredTrips = new ArrayList<>(); // To store filtered trips

        for (Trip trip : trips) {
            double totalBudget = trip.getTotalBudget();
            if (totalBudget >= minBudget && totalBudget <= maxBudget) {
                filteredTrips.add(trip);
            }
        }
        return filteredTrips;
    }
    
    public ArrayList<Trip> filterTripsByOrigin(String origin) {
        ArrayList<Trip> trips = getAllTrips(); // Fetch all trips
        ArrayList<Trip> filteredTrips = new ArrayList<>(); // To store filtered trips

        for (Trip trip : trips) {
            if (trip.getFrom().equalsIgnoreCase(origin)) {
                filteredTrips.add(trip);
            }
        }
        return filteredTrips;
    }
    public ArrayList<Trip> filterTripsByOrigin(String origin, ArrayList<Trip> trips) {
        ArrayList<Trip> filteredTrips = new ArrayList<>(); // To store filtered trips

        for (Trip trip : trips) {
            if (trip.getFrom().equalsIgnoreCase(origin)) {
                filteredTrips.add(trip);
            }
        }
        return filteredTrips;
    }
}

