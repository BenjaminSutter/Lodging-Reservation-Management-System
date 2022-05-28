/*
 * File: HotelReservation.java
 * Author: Ben Sutter
 * Date: May 28th, 2021
 * Purpose: Extend the reservation class to add ability to book a hotel reservation
 * Heavily based off of example skeleton code provided.
 */

import java.util.Date;

public class HotelReservation extends Reservation {

    private Address address;

    private String roomType; // Single or double

    private Date checkIn;

    private Date checkOut;

    private int roomNumber;

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
    
    // Construct a HotelReservation object from a string representation
    public HotelReservation(String line) {
        super(line);
    }

    //update reservation data using passed in parameters
    public void updateHotelReservation(String rmType, Date ckIn, Date ckOut, Address address) {
        /*
         *  Validate parameters 
         *  Assign parameters's values to attributes
         */
    }

    public Address getAddress() {
        return address;
    }

    public String getRoomType() {
        return roomType;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public int getRoomNumber() {
        return roomNumber;
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

    // Instantiate a copy of the current object and return it
    public HotelReservation clone() {
        return new HotelReservation(this.confirmationNumber, this.contractPhoneNumber, this.address, 
                this.roomType, this.checkIn, this.checkOut, this.roomNumber);
    }

    // Instantiate a copy of an HotelReservation object from a string representation
    public HotelReservation clone(String line) {
        return new HotelReservation(line);
    }

}