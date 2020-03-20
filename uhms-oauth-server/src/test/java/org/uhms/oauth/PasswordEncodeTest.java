package org.uhms.oauth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodeTest {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }
}
