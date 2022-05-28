/*
 * File: Trip.java
 * Author: Ben Sutter
 * Date: May 28th, 2021
 * Purpose: The trip object is what connects all of the classes together and allow a user to book a trip (vaction/business/etc)
 * Heavily based off of example skeleton code provided.
 */

import java.util.Vector;
import java.util.Date;

public class Trip {

    private Vector <Reservation> reservations;

    private Person organizer;

    private String theme;

    private Date startDate;

    private Date endDate;

      // Construct a Trip object and validate the integrity of the parameters
    public Trip(Vector <Reservation>  reservations, Person person, String theme, Date startDate, Date endDate) {
        this.reservations = reservations;
        this.organizer = organizer;
        this.theme = theme;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    // Create a trip object from the XML representation stored in a file
    public Trip(String fileName) {
        // Make sure file is valid
    }

    public Vector  <Reservation> getReservations() {
        return reservations;
    }
    
    // find matching reservation in Vector list and update it with parameter's value
    public void updateReservation(Reservation reservation) {
        /*
         * validate parameter
         * find the reservation in reservations based on id
         * if found, replace with clone object in reservations list
         * otherwise if not found, fail
         */
    }

    public Person getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Person organizer) {
        this.organizer = organizer;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    // add reservation object to the Vector of Reservation objects (check for duplicates)
    // and return the number of reservation
    public Integer addReservation(Reservation reservation) {
        /*
         * validate parameters
         * check if reservation (based on it)already exists and if so fail
         * add reservation clone to reservations
         * return number of reservations
         */
        return null;
    }

    // find Reservation in Vector that matches conf number and delete from Vector
    public void deleteReservation(String confirmationNumber) {
        /*
         * check if only one reservation and fail
         * find reservation in reservations
         * if found, delete from list
         * if not found, fail
         */
    }

    // save Trip information to the passed in file
    public void saveToFile(String fileName) {
        /*
         * create/overwrite file
         * write out organizer and trip using xml tags to the file
         * iterate through reservations
         * call toString() for each object and write data to file
         * close file
         * catch errors (e.g. issues creating file) and cleanup such as closing file
         */
    }

    // calculate and return the Trip's price
    public float calculatePrice() {
        /*
         * iterate through reservations
         * call calculatePrice() for each object and sum up values
         * return the sum of values
         * 
         */
        return 0.0f;
    }

}