/*
 * File: TripOrganizer.java
 * Author: Ben Sutter
 * Date: June 24th, 2022
 * Purpose: UI to help organize a trip
 * Heavily based off of example skeleton code provided.
 */

import java.io.File;

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
        
        if(trip == null){
            throw new IllegalOperationException("Adding a reservation", "Trip does not exist to add reservation to");
        }
        
        trip.addReservation(reservation);
        
    }

    // Save current Trip data to a file  
    public void saveToFile(String fileName) throws Exception {
        trip.saveToFile(fileName);
    }

    // Load a Trip object from a file
    public void openFromFile(String fileName) {
        trip = new Trip(fileName);
    }

    // Update the currently loaded Trip's reservation (one that matches the parameter)
    public void editReservation(Reservation reservation) {
        trip.updateReservation(reservation);
    }

    // Delete reservation matching conf number from currently loaded trip
    public void deleteReservation(String confirmationNumber) {
        trip.deleteReservation(confirmationNumber);  
    }

    // Delete the currently loaded Trip and its file (value smust match)
    public void deleteTrip(String fileName) {

        if(trip == null){
            throw new IllegalArgumentException("Failed to delete trip, no trip is loaded");
        }
        
        File f = new File(fileName);
        if(!f.exists() || f.isDirectory()) { 
            throw new IllegalLoadException(true, fileName, "123");
        }
        f.delete();
        trip = null;
        
    }

    // Load new Trip from the passed in object (close the currently loaded Trip)
    public void createNewTrip(Trip trip) {
        if(trip == null){
            throw new IllegalArgumentException("Failed to delete trip, no trip is loaded");
        }
        this.trip = trip;
    }
}