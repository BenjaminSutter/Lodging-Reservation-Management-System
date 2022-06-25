/*
 * File: TripOrganizer.java
 * Author: Ben Sutter
 * Date: June 24th, 2022
 * Purpose: UI to help organize a trip
 * Heavily based off of example skeleton code provided.
 */

public class TripOrganizer {

    private Trip trip; // store and manage a single Trip object at a time

      // Construct a TripOrganizer object
    public TripOrganizer() {
    }
    
    public Trip getTrip(){
        return trip;
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

        
    }

    // delete the currently loaded Trip and its file (value smust match)
    public void deleteTrip(String fileName) {
        /*
         * validate trip exists
         * validate file exists
         * delete file
         * make trip=null
         */
        
        if(trip == null){
            throw new IllegalArgumentException("Failed to delete trip, no trip is loaded");
        }
    }

    // load new Trip from the passed in object (close the currently loaded Trip)
    public void createNewTrip(Trip trip) {
        if(trip == null){
            throw new IllegalArgumentException("Failed to delete trip, no trip is loaded");
        }
        this.trip = trip;
    }
}