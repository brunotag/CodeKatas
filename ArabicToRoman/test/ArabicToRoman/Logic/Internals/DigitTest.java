/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ArabicToRoman.Logic.Internals;

import TestUtilities.RandomUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author brunot
 */
public class DigitTest {

    private static String symbol;
    private static int value;

    private Digit instance;

    public DigitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        value = RandomUtils.getRandomPositiveInteger();
        symbol = RandomUtils.getRandomString();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Digit(symbol, value);
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testGetSymbol_returnsSymbol() {
        System.out.println("getSymbol");
        String result = instance.getSymbol();
        assertEquals(symbol, result);
    }

    @Test
    public void testGetValue_returnsValue() {
        System.out.println("getValue");
        int result = instance.getValue();
        assertEquals(value, result);
    }

    @Test
    public void testCompareTo_smaller() {
        System.out.println("compareTo_smaller");
        Digit otherDigit = new Digit(
                RandomUtils.getRandomString(),
                value + 1
        );
        int result = instance.compareTo(otherDigit);
        assertTrue(result < 0);
    }

    @Test
    public void testCompareTo_bigger() {
        System.out.println("compareTo_bigger");
        Digit otherDigit = new Digit(
                RandomUtils.getRandomString(),
                value - 1
        );
        int result = instance.compareTo(otherDigit);
        assertTrue(result > 0);
    }

    @Test
    public void testCompareTo_equals() {
        System.out.println("compareTo_equals");
        Digit otherDigit = new Digit(
                RandomUtils.getRandomString(),
                value
        );
        int result = instance.compareTo(otherDigit);
        assertTrue(result == 0);
    }
}