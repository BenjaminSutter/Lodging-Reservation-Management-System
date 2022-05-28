/*
 * File: Address.java
 * Author: Ben Sutter
 * Date: May 28th, 2021
 * Purpose: Data container to simulate an address for a location
 * Heavily based off of example skeleton code provided.
 */

public class Address {

    private String street;

    private String city;

    private String state;

    private String zip;

    // Construct an Address object and validate the integrity of the parameters
    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    
    // Construct an Address object from a string representation
    public Address(String line) {
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    // Returns an XML formatted String representation of the object
    public String toString() {
        //return "<address>" + "<street>" + street + "</street>" + ... + "</address>";
        return null;
    }

    // Instantiate a copy of the current object and return it
    public Address clone() {
        // return new Address(this.street, this.city, this.state, this.zip);
        return null;
    }
    
    // Instantiate a copy of an address object from a string representation
    public Address clone(String line) {
        return new Address(line);
    }

}