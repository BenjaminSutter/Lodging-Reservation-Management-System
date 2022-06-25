/*
 * File: IllegalOperationException.java
 * Author: Ben Sutter
 * Date: June 24th, 2022
 * Purpose: Create an exception that is triggered when a reservation cancellation or completion is not finalized.
 */

public class IllegalOperationException  extends RuntimeException {

    private String attemptedOperation;

    private String accountID;

    private String reservationNumber;

    private String errorDetails;

    public String toString() {
      return "Error attempting " + attemptedOperation + "\nAccount ID: " + accountID 
                + "\nReservation Number: " + attemptedOperation + "\nDetails: " + errorDetails;
    }

    public IllegalOperationException(String attemptOp, String accountID, String resNum, String errorDetails) {
        super("Error attempting " + attemptOp + "\nAccount ID: " + accountID 
                + "\nReservation Number: " + resNum + "\nDetails: " + errorDetails);
        this.attemptedOperation = attemptOp;
        this.accountID = accountID;
        this.reservationNumber = resNum;
        this.errorDetails = errorDetails;
    }

}