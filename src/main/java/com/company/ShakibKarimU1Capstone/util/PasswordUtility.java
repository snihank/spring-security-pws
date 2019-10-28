package com.company.ShakibKarimU1Capstone.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {

    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();

        String user = "user";

        String encodedPasswordUser = enc.encode(user);

        System.out.println("user : " + encodedPasswordUser);

        String staff = "staff";

        String encodedPasswordStaff = enc.encode(staff);

        System.out.println("staff : " + encodedPasswordStaff);

        String manager = "manager";

        String encodedPasswordManager = enc.encode(manager);

        System.out.println("Manager : " + encodedPasswordManager);

        String admin = "admin";

        String encodedPasswordAdmin = enc.encode(admin);

        System.out.println("Admin : " + encodedPasswordAdmin);

    }

}
