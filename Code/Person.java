/*
 * File: Person.java
 * Author: Ben Sutter
 * Date: June 24th, 2022
 * Purpose: Simple information about a person that is used to identify the individual
 * Heavily based off of example skeleton code provided.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

    private String firstName;

    private String lastName;

    private Date dateOfBirth; // Used to help verify age

    // Construct a Person object and validate the integrity of the parameters
    public Person(String firstName, String lastName, Date dateOfBirth) {
        
        // Ensure no blank values were supplied
        if (firstName.isBlank() || lastName.isBlank() || dateOfBirth == null)
        {
            throw new IllegalArgumentException("Blank values are not allowed for an address.");
        }
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
    
    // Construct a Person object from a string representation
    public Person(String line) {
        
        try 
        {
        
        firstName = line.substring(line.indexOf("<airline>") + 9, line.indexOf("</airline>"));
        lastName = line.substring(line.indexOf("<source_airport>") + 16, line.indexOf("</source_airport>"));
        String birthDate = line.substring(line.indexOf("<destination_airport>") + 21, line.indexOf("</destination_airport>"));


        // Ensure no blank values were supplied
        if (firstName.isBlank() || lastName.isBlank() || birthDate.isBlank())
        {
            throw new IllegalArgumentException("Blank values are not allowed for a person.");
        }
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        dateOfBirth = formatter.parse(birthDate);
        
        } catch (ParseException e) {
            System.out.println("Failed to parse person: " + e.getMessage());
        }
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        
        if (firstName.isBlank())
        {
            throw new IllegalArgumentException("Blank values are not allowed for an first name.");
        }
        
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        
        if (lastName.isBlank())
        {
            throw new IllegalArgumentException("Blank values are not allowed for an last name.");
        }
        
        this.lastName = lastName;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        
        if (dateOfBirth == null)
        {
            throw new IllegalArgumentException("Blank values are not allowed for a date of birth.");
        }
        
        this.dateOfBirth = dateOfBirth;
    }

    // Returns an XML formatted String representation of the object
    public String toString() {
        return "\n<person>" + 
               "\n\t<first_name>" + firstName + "</first_name>" + 
               "\n\t<last_name>" + lastName + "</last_name>" + 
               "\n\t<date_of_birth>" + dateOfBirth + "</date_of_birth>" + 
               "\n</person>";
    }

    // Instantiate a copy of the current object and return it
    public Person clone() {
       return new Person(this.firstName, this.lastName, this.dateOfBirth);
    }
    
    // Instantiate a copy of a person object from a string representation
    public Person clone(String line) {
        return new Person(line);
    }

}