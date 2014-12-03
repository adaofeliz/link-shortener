package com.adaofeliz.linkshortener.service.helper;

import org.springframework.stereotype.Component;

/**
 * Created on 03/12/14.
 */

@Component
public class ShortLinkHelper {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-=";
    private static final int BASE = ALPHABET.length();

    public Long decode(String s) {
        Long num = 0L;
        for (char ch : s.toCharArray()) {
            num *= BASE;
            num += ALPHABET.indexOf(ch);
        }
        return num;
    }

    public String encode(Long num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(ALPHABET.charAt((int) (num % BASE)));
            num /= BASE;
        }
        return sb.reverse().toString();
    }

}
