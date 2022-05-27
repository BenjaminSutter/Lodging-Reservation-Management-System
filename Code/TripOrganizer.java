/*
 * File: TripOrganizer.java
 * Author: Ben Sutter
 * Date: May 22nd, 2021
 * Purpose: UI to help organize a trip
 * Heavily based off of example skeleton code provided.
 */

import java.util.Vector;

public class TripOrganizer {

    public Trip trip; // store and manage a single Trip object at a time

      // Construct a TripOrganizer object
    public TripOrganizer() {
    }

    // Add reservation to the currently loaded Trip
    public void addReservation(Reservation reservation) {
        /*
         * validate there is a trip open otherwise fail
         * can trip.addReservation(reservation);
         */
    }

    // save current Trip data to a file  
    public void saveToFile(String filename) {
        /*
         * validate trip is loaded
         * call trip.saveToFile(fileName);
         */
    }

    // load a Trip object from a file
    public void openFromFile(String filename) {
        /*
         * trip = new Trip(fileName);
         */
    }

    // update the currently loaded Trip's reservation (one that matches the parameter)
    public void editReservation(Reservation reservation) {
        /*
         * validate trip is loaded
         * trip.updateReservation(reservation);
         */
    }

    // delete reservation matching conf number from currently loaded trip
    public void deleteReservation(String confirmationNumber) {
        /*
         * validate trip[ is loaded
         * trip.deleteReservation(confirmationNumber);
         */
    }

    // delete the currently loaded Trip and its file (value smust match)
    public void deleteTrip(String fileName) {
        /*
         * validate trip exists
         * validate file exists
         * delete file
         * make trip=null
         */
    }

    // load new Trip from the passed in object (close the currently loaded Trip)
    public void createNewTrip(Trip trip) {
        /*
         * validate trip parameter
         * assign parameter to attribute
         */
    }
}