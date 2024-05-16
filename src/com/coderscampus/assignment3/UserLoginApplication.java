package com.coderscampus.assignment3;

import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to the Build a PC GrandSlam Giveaway! (Totally not phishing) For a chance to win," +
                " please login below: ");
        UserService userService = new UserService();
        try {
            User[] users = userService.readUserFromFile("data");
            Scanner scanner = new Scanner(System.in);
            int loginAttempts = 0;
            final int MAX_ATTEMPTS = 5;

            while (loginAttempts < MAX_ATTEMPTS) {
                System.out.println("Enter your email: ");
                String username = scanner.nextLine();
                System.out.println("Please Enter your password: ");
                String password = scanner.nextLine();

                if (userService.ValidateLogin(users, username, password)) {
                    for (User user : users) {
                        if (user.getUsername().equalsIgnoreCase(username)) {
                            System.out.println("Welcome to the no pressure program! " + user.getName());
                            return;
                        }
                    }
                } else {
                    System.out.println("Ah, Ah, Ah, You didn't say the magic words! Ah, Ah, Ah " + "Please try again");
                    loginAttempts++;
                }
            }
            System.out.println("Too Bad, You broke your machine. Maybe Try again later?");
        } catch (IOException e) {
            System.out.println("error reading file: " + e.getMessage());
        }
    }
}