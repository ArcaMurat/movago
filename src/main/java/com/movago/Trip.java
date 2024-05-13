package com.movago;

import java.util.ArrayList;
import java.sql.Date;

public class Trip {

    String ownerName;
    String title;
    int participantsLimit;

    
    String from ;

    String city ;
    String city2 ;
    String city3 ;

    String accommodation ;
    String accommodation2 ;
    String accommodation3 ;

    Date firstDate;
    Date date;
    Date date2;
    Date date3;
/**
    String photoString1;
    String photoString2;
    String photoString3;
*/
    double budget;
    double budget2;
    double budget3;
    


    public Trip(String title, String ownerName, int participantsLimit, String from,
            String startDate, String city, String city2, String city3, String accommodation, String accommodation2,
            String accommodation3,Date firstDate, Date date, Date date2, Date date3,double budget, double budget2, double budget3) {
        
        this.ownerName = ownerName;
        this.title = title;
        this.participantsLimit = participantsLimit;
        this.from = from;
        this.city = city;
        this.city2 = city2;
        this.city3 = city3;
        this.accommodation = accommodation;
        this.accommodation2 = accommodation2;
        this.accommodation3 = accommodation3;
        this.firstDate = firstDate;
        this.date = date;
        this.date2 = date2;
        this.date3 = date3;
        
        /**
        this.photoString1 = photoString1;
        this.photoString2 = photoString2;
        this.photoString3 = photoString3;
        */
        this.budget = budget;
        this.budget2 = budget2;
        this.budget3 = budget3;
    }
    
    
    
    
    public double getTotalBudget() {
        return budget + budget2 + budget3;
    }
    
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getParticipantsLimit() {
        return participantsLimit;
    }

    public void setParticipantsLimit(int participantsLimit) {
        this.participantsLimit = participantsLimit;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public String getCity3() {
        return city3;
    }

    public void setCity3(String city3) {
        this.city3 = city3;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public String getAccommodation2() {
        return accommodation2;
    }

    public void setAccommodation2(String accommodation2) {
        this.accommodation2 = accommodation2;
    }

    public String getAccommodation3() {
        return accommodation3;
    }

    public void setAccommodation3(String accommodation3) {
        this.accommodation3 = accommodation3;
    }

    public Date getfirstDate() {
        return firstDate;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBudget2() {
        return budget2;
    }

    public void setBudget2(double budget2) {
        this.budget2 = budget2;
    }

    public double getBudget3() {
        return budget3;
    }

    public void setBudget3(double budget3) {
        this.budget3 = budget3;
    }

    /**
    String photoString1;
    String photoString2;
    String photoString3;
*/
    
}
