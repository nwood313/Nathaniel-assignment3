package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserService {

    public User[] readUserFromFile(String datatxt) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        int numberLines = 0;
        while (reader.readLine() != null) {
            numberLines++;
        }
        reader.close();

        User[] users = new User[numberLines];
        reader = new BufferedReader(new FileReader("data.txt"));
        String line;
        int index = 0;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String username = parts[0].trim();
            String password = parts[1].trim();
            String name = parts[2].trim();
            users[index] = new User(username, password, name);
            index++;
        }
        reader.close();
        return users;
    }

    public boolean ValidateLogin(User[] users, String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}