package org.example;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private static Map<String, String> contacts = new HashMap<>();
    public static int add(String name, String number) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, number);
        }
        return contacts.size();
    }
}
