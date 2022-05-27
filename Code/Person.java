/*
 * File: Person.java
 * Author: Ben Sutter
 * Date: May 22nd, 2021
 * Purpose: Simple information about a person that is used to identify the individual
 * Heavily based off of example skeleton code provided.
 */

import java.util.Date;

public class Person {

    public String firstName;

    public String lastName;

    public Date dateOfBirth; // Used to help verify age

    // Construct a Person object and validate the integrity of the parameters
    public Person(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
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

}