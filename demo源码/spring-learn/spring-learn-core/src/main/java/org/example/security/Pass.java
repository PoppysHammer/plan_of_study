package org.example.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class Pass implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return null;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return false;
    }
}
