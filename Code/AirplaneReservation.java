/*
 * File: AirplaneReservation.java
 * Author: Ben Sutter
 * Date: May 28th, 2021
 * Purpose: Extend the reservation class to add ability to book an airplane reservation
 * Heavily based off of example skeleton code provided.
 */

import java.time.LocalTime;
import java.util.Date;

public class AirplaneReservation extends Reservation {

    private String airline;

    private String sourceAirport;

    private String destinationAirport;

    private Date flightDate;

    private LocalTime departureTime;

    private LocalTime boardingTime;

    // Construct an AirplaneReservation object and validate the integrity of the parameters
    public AirplaneReservation(String conNum, String phoneNum, String aline, String sAirport, 
            String dAirport, Date fDate, LocalTime dTime, LocalTime bTime) {
        super(conNum, phoneNum);

        this.airline = aline;
        this.sourceAirport = sAirport;
        this.destinationAirport = dAirport;
        this.flightDate = fDate;
        this.departureTime = dTime;
        this.boardingTime = bTime;
    }
    
    // Construct an AirplaneReservation object from a string representation
    public AirplaneReservation(String line) {
        super(line);
    }
    
    // Update reservation data using passed in parameters
    public void updateAirplaneReservation(String aline, String sAirport, String dAirport, Date fDate, LocalTime dTime, LocalTime bTime) {
        /*
         * Validate parameters 
         * validate that source and destination are not the same
         * Assign parameters's values to attributes
         */
    }

    public String getAirline() {
        return airline;
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getBoardingTime() {
        return boardingTime;
    }

    // Returns an XML formatted String representation of the object
    public String toString() {
        /*
         * return "<airplane>" +  super.toString() + "<airline>" + airline + ... + "</airplane>";  
         */
        return null;
    }

    // calculate and return the distance between source and destination airport
    public Integer airportDistance() {
        /*
         * check the combination of source and destination and return that value
         * e.g. if source=IAD & destination=ORL return 723
         */
        return 0;
    }

    //calculate and return the reservation's price
    public float calculatePrice() {
        /*
         * return airportDistance() * 2;  (round trip value)
         */
        return 0.0f;
    }

    // Instantiate a copy of the current object and return it
    public AirplaneReservation clone() {
        return new AirplaneReservation(this.confirmationNumber, this.contractPhoneNumber, this.airline, 
                this.sourceAirport, this.destinationAirport, this.flightDate, this.departureTime, this.boardingTime);
    }
    
    // Instantiate a copy of an AirplaneReservation object from a string representation
    public AirplaneReservation clone(String line) {
        return new AirplaneReservation(line);
    }

}