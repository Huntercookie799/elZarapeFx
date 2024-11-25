package org.utl.dsm403.zarape.elzarape.model;

public class Utilities {
    public static boolean validateLogin(String username, String password) {
        return username.equals("Admin") && password.equals("1234");
    }
    
    public static void showAlert(String title, String message) {
    }
}