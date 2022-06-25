/*
 * File: DuplicateObjectException.java
 * Author: Ben Sutter
 * Date: June 24th, 2022
 * Purpose: Create an exception that is triggered when an account or reservation 
            is added and a duplicate already exists
 */

public class DuplicateObjectException  extends RuntimeException {

    private String accountID;

    private String reservationNumber;

    private String failureReason;

    public String toString() {
      String objectType = !accountID.isBlank() ? "Account: " + accountID : "Reservation: " + reservationNumber;
      return objectType + " already exists, failed to create a duplicate with reason of :" + failureReason;
    }

      public DuplicateObjectException(String accountID, String resNum, String failReason) {
        // If an account number is passed, it is the account that is duplicate, otherwise it is a reservation
        super(!accountID.isBlank() ? accountID : resNum + " already exists");
        
        this.accountID = accountID;
        this.reservationNumber = resNum;
        this.failureReason = failReason;
    }

}
