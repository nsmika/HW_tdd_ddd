package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhoneBookTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

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

        String actualOutput = outContent.toString().trim();
        String expectedOutput = String.join(System.lineSeparator(), "Bank", "Dolg");

        if (!expectedOutput.equals(actualOutput)) {
            System.out.println("Expected: [" + expectedOutput + "]");
            System.out.println("Actual: [" + actualOutput + "]");
        }

        assertEquals(expectedOutput, actualOutput);
    }
}