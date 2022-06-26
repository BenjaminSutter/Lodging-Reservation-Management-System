/*
 * File: Test.java
 * Author: Ben Sutter
 * Date: June 26th, 2022
 * Purpose: Testing all major functionality of the project
 * Heavily based off of example skeleton code provided.
 */

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Vector;

public class Test {

    public static void main(String[] args) {
        testInitializedTrip();
        testAddReservation();
        testSaveFile();
        testSaveAndLoadFile();
        testLoadAndDelete();
        testAddingDuplicate();
        testSameAirport();
        testInvalidPersonObject();
        testInvalidReservation();
        testInvalidAirplaneReservation();
        testInvalidHotelReservation();
        testInvalidRentalCarReservation();
    }
    
    // create trip with multiple reservations
    private static Trip initializeTestTrip() {
    	Trip mytrip = null;
        try {
	    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                
	    	AirplaneReservation plane =  new AirplaneReservation("R12345", "123-456-7890", "United", "IAD", "ORL", formatter.parse("01/5/2014"), LocalTime.of(21, 50), LocalTime.of(21, 30));
                
	        mytrip = new Trip(plane, new Person("Mike", "Roberts", formatter.parse("03/5/1973")), "Reunion", formatter.parse("01/5/2014"), formatter.parse("01/5/2014"));
	
                HotelReservation hotel = new HotelReservation("RH123", "123-456-7890", new Address("123 Main St", "Rockville", "MD", "23123", "321-456-0987"), "Double", 
	            formatter.parse("01/01/2014"), formatter.parse("01/5/2014"), "123");
	        
	       mytrip.addReservation(hotel);
	        
	       RentalCarReservation car = new RentalCarReservation("RC1245", "777-456-0000", 
	            "Ford", "Torus", "2013", formatter.parse("01/01/2014"), formatter.parse("01/05/2014"),
	            formatter.parse("01/01/2014"), formatter.parse("01/05/2014"), 2.5f);

	       mytrip.addReservation(car);
               
        } catch (Exception e) {
        	System.out.println("Setup failed: " + e.getLocalizedMessage());
        	e.printStackTrace();
        	System.out.println("");
        }
       
       return mytrip;
    }
    
    // get and print each reservation and trip price
    public static void testInitializedTrip()
    {
        try
        {

           Trip mytrip = initializeTestTrip();
            
            System.out.println("Test Case 1: Each reservation");
            
            Vector<Reservation> list = mytrip.getReservations();
            for (int x = 0; x < list.size(); x++) {
                System.out.println(list.get(x));
            }
            System.out.println("Price: $" + mytrip.calculatePrice());
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println("");
        }
        System.out.println("");
    }

    // Add and check another reservation
    public static void testAddReservation()
    {
        try
        {
        	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        	
        	Trip mytrip = initializeTestTrip();

            // add second plane
            AirplaneReservation plane2 = new AirplaneReservation("R123425", "123-456-7890", "Southwest", "BWI", "NYC", 
                                                                 formatter.parse("01/5/2014"), LocalTime.of(12, 50), LocalTime.of(12, 30));

            mytrip.addReservation(plane2);
            
            System.out.println("Test Case 2: Two plane reservations");

            Vector<Reservation> list = mytrip.getReservations();
            for (int x = 0; x < list.size(); x++) {
                System.out.println(list.get(x));
            }
                    
            System.out.println("Price: $" + mytrip.calculatePrice());
            
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println("");
        }
        System.out.println("");
    }
    
    // Save trip to file
    public static void testSaveFile()
    {
        try
        {
        	Trip mytrip = initializeTestTrip();
            
            mytrip.saveToFile("mytrip3.txt");
            
            System.out.println("Test Case 3: Save to file");


            Vector<Reservation> list = mytrip.getReservations();
            for (int x = 0; x < list.size(); x++)
                System.out.println(list.get(x));
                    
            System.out.println("Price: $" + mytrip.calculatePrice());
        } catch (Exception e)
        {
            System.out.println("Test Case 3 Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println("");
        }
        System.out.println("");
    }

    // Save trip to file and then read it back into another trip object
    public static void testSaveAndLoadFile()
    {
        try
        {
            // create and save file
            Trip settrip = initializeTestTrip();
            settrip.saveToFile("mytrip4.txt");
        	
            // load
            Trip mytrip = new Trip("mytrip4.txt");
            
            System.out.println("Test Case 4: Load from file");

            Vector<Reservation> list = mytrip.getReservations();
            for (int x = 0; x < list.size(); x++) {
                System.out.println(list.get(x));
            }
                    
            System.out.println("Price: $" + mytrip.calculatePrice());
        } catch (Exception e)
        {
            System.out.println("Test Case 4 Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println("");
        }
        System.out.println("");
    }
    
    // Load trip and then delete and check reservation
    public static void testLoadAndDelete()
    {
        try
        {
            ArrayList<String> conflist = new ArrayList<String>();

        	// create and save file
            Trip settrip = initializeTestTrip();
            settrip.saveToFile("mytrip5.txt");
            
            // load
            Trip mytrip = new Trip("mytrip5.txt");
 
            System.out.println("Test Case 5: Delete reservations");
            Vector<Reservation> list = mytrip.getReservations();
            for (int x = 0; x < list.size(); x++) {
            	
                System.out.println(list.get(x));
                conflist.add(list.get(x).getConfirmationNumber());
            }
                    
            System.out.println("Price: $" + mytrip.calculatePrice());
            
            System.out.println("Beginning deletion of reservations");
 
            while (!conflist.isEmpty()) {
            	mytrip.deleteReservation(conflist.get(0));
                conflist.remove(0);
            }
            
            if (mytrip.getReservations().size() == 0) {
            	System.out.println("All reservations deleted successfully");
            }
            else {
            	System.out.println("Reservation left="+mytrip.getReservations().size());
            }
             
        } catch (Exception e)
        {
            System.out.println("Test Case 5 Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println("");
        }
        System.out.println("");
    }
    
    // Try to add duplicate reservation
    public static void testAddingDuplicate()
    {
        try
        {
            System.out.println("Test Case 6: Reservation exists");
            
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            
            AirplaneReservation plane = new AirplaneReservation("RA12345", "123-123-7890", "Southwest", "BWI", "ORL", 
                                                                 formatter.parse("01/5/2014"), LocalTime.of(15, 50), LocalTime.of(15, 30));
        	
            Trip mytrip = new Trip(plane, new Person("Mike", "Roberts", formatter.parse("03/17/1973")), "Reunion", formatter.parse("01/5/2014"), formatter.parse("01/5/2014"));

            // Add second plane
            AirplaneReservation plane2 = new AirplaneReservation("RA12345", "123-123-7890", "Southwest", "BWI", "ORL", 
                                                                 formatter.parse("01/5/2014"), LocalTime.of(15, 50), LocalTime.of(15, 30));
            
            mytrip.addReservation(plane2);
            

        } catch (Exception e) {
            System.out.println("Test Case 6: caught exception: " + e.getMessage());
            System.out.println("");
        }
        System.out.println("");
    }
    
    // Try to add reservation for flight with same airports
    public static void testSameAirport()
    {
        try
        {
            System.out.println("Test Case 7: Same airport");
            
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            
            new AirplaneReservation("RA12345", "123-123-7890", "Southwest", "BWI", "BWI", 
                                                                 formatter.parse("01/5/2014"), LocalTime.of(15, 50), LocalTime.of(15, 30));

        } catch (Exception e)
        {
            System.out.println("Test Case 7: caught exception: " + e.getMessage() + " exception caught: " + e.getClass().getSimpleName());
            System.out.println("");
        }

        System.out.println("");
    }
    
    // Try to create an invalid person object
    public static void testInvalidPersonObject()
    {
        try
        {
            System.out.println("Test Case 8: Invalid person object");
            
            new Person("", "", null);

        } catch (Exception e)
        {
            System.out.println("Test Case 8: caught exception: " + e.getMessage() + " exception caught: " + e.getClass().getSimpleName());
            System.out.println("");
        }

        System.out.println("");
    }
    
    // Try to create an invalid reservation object
    public static void testInvalidReservation()
    {
        try
        {
            System.out.println("Test Case 9: Invalid reservation");
            
            // Error will catch on super constructor
            new AirplaneReservation("", "", "", "", "", null, null, null);

        } catch (Exception e)
        {
            System.out.println("Test Case 9: caught exception: " + e.getMessage() + " exception caught: " + e.getClass().getSimpleName());
            System.out.println("");
        }

        System.out.println("");
    }
    
    // Try to create an invalid airplane reservation object
    public static void testInvalidAirplaneReservation()
    {
        try
        {
            System.out.println("Test Case 10: Invalid airplane reservation");
            
            new AirplaneReservation("valid", "valid", "", "", "", null, null, null);

        } catch (Exception e)
        {
            System.out.println("Test Case 10: caught exception: " + e.getMessage() + " exception caught: " + e.getClass().getSimpleName());
            System.out.println("");
        }

        System.out.println("");
    }
    
    // Try to create an invalid hotel reservation object
    public static void testInvalidHotelReservation()
    {
        try
        {
            System.out.println("Test Case 11: Invalid hotel reservation");
            
            new HotelReservation("valid", "valid", null, "", null, null, "");

        } catch (Exception e)
        {
            System.out.println("Test Case 11: caught exception: " + e.getMessage() + " exception caught: " + e.getClass().getSimpleName());
            System.out.println("");
        }

        System.out.println("");
    }
    
    // Try to create an invalid rental car reservation object
    public static void testInvalidRentalCarReservation()
    {
        try
        {
            System.out.println("Test Case 12: Invalid rental car reservation");
            
            new RentalCarReservation("valid", "valid", "", "", "", null, null, null, null, .5f);

        } catch (Exception e)
        {
            System.out.println("Test Case 12: caught exception: " + e.getMessage() + " exception caught: " + e.getClass().getSimpleName());
            System.out.println("");
        }

        System.out.println("");
    }
    
    
}
