/*
 * File: Trip.java
 * Author: Ben Sutter
 * Date: June 24th, 2022
 * Purpose: The trip object is what connects all of the classes together and allow a user to book a trip (vaction/business/etc)
 * Heavily based off of example skeleton code provided.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Vector;
import java.util.Date;
import java.util.List;

public class Trip {

    private Vector <Reservation> reservations;

    private Person organizer;

    private String theme;

    private Date startDate;

    private Date endDate;

      // Construct a Trip object and validate the integrity of the parameters
    public Trip(Reservation reservation, Person person, String theme, Date startDate, Date endDate) {
        
        // Ensure no blank or invalid values were supplied
        if (reservation == null || person == null || theme.isBlank()
            || startDate == null || endDate == null)
        {
            throw new IllegalArgumentException("Failed to create trip, blank or null values are not allowed");
        }
        
        reservations = new Vector<Reservation>();  // create a Vector object for reservations
        reservations.add(reservation);  // add reservation
        this.organizer = person;
        this.theme = theme;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    // Create a trip object from the XML representation stored in a file
    public Trip(String fileName) {
        
        if (fileName.isBlank())
        {
            throw new IllegalArgumentException("Failed to create trip from file, file name was blank");
        }
        
        // Ensure file exists
        File f = new File(fileName);
        if(!f.exists() || f.isDirectory()) { 
            throw new IllegalLoadException(true, fileName, "123");
        }
        
        try
        {
            // Read in the whole XML file, line by line (the file will be formatted)
            List<String> lines = Files.readAllLines(Paths.get("file"), StandardCharsets.UTF_8);
            
            String workingItem = "";
            String currentTag = "";
            boolean concatonateTags = false;

            for (String line : lines)
            {
                if (line.contains("<trip>"))
                {
                    theme = line.substring(line.indexOf("<trip>") + 6, line.indexOf("</trip>"));
                }
                else if (line.contains("</person>")) { // Initialize the organizer and turn off flag
                    organizer = new Person(workingItem);
                    concatonateTags = false;
                }
                else if (line.contains("</airplane>")) { // Parse the airplane reservation and turn off flag
                    reservations.add(new AirplaneReservation(workingItem));
                    concatonateTags = false;
                }
                else if (line.contains("</hotel>")) { // Parse the hotel reservation and turn off flag
                    reservations.add(new HotelReservation(workingItem));
                    concatonateTags = false;
                }
                else if (line.contains("</rental_car>")) { // Parse the rental car reservation and turn off flag
                    reservations.add(new RentalCarReservation(workingItem));
                    concatonateTags = false;
                }
                else if (line.contains("<person>") || line.contains("<airplane>") || line.contains("<hotel>") || line.contains("<rental_car>"))
                {
                    concatonateTags = true;
                }
                else if (concatonateTags)
                {
                    workingItem += line;
                }
                
                // TODO: Parse the organizer
                
                // TODO: Parse each reservation (look for start and end tags)
                
            }
            
        } catch(Exception e) {
            System.out.println("Failed to parse trip file: " + e.getMessage());
        }

    }

    public Vector  <Reservation> getReservations() {
        return reservations;
    }
    
    // Find matching reservation in Vector list and update it with parameter's value
    public void updateReservation(Reservation reservation) {
        
        if (reservation == null)
        {
            throw new IllegalArgumentException("Failed to update reservation, null is not allowed");
        }
        
        int index = findReservationIndex(reservation.getConfirmationNumber());
        
        if (index < 0) // Index below 0 means match was not found
        {
            // If not found, notify user
            throw new IllegalOperationException("Failed to update reservation", "Reservation to update does not exist");
        }
        
        reservations.set(index, reservation); // Update the reservation
        
    }

    public Person getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Person organizer) {
        
        if (organizer == null)
        {
            throw new IllegalArgumentException("Failed to set organizer for trip, null is not allowed");
        }
        
        this.organizer = organizer;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        
        if (theme.isBlank())
        {
            throw new IllegalArgumentException("Failed to set theme for trip, theme was blank");
        }
        
        this.theme = theme;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        
        if (startDate == null)
        {
            throw new IllegalArgumentException("Failed to set start date for trip, null is not allowed");
        }
        
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        
        if (endDate == null)
        {
            throw new IllegalArgumentException("Failed to set end date for trip, null is not allowed");
        }
        
        this.endDate = endDate;
    }

    // Add reservation object to the Vector of Reservation objects (check for duplicates) and return the number of reservation
    public Integer addReservation(Reservation reservation) {
        
        if (reservation == null)
        {
            throw new IllegalArgumentException("Failed to add reservation, null is not allowed");
        }
        
        int index = findReservationIndex(reservation.getConfirmationNumber());
        
        if (index > 0) // Index above 0 means match was found, so don't add duplicate
        {
            // If not found, notify user
            throw new DuplicateObjectException(organizer.getFullName(), reservation.getConfirmationNumber(), "Reservation already exists");
        }
        
        reservations.add(reservation); // Update the reservation
        
        return reservations.size();
    }

    // Find Reservation in Vector that matches conf number and delete from Vector
    public void deleteReservation(String confirmationNumber) {
        
        if (confirmationNumber.isBlank())
        {
            throw new IllegalArgumentException("Failed to delete reservation number, invalid confirmation number was supplied");
        }
        
        int index = findReservationIndex(confirmationNumber);
        
        if (index < 0) // Index below 0 means match was not found
        {
            // If not found, notify user
            throw new IllegalOperationException("Failed to delete reservation", "Reservation to delete does not exist");
        }
        
        reservations.remove(index); // Remove the reservation
    }

    // Save the Trip information to the passed in file
    public void saveToFile(String fileName) throws Exception {
        
        String tripString = "<trip>" + theme + "</trip>";
        
        tripString += organizer.toString(); // Add the organizer tags
        
        for (Reservation res : reservations)
        {
            tripString += res.toString(); // Add the reservation tags for each reservation
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        
        writer.write(tripString);

        writer.close();

    }

    // Calculate and return the Trip's price
    public float calculatePrice() {
        
        float runningTotal = 0.0f;
        
        for (Reservation res : reservations)
        {
            runningTotal += res.calculatePrice();
        }

        return runningTotal;
    }
    
    public int findReservationIndex(String confirmationNumber)
    {
        int size = reservations.size();
        for (int i=0; i < size; i++) {
            if (reservations.get(i).getConfirmationNumber().equalsIgnoreCase(confirmationNumber)) {
                    return i; // Return the index
            }
    	}
        
        return -3; // Return an invalid index so the method knows it failed to find a match
    }

}