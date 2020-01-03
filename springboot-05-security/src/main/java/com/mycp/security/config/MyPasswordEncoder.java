package com.mycp.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author lq
 * create 2020-01-03 19:52
 */
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
