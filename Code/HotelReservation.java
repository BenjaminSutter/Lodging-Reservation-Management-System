/*
 * File: HotelReservation.java
 * Author: Ben Sutter
 * Date: May 22nd, 2021
 * Purpose: Extend the reservation class to add ability to book a hotel reservation
 * Heavily based off of example skeleton code provided.
 */

import java.util.Vector;
import java.util.Date;

public class HotelReservation extends Reservation {

  public Address address;

  public String roomType;

  public Date checkIn;

  public Date checkOut;

  public int roomNumber;
  
  public String toString() {
     return null;
  }

  public float calculatePrice() {
    return 0.0f;
  }

  public void updateHotelReservation(String rmType, Date ckIn, Date ckOut, Address address, int rmNum) {
  }

  public HotelReservation clone() {
     return null;
  }

}