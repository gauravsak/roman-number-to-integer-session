package com.company;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.company.RomanNumberToIntegerConverter.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumberToIntegerConverterTest {

    @ParameterizedTest
    @CsvSource({
            "I, 1",
            "V, 5",
            "X, 10",
            "L, 50",
            "C, 100",
            "D, 500",
            "M, 1000",
            "II, 2",
            "XX, 20",
            "CC, 200",
            "MM, 2000",
            "III, 3",
            "XXX, 30",
            "CCC, 300",
            "MMM, 3000",
            "IV, 4",
            "VI, 6",
            "VII, 7",
            "VIII, 8",
            "MXCVIII, 1098",
    })
    void converts_roman_number_to_integer(String romanNumber, Integer integer) {
        assertEquals(integer, convertRecursive(romanNumber));
        assertEquals(integer, convertTailRecursive(romanNumber));
        assertEquals(integer, convertIterative(romanNumber));
    }
}
