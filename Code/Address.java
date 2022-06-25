/*
 * File: Address.java
 * Author: Ben Sutter
 * Date: June 24th, 2022
 * Purpose: Data container to simulate an address for a location
 * Heavily based off of example skeleton code provided.
 */

public class Address {

    private String street;

    private String city;

    private String state;

    private String zip;
	
    private String phoneNumber;

    // Construct an Address object and validate the integrity of the parameters
    public Address(String street, String city, String state, String zip, String phoneNum) {
        
        // Ensure no blank values were supplied
        if (street.isBlank() || city.isBlank() || state.isBlank() || zip.isBlank() || phoneNumber.isBlank())
        {
            throw new IllegalArgumentException("Blank values are not allowed for an address.");
        }
        
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNum;
       
    }
    
    // Construct an Address object from a string representation
    public Address(String line) {
        
        street = line.substring(line.indexOf("<street>") + 8, line.indexOf("</street>"));
        city = line.substring(line.indexOf("<city>") + 6, line.indexOf("</city>"));
        state = line.substring(line.indexOf("<state>") + 7, line.indexOf("</state>"));
        zip = line.substring(line.indexOf("<zip>") + 5, line.indexOf("</zip>"));
        phoneNumber = line.substring(line.indexOf("<phone_number>") + 14, line.indexOf("</phone_number>")); 
        
        // Ensure no blank values were supplied
        if (street.isBlank() || city.isBlank() || state.isBlank() || zip.isBlank() || phoneNumber.isBlank())
        {
            throw new IllegalArgumentException("Blank values are not allowed for an address.");
        }
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
	
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Returns an XML formatted String representation of the object
    public String toString() {
        return  "\n\t<address>" +
                "\n\t\t<street>" + street + "</street>" +
                "\n\t\t<city>" + city + "</city>" +
                "\n\t\t<state>" + state + "</state>" +
                "\n\t\t<zip>" + zip + "</zip>" + 
                "\n\t\t<phone_number>" + phoneNumber + "</phone_number>" + 
                "\n\t</address>";
    }

    // Instantiate a copy of the current object and return it
    public Address clone() {
       return new Address(this.street, this.city, this.state, this.zip, this.phoneNumber);
    }
    
    // Instantiate a copy of an address object from a string representation
    public Address clone(String line) {
        return new Address(line);
    }

}