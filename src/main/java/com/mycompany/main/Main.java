/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author ST10542449
 */
// Imports Scanner so we can get user input
import java.util.Scanner;
public class Main {
    
    //Creates Scanner for user input
        static Scanner input = new Scanner(System.in);
        // Stores the user's entered details
        static String username;
        static String password;
        static String cellPhone;
        // Stores the successfully registered details
        //Stores the registered username
        static String registeredUsername;
        
        //Stores the registered password
        static String registeredPassword;
        
        //Stores the registered cellphone number
        static String registeredCellphone;
        
        //Creates the username checking method
        public static boolean checkUserName(String username){
            // Username must have exactly 5 characters and contain an underscore
            if (username.length() == 5 && username.contains("_")){
            return true;
        } else {
        //Temporary return value
            return false;
        }
        }
        //Creates the password checking method
        public static boolean checkpasswordComplexity(String password){
            // Password must have atleast 8 characters
            // and contain uppercase, lowercase, number and special characters
            if (password.length() >= 8
                    && password.matches(".*[A-Z].*")
                    && password.matches(".*[a-z].*")
                    && password.matches(".*[0-9].*")
                    && password.matches(".*[^a-zA-Z0-9].*")) {
                return true;
            } else {   
        //Temporary return value
            return false;
        }
        }
        //Creates the cellphone checking method
        public static boolean checkCellPhone(String number) {
            // Number must start with +27
            // Followed by exactly 9 digits
            if (number.matches("^\\+27[0-9]{9}$")) {
                return true;
            } else {
            //Temporary return value
            return false;
        }
        }
        // Creates the registration method
        public static void registeredUser(){
            //Infinite loop for username
            while (true){
            // Ask for username
            System.out.print("Enter your username: ");
           username = input.nextLine();
            // Check username
           boolean usernameCorrect = checkUserName(username);
           //Check if username is correct
           if (usernameCorrect){
               break;
           }else{
                System.out.print("Username is incorrectly formatted. Please try again ");
           }
            }
            //Infinite loop for password
            while (true){
           // Ask for password
           System.out.print("Enter your password: ");
           password = input.nextLine();
            // Check password
           boolean passwordCorrect = checkpasswordComplexity(password);
           // Check if password is correct
           if (passwordCorrect) {
               break;
           }else{
               System.out.print("Password is incorrectly formatted. Please try again ");
           }
            }
            //Infinite loop for cellphone number 
            while (true) {
            //Ask for cellphone number
           System.out.print("Enter your cellphone number: (+27) ");
           cellPhone = input.nextLine();
            // Check cellphone number
           boolean phoneCorrect = checkCellPhone(cellPhone);
           //Check if cellphone number is correct
           if (phoneCorrect){
               break;
           }else{
                System.out.print("Phone is incorrectly formatted. Please try again ");
           }
            }
             // Save the valid username
               registeredUsername = username;
                // Save the valid password
               registeredPassword = password;
                // Save the valid cellphone number
               registeredCellphone = cellPhone;
               // Display success message
               System.out.print("User registered successfully.");
           } 
        //Check the login details
        public static boolean loginUser(String username, String password){
            // Infinite login for loop
            while (true){
            //Compare entered details with registered details
            if (username.equals(registeredUsername)
            && password.equals(registeredPassword)){
                return true;
            } else { 
             //Login details are incorrect
             System.out.print("Username or password incorrect, please try again.");
             //Re-prompt the user for username
             System.out.print("Enter you username to login: ");
             username = input.nextLine();
             //Re-prompt the user for password
             System.out.print("Enter you password to login: ");
             password = input.nextLine();
            }
           }
        }
        //Returns the login status message
         public static String returnLoginStatus(boolean loginSuccessful){
            // Check if login was successful
            if (loginSuccessful){
                return "Welcome, it is great to see you again.";
            } else {
            //Temporary return message
            return "Username or password incorrect, please try again.";
        }
      }
    // Main method where the program starts 
    public static void main(String[] args) {
         // Calls registration method
        registeredUser();
        //Ask user to login
           System.out.print("Enter you username to login: ");
           String loginUsername = input.nextLine();
           System.out.print("Enter you password to login: ");
           String loginPassword = input.nextLine();
          //Call login method
        boolean loginSuccessful = loginUser(username, password);
        // Call login status method
        System.out.print(returnLoginStatus(loginSuccessful));
    }
}
        
