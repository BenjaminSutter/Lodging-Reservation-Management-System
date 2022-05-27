/*
 * File: Trip.java
 * Author: Ben Sutter
 * Date: May 22nd, 2021
 * Purpose: The trip object is what connects all of the classes together and allow a user to book a trip (vaction/business/etc)
 * Heavily based off of example skeleton code provided.
 */

import java.util.Vector;
import java.util.Date;

public class Trip {

  public Vector <Reservation> reservations;

  public Person organizer;

  public String theme;

  public Date startDate;

  public Date endDate;

  public Integer addReservation(Reservation reservation) {
    return null;
  }

  public void updateReservation(Reservation reservation) {
  }

  public void deleteReservation(String confirmationNumber) {
  }

  public void saveToFile(String fileName) {
  }

  public float calculatePrice() {
    return 0.0f;
  }

}