/*
 * File: Reservation.java
 * Author: Ben Sutter
 * Date: May 28th, 2021
 * Purpose: Base class to set the precedent that other reservations will inherit from
 * Heavily based off of example skeleton code provided.
 */

public abstract class Reservation {

    protected String confirmationNumber;

    protected String contractPhoneNumber;
    
    protected String reservationNumber; // Will be an automatically generated UUID, so no need to set it anywhere

    // Construct a Reservation object and validate the integrity of the parameters
    public Reservation(String conNum, String phoneNum) {
        this.confirmationNumber = conNum;
        this.contractPhoneNumber = phoneNum;
        // Generate a UUID for reservation number
    }
    
    // Construct a Reservation object from a string representation
    public Reservation(String line) {
    }
    
    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public String getPhoneNumber() {
        return contractPhoneNumber;
    }

    public void setPhoneNumber(String phoneNum) {
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
        //return  "<confirmationNum>" + ... "</contactNum>" ;  
         return null;
    }

    // Instantiate a copy of the current object and return it
    public abstract Reservation clone();
    
    // Instantiate a copy of a reservation object from a string representation
    public abstract Reservation clone(String line);

}