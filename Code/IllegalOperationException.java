/*
 * File: IllegalOperationException.java
 * Author: Ben Sutter
 * Date: June 24th, 2022
 * Purpose: Create an exception that is triggered when a reservation cancellation or completion is not finalized.
 */

public class IllegalOperationException  extends RuntimeException {

    private String attemptedOperation;

    private String errorDetails;

    public String toString() {
      return "Error attempting " + attemptedOperation + "\nDetails: " + errorDetails;
    }

    public IllegalOperationException(String attemptOp, String errorDetails) {
        super("Error attempting " + attemptOp + "\nDetails: " + errorDetails);
        this.attemptedOperation = attemptOp;
        this.errorDetails = errorDetails;
    }

}