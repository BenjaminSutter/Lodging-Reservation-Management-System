/*
 * File: Person.java
 * Author: Ben Sutter
 * Date: May 28th, 2021
 * Purpose: Simple information about a person that is used to identify the individual
 * Heavily based off of example skeleton code provided.
 */

import java.util.Date;

public class Person {

    private String firstName;

    private String lastName;

    private Date dateOfBirth; // Used to help verify age

    // Construct a Person object and validate the integrity of the parameters
    public Person(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
    
    // Construct a Person object from a string representation
    public Person(String line) {
    }
    
    public String getFirstName() {
    return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Returns an XML formatted String representation of the object
    public String toString() {
        //return "<person>" + "<firstName>" + firstName + "</firstName>" + 
        //       "<lastName>" + lastName + "</lastName>" + 
        //       "<dateOfBirth>" + dateOfBirth + "</dateOfBirth>" + + "</person>";
        return null;
    }

    // Instantiate a copy of the current object and return it
    public Person clone() {
       //return new Person(this.firstName, this.lastName, this.dateOfBirth);
       return null;
    }
    
    // Instantiate a copy of a person object from a string representation
    public Person clone(String line) {
        return new Person(line);
    }

}