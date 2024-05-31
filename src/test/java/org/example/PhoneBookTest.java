package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @Test
    void testAdd() {
        PhoneBook phoneBook = new PhoneBook();
        assertEquals(1, phoneBook.add("Dolg", "88005553535"));
        assertEquals(2, phoneBook.add("Bank", "900"));
    }
}