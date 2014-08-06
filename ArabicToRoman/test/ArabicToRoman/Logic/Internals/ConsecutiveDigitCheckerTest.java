/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ArabicToRoman.Logic.Internals;

import ArabicToRoman.Logic.Universe;
import java.util.Iterator;
import java.util.TreeSet;
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
public class ConsecutiveDigitCheckerTest {
    
    private ConsecutiveDigitChecker instance;
    private static TreeSet<Digit> digits;
    
    public ConsecutiveDigitCheckerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        digits = new TreeSet<>(((UniverseBase) Universe.getDefaultUniverse()).digits);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ConsecutiveDigitChecker(digits);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testResetNoException() {
        System.out.println("reset_NoException");
        instance.reset();
    }

    @Test
    public void testUpdateDigit() {
        System.out.println("updateDigit");
        instance.updateDigit(digits.first());
    }

    @Test
    public void testIsInvalidDigitSequence_false() {
        System.out.println("isInvalidDigitSequence_false");
        Iterator<Digit> iterator = digits.iterator();
        testIsInvalidDigitMultiSequence(iterator, false);
    }
    
    @Test
    public void testIsInvalidDigitSequence_true() {
        System.out.println("isInvalidDigitSequence_true");
        Iterator<Digit> iterator = digits.iterator();
        testIsInvalidDigitMultiSequence(iterator, true);
    }    
    
    private void testIsInvalidDigitMultiSequence(Iterator<Digit> iterator, Boolean expected){
        Digit current = iterator.next();
        Digit next;
        while(iterator.hasNext()){
            next = iterator.next();
            testIsInvalidDigitSequence(current, next, false);
            current = next;
        }
    }
    
    private void testIsInvalidDigitSequence(Digit minor, Digit mayor, Boolean expected){
        Boolean result;
        if (expected){
            instance.updateDigit(mayor);
            result = instance.isInvalidDigitSequence(minor);
        }else{
            instance.updateDigit(minor);
            result = instance.isInvalidDigitSequence(mayor);
        }
        assertEquals(expected, result);
    }
}
