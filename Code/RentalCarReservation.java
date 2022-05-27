/*
 * File: RentalCarReservation.java
 * Author: Ben Sutter
 * Date: May 22nd, 2021
 * Purpose: Extend the reservation class to add ability to book a car reservation
 * Heavily based off of example skeleton code provided.
 */

import java.util.Date;

public class RentalCarReservation extends Reservation {

    public String make;

    public String model;

    public int year;

    public Date scheduledPickUp;

    public Date scheduledDropOff;

    public Date actualPickUp;

    public Date actualDropOff;

    public float window;
  
    // Construct a RentalCarReservation object and validate the integrity of the parameters
    public RentalCarReservation(String conNum, String phoneNum, String make, String mod, 
            int year, Date sPickup, Date sDropOff, Date aPickup, Date aDropOff, float wind) {
        super(conNum, phoneNum);

        this.make = make;
        this.model = mod;
        this.year = year;
        this.scheduledPickUp = sPickup;
        this.scheduledDropOff = sDropOff;
        this.actualPickUp = aPickup;
        this.actualDropOff = aDropOff;
        this.window = wind;
    }

    // update reservation data using passed in parameters
    public void updateRentalCarReservation(String mak, String mod, Date sPickUp, Date sDropOff, Date aPickUp, Date aDropOff, float wind) {
        /*
         * Validate parameters 
         * Assign parameters's values to attributes
         */
    }

    // Returns an XML formatted String representation of the object
    public String toString() {
        // return "<rentalcar>" + super.toString() + "<make>" + make + ... "</rentalcar>";
        return null;
    }

    //calculate and return the reservation's price
    public float calculatePrice() {
        /*
         * calculate number of days
         * return days * 23
         */
        return 0.0f;
    }

    // Instantiate a copy of the current object and return it
    public RentalCarReservation clone() {
        return new RentalCarReservation(this.confirmationNumber, this.contractPhoneNumber, this.make, 
                this.model, this.year, this.scheduledPickUp, this.scheduledDropOff, this.actualPickUp, this.actualDropOff, this.window);
    }

}