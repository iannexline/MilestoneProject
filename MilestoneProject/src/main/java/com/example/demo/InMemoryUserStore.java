package com.example.demo;

/**
 * Stores one registered user in memory
 */
public class InMemoryUserStore {

    private static String registeredEmail;
    private static String registeredPassword;

    public static void saveUser(String email, String password) {

        registeredEmail = email;
        registeredPassword = password;

        System.out.println("Saved user: " + email + " / " + password);
    }

    public static boolean isValidLogin(String email, String password) {

        System.out.println("Login attempt: " + email + " / " + password);
        System.out.println("Stored user: " + registeredEmail + " / " + registeredPassword);

        if (registeredEmail == null) return false;

        return registeredEmail.equals(email)
                && registeredPassword.equals(password);
    }

}