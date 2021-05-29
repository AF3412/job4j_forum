package ru.af3412.forum.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class InitPassword {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode("secret");
        System.out.println(pwd);
    }

}
