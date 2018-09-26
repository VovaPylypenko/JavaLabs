package kpi.lab2;

import static org.junit.jupiter.api.Assertions.*;

class Lab2Test {

    final String testText      = "Hello, 11.30o`clock. lab 2";
    final double expectedCount = 13.3;

    @org.junit.jupiter.api.Test
    void findAndAddAllNumbers() {
        Lab2 lab2Task = new Lab2();
        assertEquals(expectedCount, lab2Task.findAndAddAllNumbers(testText));
    }
}