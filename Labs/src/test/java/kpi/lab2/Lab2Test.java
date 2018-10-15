package kpi.lab2;

import static org.junit.jupiter.api.Assertions.*;

class Lab2Test {

    private final String TEST_TEXT     = "Hello, 11.30o`clock lab 2";
    private final double EXPECTED_COUNT = 13.3;

    @org.junit.jupiter.api.Test
    void findAndAddAllNumbers() {
        NumberReader numberReader = new NumberReader();
        assertEquals(EXPECTED_COUNT, numberReader.findAndAddAllNumbers(TEST_TEXT));
    }
}