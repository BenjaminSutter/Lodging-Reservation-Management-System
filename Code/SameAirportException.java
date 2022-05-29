/*
 * File: SameAirportException.java
 * Author: Ben Sutter
 * Date: May 29th, 2021
 * Purpose: Create an exception that is triggered when an AirplaneReservation is 
            being constructed if source/destination airports are the same
 */

public class SameAirportException extends RuntimeException {

    private String airport;

    public String toString() {
      // Generate a meaningful message that helps give a further explanation of what caused the exception
      return null;
    }

    public SameAirportException(String airport) {
        super("The source and destination airport have the same value of " + airport);
        this.airport = airport;
    }

}