/*
 * File: Reservation.java
 * Author: Ben Sutter
 * Date: June 24th, 2022
 * Purpose: Base class to set the precedent that other reservations will inherit from
 * Heavily based off of example skeleton code provided.
 */

import java.util.UUID;

public abstract class Reservation {

    protected String confirmationNumber;

    protected String contactPhoneNumber;
    
    protected String reservationNumber; // Will be an automatically generated UUID, so no need to set it anywhere

    // Construct a Reservation object and validate the integrity of the parameters
    public Reservation(String conNum, String phoneNum) {
        
        // Ensure no blank values were supplied
        if (conNum.isBlank() || phoneNum.isBlank())
        {
            throw new IllegalArgumentException("Blank values are not allowed for a reservation.");
        }
        
        this.confirmationNumber = conNum;
        this.contactPhoneNumber = phoneNum;
        this.reservationNumber = UUID.randomUUID().toString();
    }
    
    // Construct a Reservation object from a string representation
    public Reservation(String line) {
        
        confirmationNumber = line.substring(line.indexOf("<confirmation_number>") + 21, line.indexOf("</confirmation_number>"));
        contactPhoneNumber = line.substring(line.indexOf("<contact_number>") + 16, line.indexOf("</contact_number>"));
        reservationNumber = line.substring(line.indexOf("<reservation_number>") + 20, line.indexOf("</reservation_number>"));
        
        // Ensure no blank values were supplied
        if (confirmationNumber.isBlank() || contactPhoneNumber.isBlank() || reservationNumber.isBlank())
        {
            throw new IllegalArgumentException("Blank values are not allowed for a reservation.");
        }
    }
    
    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public String getPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setPhoneNumber(String phoneNum) {
        if (phoneNum.isBlank())
        {
            throw new IllegalArgumentException("Blank values are not allowed for an reservation phone number.");
        }
        this.confirmationNumber = phoneNum;
    }
    
    public String getReservationNumber() {
        return reservationNumber;
    }

    // Calculate the price of the reservation
    public float calculatePrice() {
        return 0.0f;
    }

    // Returns an XML formatted String representation of the object
    public String toString() {
    	return  "\t<confirmation_number>" + confirmationNumber + "</confirmation_number>" +
                "\t<contact_number>" + contactPhoneNumber + "</contact_number>" +
                "\t<reservation_number>" + reservationNumber + "</reservation_number>"; 
    }

    // Instantiate a copy of the current object and return it
    public abstract Reservation clone();
    
    // Instantiate a copy of a reservation object from a string representation
    public abstract Reservation clone(String line);

}