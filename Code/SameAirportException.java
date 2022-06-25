/*
 * File: SameAirportException.java
 * Author: Ben Sutter
 * Date: June 24th, 2022
 * Purpose: Create an exception that is triggered when an AirplaneReservation is 
            being constructed if source/destination airports are the same
 */

public class SameAirportException extends RuntimeException {

    private String airport;

    public String toString() {
        return "Failed to create or update airplane reservation because values for source and destination airport were the same (" + airport + ")";
    }

    public SameAirportException(String airport) {
        super("The source and destination airport have the same value of " + airport);
        this.airport = airport;
    }

}