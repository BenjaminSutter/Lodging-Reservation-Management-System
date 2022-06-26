/*
 * File: HotelReservation.java
 * Author: Ben Sutter
 * Date: June 24th, 2022
 * Purpose: Extend the reservation class to add ability to book a hotel reservation
 * Heavily based off of example skeleton code provided.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HotelReservation extends Reservation {

    private Address address;

    private String roomType; // Single or double

    private Date checkIn;

    private Date checkOut;

    private String roomNumber;

    // Construct a HotelReservation object and validate the integrity of the parameters
    public HotelReservation(String conNum, String phoneNum, Address address, 
            String rmType, Date ckIn, Date ckOut, String rmNum) {
        super(conNum, phoneNum);
        
        // No need to check if conNum or phoneNum are valid because parent constructor already does that
        if (address == null || rmType.isBlank() 
            || ckIn == null || ckOut == null || rmNum.isBlank())
        {
            throw new IllegalArgumentException("Blank values are not allowed for an hotel reservation.");
        }
        
        this.address = address;
        this.roomType = rmType;
        this.checkIn = ckIn;
        this.checkOut = ckOut;
        this.roomNumber = rmNum;

    }
    
    // Construct a HotelReservation object from a string representation
    public HotelReservation(String line) {
        super(line);
        
        try 
        {
        
        String addressStr = line.substring(line.indexOf("<address>") + 9, line.indexOf("</address>"));
        roomType = line.substring(line.indexOf("<room_type>") + 11, line.indexOf("</room_type>"));
        String in = line.substring(line.indexOf("<check_in>") + 10, line.indexOf("</check_in>"));
        String out = line.substring(line.indexOf("<check_out>") + 11, line.indexOf("</check_out>"));
        roomNumber = line.substring(line.indexOf("<room_number>") + 13, line.indexOf("</room_number>"));

        // Ensure no blank values were supplied
        if (addressStr.isBlank() || roomType.isBlank() || in.isBlank() 
            || out.isBlank() || roomNumber.isBlank())
        {
            throw new IllegalArgumentException("Blank values are not allowed for a hotel reservation.");
        }
        
        // Create the address from the line constructor
        address = new Address(addressStr);
        
        // Parse the dates
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        checkIn = formatter.parse(in);
        checkOut = formatter.parse(out);
        
        } catch (ParseException e) {
            System.out.println("Failed to parse hotel Reservation: " + e.getMessage());
        }
        
    }

    //update reservation data using passed in parameters
    public void updateHotelReservation(String rmType, Date ckIn, Date ckOut, Address address, String rmNum) {
        
        if (address == null || rmType.isBlank() 
            || ckIn == null || ckOut == null || rmNum.isBlank())
        {
            throw new IllegalArgumentException("Blank values are not allowed for a hotel reservation.");
        }
        
        this.address = address;
        this.roomType = rmType;
        this.checkIn = ckIn;
        this.checkOut = ckOut;
        this.roomNumber = rmNum;
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

    public String getRoomNumber() {
        return roomNumber;
    }
 
    // Returns an XML formatted String representation of the object
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        
        return  "\n<hotel>" +
                super.toString() +
                address.toString() + 
                "\n\t<room_type>" + roomType + "</room_type>" +
                "\n\t<check_in>" + formatter.format(checkIn) + "</check_in>" +
                "\n\t<check_out>" + formatter.format(checkOut) + "</check_out>" +
                "\n\t<room_number>" + roomNumber + "</room_number>" +
                "\n</hotel>";
    }

    // Calculate and return the reservation's price
    public float calculatePrice() {
        long difference = checkOut.getTime() - checkIn.getTime();
        return (difference / (1000 * 60 * 60 * 24) ) * 100; // Days * 100
    }

    // Instantiate a copy of the current object and return it
    public HotelReservation clone() {
        return new HotelReservation(this.confirmationNumber, this.contactPhoneNumber, this.address, 
                this.roomType, this.checkIn, this.checkOut, this.roomNumber);
    }

    // Instantiate a copy of an HotelReservation object from a string representation
    public HotelReservation clone(String line) {
        return new HotelReservation(line);
    }

}