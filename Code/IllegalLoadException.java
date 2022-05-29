/*
 * File: IllegalLoadException.java
 * Author: Ben Sutter
 * Date: May 29th, 2021
 * Purpose: Create an exception that is triggered when an account or reservation
            is trying to be loaded from a file that does not exist.
 */

public class IllegalLoadException  extends RuntimeException {

    // If it is not an account file, it is a reservation file
    private boolean isAccountFile; 

    private String fileName;

    private String accountID;

    public String toString() {
        // Generate a meaningful message that helps give a further explanation of what caused the exception
        return null;
    }

    public IllegalLoadException(boolean isAccFile, String fileName, String accountID) {
        super("Failed to load \"" + fileName + "\": Does not exist");
        this.isAccountFile = isAccFile;
        this.fileName = fileName;
        this.accountID = accountID;
    }

}
