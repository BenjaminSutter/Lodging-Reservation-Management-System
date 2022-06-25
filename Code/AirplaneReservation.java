/*
 * File: AirplaneReservation.java
 * Author: Ben Sutter
 * Date: May 28th, 2022
 * Purpose: Extend the reservation class to add ability to book an airplane reservation
 * Heavily based off of example skeleton code provided.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        
        // No need to check if conNum or phoneNum are valid because parent constructor already does that
        if (aline.isBlank() || sAirport.isBlank() || dAirport.isBlank()
            || fDate == null || dTime == null || bTime == null)
        {
            throw new IllegalArgumentException("Failed to update airplane reservation, blank or null values are not allowed");
        }
        
        if (sAirport.equalsIgnoreCase(dAirport)) {
            throw new SameAirportException(dAirport);
    	}

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
        
        try 
        {
        
        airline = line.substring(line.indexOf("<airline>") + 9, line.indexOf("</airline>"));
        sourceAirport = line.substring(line.indexOf("<source_airport>") + 16, line.indexOf("</source_airport>"));
        destinationAirport = line.substring(line.indexOf("<destination_airport>") + 21, line.indexOf("</destination_airport>"));
        String fDate = line.substring(line.indexOf("<flight_date>") + 13, line.indexOf("</flight_date>"));
        String bTime = line.substring(line.indexOf("<departure_time>") + 16, line.indexOf("</departure_time>"));
        String dTime = line.substring(line.indexOf("<boarding_time>") + 15, line.indexOf("</boarding_time>"));

        // Ensure no blank values were supplied
        if (airline.isBlank() || sourceAirport.isBlank() || destinationAirport.isBlank() 
            || fDate.isBlank() || bTime.isBlank() || dTime.isBlank())
        {
            throw new IllegalArgumentException("Blank values are not allowed for an airplane reservation.");
        }
        
        // Parse the dates
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        flightDate = formatter.parse(fDate);
        
        // Parse the times
        departureTime = LocalTime.parse(dTime);
        boardingTime = LocalTime.parse(bTime);
        
        } catch (ParseException e) {
            System.out.println("Failed to parse Airplane Reservation: " + e.getMessage());
        }
    
    }
    
    // Update reservation data using passed in parameters
    public void updateAirplaneReservation(String aline, String sAirport, String dAirport, Date fDate, LocalTime dTime, LocalTime bTime) {
        
        if (aline.isBlank() || sAirport.isBlank() || dAirport.isBlank()
            || fDate == null || dTime == null || bTime == null)
        {
            throw new IllegalArgumentException("Failed to update airplane reservation, blank or null values are not allowed");
        }
        
        if (sAirport.equalsIgnoreCase(dAirport)) {
            throw new SameAirportException(dAirport);
    	}
        
        this.airline = aline;
        this.sourceAirport = sAirport;
        this.destinationAirport = dAirport;
        this.flightDate = fDate;
        this.departureTime = dTime;
        this.boardingTime = bTime;
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
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        
        return "\n<airplane>" + 
                super.toString() +
                "\n\t<airline>" + airline + "</airline>" +
                "\n\t<source_airport>" + sourceAirport + "</tsource_airport>" +
                "\n\t<destination_airport>" + destinationAirport + "</destination_airport>" +
                "\n\t<flight_date>" + formatter.format(flightDate) + "</flight_date>" +
                "\n\t<departure_time>" + departureTime + "</flight_date>" +
                "\n\t<boarding_time>" + boardingTime + "</boarding_time>" +
                "\n</<airplane>>";  
    }

    // Calculate and return the distance between source and destination airport
    public Integer airportDistance() {
        
        if (((sourceAirport == "IAD") && (destinationAirport == "BWI")) ||
            ((sourceAirport == "BWI") && (destinationAirport == "IAD"))) {
            return 100;
        }
        else if (((sourceAirport == "BWI") && (destinationAirport == "NYC")) ||
                 ((sourceAirport == "NYC") && (destinationAirport == "BWI"))) {
            return 221;
        }
        else if (((sourceAirport == "IAD") && (destinationAirport == "NYC")) ||
                ( (sourceAirport == "NYC") && (destinationAirport == "IAD"))) {
            return 273;
        }
        else if (((sourceAirport == "IAD") && (destinationAirport == "ORL")) ||
                 ((sourceAirport == "ORL") && (destinationAirport == "IAD"))) {
            return 723;
        }
        else if (((sourceAirport == "ORL") && (destinationAirport == "BWI")) ||
                 ((sourceAirport == "BWI") && (destinationAirport == "ORL"))) {
            return 776;
        }
        else if (((sourceAirport == "ORL") && (destinationAirport == "NYC")) ||
                 ((sourceAirport == "NYC") && (destinationAirport == "ORL"))) {
            return 842;
        }
        
        return 0;
    }

    // Calculate and return the reservation's price
    public float calculatePrice() {
        return airportDistance() * 2;  //(round trip value)
    }

    // Instantiate a copy of the current object and return it
    public AirplaneReservation clone() {
        return new AirplaneReservation(this.confirmationNumber, this.contactPhoneNumber, this.airline, 
                this.sourceAirport, this.destinationAirport, this.flightDate, this.departureTime, this.boardingTime);
    }
    
    // Instantiate a copy of an AirplaneReservation object from a string representation
    public AirplaneReservation clone(String line) {
        return new AirplaneReservation(line);
    }

}