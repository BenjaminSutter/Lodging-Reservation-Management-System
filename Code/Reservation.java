/*
 * File: Reservation.java
 * Author: Ben Sutter
 * Date: May 22nd, 2021
 * Purpose: Base class to set the precedent that other reservations will inherit from
 * Heavily based off of example skeleton code provided.
 */

public abstract class Reservation {

    public String confirmationNumber;

    public String contractPhoneNumber;

    // Construct a Reservation object and validate the integrity of the parameters
    public Reservation(String conNum, String phoneNum) {
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

}