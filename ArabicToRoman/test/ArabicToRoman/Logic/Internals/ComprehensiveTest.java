package ArabicToRoman.Logic.Internals;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ArabicToRoman.Logic.Universe;
import TestUtilities.CombinationsWithRepetition;
import java.util.HashSet;
import java.util.Set;
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
public class ComprehensiveTest {

    public ComprehensiveTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /*
    @Test
    public void testdefaultUniverseTransitivityMassive() {
        System.out.println("defaultUniverseTransitivityMassive");
        Universe univ = Universe.getDefaultUniverse();
        for (int i = 1; i <= 50000; i++) {
            String numeral = univ.getConverter().getNumberFromValue(i).toString();
            int value = univ.getParser().parseNumberFromNumeral(numeral).getValue();
            assertEquals(i, value);
        }
    }
*/
    @Test
    public void testparserFalsePositives() {
        System.out.println("parserFalsePositives");
        UniverseBase univ = (UniverseBase) Universe.getDefaultUniverse();
        int k = 5;

        Set<String> validNumerals = getValidNumerals(univ, k);
        Set<String> allPossibleNumerals = getNpowerKcombinationsSymbols(
                univ.digits, k
        );

        for (String currentNumeral : allPossibleNumerals) {
            try {
                univ.getParser().parseNumberFromNumeral(currentNumeral);
                assertTrue("currentNumeral: " + currentNumeral, validNumerals.contains(currentNumeral));
            } catch (IllegalArgumentException ex) {
                assertFalse(validNumerals.contains(currentNumeral));
            }
        }
    }

    private int getMaxValueInDigits(Set<Digit> digits) {
        int maxValue = 0;
        for (Digit digit : digits) {
            if (maxValue < digit.getValue()) {
                maxValue = digit.getValue();
            }
        }
        return maxValue;
    }

    private Set<String> getNpowerKcombinationsSymbols(Set<Digit> digits, int k) {

        Set<String> symbols = new HashSet<>();
        for(Digit digit : digits){
            symbols.add(digit.getSymbol());
        }
        
        CombinationsWithRepetition combos = new CombinationsWithRepetition(symbols, k);

        HashSet<String> retVal = new HashSet<>();


        for (String[] variation : combos.getVariations()) {
            StringBuilder sb = new StringBuilder();
            for (String variation1 : variation) {
                sb.append(variation1);
            }
            retVal.add(sb.toString());
        }

        return retVal;
    }

    private Set<String> getValidNumerals(UniverseBase univ, int k) {
        int maxValue = getMaxValueInDigits(univ.digits) * k;
        Set<String> validNumerals = new TreeSet<>();
        for (int i = 1; i <= maxValue; i++) {
            String numeral = univ.getConverter().getNumberFromValue(i).toString();
            validNumerals.add(numeral);
        }
        return validNumerals;
    }
}
