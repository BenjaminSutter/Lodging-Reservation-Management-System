/*
 * File: DuplicateObjectException.java
 * Author: Ben Sutter
 * Date: May 29th, 2021
 * Purpose: Create an exception that is triggered when an account or reservation 
            is added and a duplicate already exists
 */

public class DuplicateObjectException  extends RuntimeException {

    private String accountID;

    private String reservationNumber;

    private String failureReason;

    public String toString() {
      // Generate a meaningful message that helps give a further explanation of what caused the exception
      return null;
    }

      public DuplicateObjectException(String accountID, String resNum, String failReason) {
        // If an account number is passed, it is the account that is duplicate, otherwise it is a reservation
        super(!accountID.isEmpty() ? accountID : resNum + " already exists");
        
        this.accountID = accountID;
        this.reservationNumber = resNum;
        this.failureReason = failReason;
    }

}
