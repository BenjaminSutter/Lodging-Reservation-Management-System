/*
 * File: HotelReservation.java
 * Author: Ben Sutter
 * Date: May 22nd, 2021
 * Purpose: Extend the reservation class to add ability to book a hotel reservation
 * Heavily based off of example skeleton code provided.
 */

import java.util.Vector;
import java.util.Date;

public class HotelReservation extends Reservation {

    public Address address;

    public String roomType; // single or double

    public Date checkIn;

    public Date checkOut;

    public int roomNumber;
    
    // Construct a HotelReservation object and validate the integrity of the parameters
    public HotelReservation(String conNum, String phoneNum, Address address, 
            String rmType, Date ckIn, Date ckOut, int rmNum) {
        super(conNum, phoneNum);
        
        this.address = address;
        this.roomType = rmType;
        this.checkIn = ckIn;
        this.checkOut = ckOut;
        this.roomNumber = rmNum;

    }
 
    // Returns an XML formatted String representation of the object
    public String toString() {
        // return "<hotel>" + super.toString() + "<roomtype>" + roomType +  "</hotel>";
        return null;
    }

    //calculate and return the reservation's price
    public float calculatePrice() {
        /*
         * calculate number of days for the reservation
         * return days * 100
         * 
         */
        return 0.0f;
    }

    //update reservation data using passed in parameters
    public void updateHotelReservation(String rmType, Date ckIn, Date ckOut, Address address) {
        /*
         *  Validate parameters 
         *  Assign parameters's values to attributes
         */
    }

    // Instantiate a copy of the current object and return it
    public HotelReservation clone() {
        return new HotelReservation(this.confirmationNumber, this.contractPhoneNumber, this.address, 
                this.roomType, this.checkIn, this.checkOut, this.roomNumber);
    }

}