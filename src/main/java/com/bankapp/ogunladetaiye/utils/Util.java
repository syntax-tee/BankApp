package com.bankapp.ogunladetaiye.utils;


import java.util.*;

public class Util {

    public static String getAccountNumber() {
        String result = generateRandomString(10, "213456789");
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getAccountNumber());
    }

    private static String generateRandomString(int length, String seedChars) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Random rand = new Random();
        while (i < length) {
            sb.append(seedChars.charAt(rand.nextInt(seedChars.length())));
            i++;
        }
        return sb.toString();
    }
}
