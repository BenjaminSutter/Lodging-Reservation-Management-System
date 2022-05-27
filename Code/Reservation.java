/*
 * File: Reservation.java
 * Author: Ben Sutter
 * Date: May 22nd, 2021
 * Purpose: Base class to set the precedent that other reservations will inherit from
 * Heavily based off of example skeleton code provided.
 */

import java.util.Vector;

public class Reservation {

  public String confirmationNumber;

  public String contractPhoneNumber;

  public float calculatePrice() {
    return 0.0f;
  }

  public String toString() {
     return "";
  }

  public Reservation clone() {
     return null;
  }

}