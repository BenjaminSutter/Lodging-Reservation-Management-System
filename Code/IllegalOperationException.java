/*
 * File: IllegalOperationException.java
 * Author: Ben Sutter
 * Date: May 29th, 2021
 * Purpose: Create an exception that is triggered when a reservation cancellation or completion is not finalized.
 */

public class IllegalOperationException  extends RuntimeException {

    private String attemptedOperation;

    private String accountID;

    private String reservationNumber;

    private String errorDetails;

    public String toString() {
      // Generate a meaningful message that helps give a further explanation of what caused the exception
      return null;
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