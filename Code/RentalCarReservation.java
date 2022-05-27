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

  public void updateRentalCarReservation(String mak, String mod, int year, Date sPickUp, Date sDropOff, Date aPickUp, Date aDropOff, float wind) {
  }

  public String toString() {
    return null;
  }

  public float calculatePrice() {
    return 0.0f;
  }

  public RentalCarReservation clone() {
    return null;
  }

  public void newOperation() {
  }

}