package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @Test
    void testAdd() {
        PhoneBook phoneBook = new PhoneBook();
        int result = phoneBook.add("Dolg", "88005553535");
        assertEquals(1, result);
    }
}