/*
 * File: Address.java
 * Author: Ben Sutter
 * Date: May 22nd, 2021
 * Purpose: Data container to simulate an address for a location
 * Heavily based off of example skeleton code provided.
 */

public class Address {

    public String street;

    public String city;

    public String state;

    public String zip;

    // Construct an Address object and validate the integrity of the parameters
    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
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

}