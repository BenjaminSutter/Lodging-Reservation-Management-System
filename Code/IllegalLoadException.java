/*
 * File: IllegalLoadException.java
 * Author: Ben Sutter
 * Date: June 24th, 2022
 * Purpose: Create an exception that is triggered when an account or reservation
            is trying to be loaded from a file that does not exist.
 */

public class IllegalLoadException  extends RuntimeException {

    // If it is not an account file, it is a reservation file
    private boolean isAccountFile; 

    private String fileName;

    private String accountID;

    public String toString() {
        String fileType = (isAccountFile) ? "account" : "reservation";
        return "Account ID: " + accountID + "\nEncountered an error trying to load " + fileType + " file (" + fileName + "). May have been deleted or moved";
    }

    public IllegalLoadException(boolean isAccFile, String fileName, String accountID) {
        super("Failed to load \"" + fileName + "\": Does not exist");
        this.isAccountFile = isAccFile;
        this.fileName = fileName;
        this.accountID = accountID;
    }

}
