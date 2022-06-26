/*
 * File: RentalCarReservation.java
 * Author: Ben Sutter
 * Date: June 24th, 2022
 * Purpose: Extend the reservation class to add ability to book a car reservation
 * Heavily based off of example skeleton code provided.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RentalCarReservation extends Reservation {

    private String make;

    private String model;

    private String year;

    private Date scheduledPickUp;

    private Date scheduledDropOff;

    private Date actualPickUp;

    private Date actualDropOff;

    private float window;
  
    // Construct a RentalCarReservation object and validate the integrity of the parameters
    public RentalCarReservation(String conNum, String phoneNum, String make, String mod, 
            String year, Date sPickUp, Date sDropOff, Date aPickUp, Date aDropOff, float wind) {
        super(conNum, phoneNum);
        
        // No need to check if conNum or phoneNum are valid because parent constructor already does that
        if (make.isBlank() || mod.isBlank() || year.isBlank() || sPickUp == null
             || sDropOff == null || aPickUp == null || aDropOff == null)
        {
            throw new IllegalArgumentException("Failed to create rental car reservation, blank or null values are not allowed");
        }

        this.make = make;
        this.model = mod;
        this.year = year;
        this.scheduledPickUp = sPickUp;
        this.scheduledDropOff = sDropOff;
        this.actualPickUp = aPickUp;
        this.actualDropOff = aDropOff;
        this.window = wind;
    }

    // Construct a RentalCarReservation object from a string representation
    public RentalCarReservation(String line) {
        super(line);
        
        try 
        {
        
        make = line.substring(line.indexOf("<make>") + 6, line.indexOf("</make>"));
        model = line.substring(line.indexOf("<model>") + 7, line.indexOf("</model>"));
        year = line.substring(line.indexOf("<year>") + 6, line.indexOf("</year>"));
        String sPickUp = line.substring(line.indexOf("<scheduled_pick_up>") + 19, line.indexOf("</scheduled_pick_up>"));
        String sDropOff = line.substring(line.indexOf("<scheduled_drop_off>") + 20, line.indexOf("</scheduled_drop_off>"));
        String aPickUp = line.substring(line.indexOf("<actual_pick_up>") + 16, line.indexOf("</actual_pick_up>"));
        String aDropOff = line.substring(line.indexOf("<actual_drop_off>") + 17, line.indexOf("</actual_drop_off>"));
        String win = line.substring(line.indexOf("<window>") + 8, line.indexOf("</window>"));

        // Ensure no blank values were supplied
        if (make.isBlank() || model.isBlank() || year.isBlank() || sPickUp.isBlank()
             || sDropOff.isBlank() || aPickUp.isBlank() || aDropOff.isBlank() || win.isBlank())
        {
            throw new IllegalArgumentException("Blank values are not allowed for an rental car reservation.");
        }
        
        // Parse the dates
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        scheduledPickUp = formatter.parse(sPickUp);
        scheduledDropOff = formatter.parse(sDropOff);
        actualPickUp = formatter.parse(aPickUp);
        actualDropOff = formatter.parse(aDropOff);
        
        // Parse the window
        window = Float.parseFloat(win);
        
        } catch (ParseException e) {
            System.out.println("Failed to parse rental car Reservation: " + e.getMessage());
        }
        
    }
    
    // update reservation data using passed in parameters
    public void updateRentalCarReservation(String mak, String mod, String year, Date sPickUp, Date sDropOff, Date aPickUp, Date aDropOff, float wind) {
        
        if (make.isBlank() || mod.isBlank() || year.isBlank() || sPickUp == null
             || sDropOff == null || aPickUp == null || aDropOff == null)
        {
            throw new IllegalArgumentException("Failed to update rental car reservation, blank or null values are not allowed");
        }

        this.make = make;
        this.model = mod;
        this.year = year;
        this.scheduledPickUp = sPickUp;
        this.scheduledDropOff = sDropOff;
        this.actualPickUp = aPickUp;
        this.actualDropOff = aDropOff;
        this.window = wind;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public Date getScheduledPickUp() {
        return scheduledPickUp;
    }

    public Date getScheduledDropOff() {
        return scheduledDropOff;
    }

    public Date getActualPickup() {
        return actualPickUp;
    }

    public Date getActualDropOff() {
        return actualDropOff;
    }

    public float getWindows() {
        return window;
    }

    // Returns an XML formatted String representation of the object
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        
        return "\n<rental_car>" +
               super.toString() +
                "\n\t<make>" + make + "</make>" +
                "\n\t<model>" + model + "</model>" +
                "\n\t<year>" + year + "</year>" +
                "\n\t<scheduled_pick_up>" + formatter.format(scheduledPickUp) + "</scheduled_pick_up>" +
                "\n\t<scheduled_drop_off>" + formatter.format(scheduledDropOff) + "</scheduled_drop_off>" +
                "\n\t<actual_pick_up>" + formatter.format(actualPickUp) + "</actual_pick_up>" +
                "\n\t<actual_drop_off>" + formatter.format(actualDropOff) + "</actual_drop_off>" +
                "\n\t<window>" + window + "</window>" +
                "\n</rental_car>";
    }

    // Calculate and return the reservation's price
    public float calculatePrice() {
        long difference = actualDropOff.getTime() - scheduledPickUp.getTime();
        return (difference / (1000 * 60 * 60 * 24) ) * 23; // Days * 23. Charge them even if they didn't pick it up on time (it's in the contract)
    }

    // Instantiate a copy of the current object and return it
    public RentalCarReservation clone() {
        return new RentalCarReservation(this.confirmationNumber, this.contactPhoneNumber, this.make, 
                this.model, this.year, this.scheduledPickUp, this.scheduledDropOff, this.actualPickUp, this.actualDropOff, this.window);
    }
    
    // Instantiate a copy of a RentalCarReservation object from a string representation
    public RentalCarReservation clone(String line) {
        return new RentalCarReservation(line);
    }

}