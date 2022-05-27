/*
 * File: AirplaneReservation.java
 * Author: Ben Sutter
 * Date: May 22nd, 2021
 * Purpose: Extend the reservation class to add ability to book an airplane reservation
 * Heavily based off of example skeleton code provided.
 */

import java.time.LocalTime;
import java.util.Date;

public class AirplaneReservation extends Reservation {

  public String sourceAirport;

  public String destinationAirport;

  public Date flightDate;

  public String airline;

  public LocalTime departureTime;

  public LocalTime boardingTime;

  public String toString() {
     return null;
  }

  public void updateAirplaneReservation(String aline, String sAirport, String dAirport, Date fDate, LocalTime dTime, LocalTime bTime) {
  }

  public Integer airportDistance() {
     return null;
  }

  public float calculatePrice() {
    return 0.0f;
  }

  public AirplaneReservation clone() {
     return null;
  }

  public void newOperation() {
  }

}