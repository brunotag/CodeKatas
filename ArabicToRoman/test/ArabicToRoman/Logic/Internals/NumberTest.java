/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArabicToRoman.Logic.Internals;

import TestUtilities.RandomUtils;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author brunot
 */
public class NumberTest {

    private Number number;
    private Digit digit;

    private String digitSymbol;
    private int digitValue;

    public NumberTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        number = new Number();
        digitSymbol = RandomUtils.getRandomString();
        digitValue = RandomUtils.getRandomPositiveInteger();
        digit = new Digit(
                digitSymbol,
                digitValue
        );
    }

    @After
    public void tearDown() {
        number = null;
        digit = null;
        digitSymbol = null;
        digitValue = 0;
    }

    @Test
    public void testAddDigit_noExceptions() {
        number.addDigit(digit);
    }

    @Test
    public void testAddDigitNTimes_noExceptions() {
        number.addDigitNTimes(digit, RandomUtils.getRandomPositiveIntegerLimited(100));
    }

    @Test
    public void testGetNumeral_empty() {
        String actual = number.getNumeral();
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNumeral_addSingleDigit() {
        number.addDigit(digit);
        String actual = number.getNumeral();
        String expected = digit.getSymbol();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNumeral_addSingleDigitMultipleTimes() {
        int times = RandomUtils.getRandomPositiveIntegerLimited(100);

        String expected = "";
        for (int i = 0; i < times; i++) {
            expected += digit.getSymbol();
        }

        number.addDigitNTimes(digit, times);
        String actual = number.getNumeral();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetNumeral_addRandomDigits() {
        int times = RandomUtils.getRandomPositiveIntegerLimited(30);

        String expected = "";
        for (int i = 0; i < times; i++) {
            digit = new Digit(RandomUtils.getRandomString(), RandomUtils.getRandomPositiveInteger());
            expected += digit.getSymbol();
            number.addDigit(digit);
        }

        String actual = number.getNumeral();

        assertEquals(expected, actual);
    }
}
