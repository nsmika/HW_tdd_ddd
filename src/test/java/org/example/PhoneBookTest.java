package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    void testAdd() {
        PhoneBook phoneBook = new PhoneBook();
        assertEquals(1, phoneBook.add("Dolg", "88005553535"));
        assertEquals(2, phoneBook.add("Bank", "900"));
    }

    @Test
    void testFindByNumber() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Dolg", "88005553535");
        assertEquals("Dolg", phoneBook.findByNumber("88005553535"));
    }

    @Test
    void testFindByName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Dolg", "88005553535");
        assertEquals("88005553535", phoneBook.findByName("Dolg"));
    }

    @Test
    void testPrintAllNames() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Dolg", "88005553535");
        phoneBook.add("Bank", "900");
        phoneBook.printAllNames();

        String expectedOutput = "Dolg\nBank";
        assertEquals(expectedOutput, outContent.toString());
    }
}