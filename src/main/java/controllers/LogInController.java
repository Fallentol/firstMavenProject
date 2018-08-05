package controllers;

import enitity.User;

public class LogInController {
    private final static String adminName = "admin";
    private final static String adminPass = "214926341";

    public static Boolean verifyLogIn(User u) {
        Integer adminHash = (adminName + adminPass).hashCode();
        System.out.println("adminHash=" + adminHash);
        System.out.println("u.getCredentialHash()=" + u.getCredentialHash());
        return u.getCredentialHash().equals(adminHash);
    }
}
