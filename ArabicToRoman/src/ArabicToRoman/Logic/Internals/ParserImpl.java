/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArabicToRoman.Logic.Internals;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class ParserImpl extends ParserBase {

    private final Map<String, Digit> symbolsToDigits;
    private final ConsecutiveDigitChecker digitChecker;

    public ParserImpl(Set<Digit> digits) {
        super(digits);
        digitChecker = new ConsecutiveDigitChecker(new TreeSet<>(digits));
        symbolsToDigits = new HashMap<>(digits.size());
        for (Digit digit : digits) {
            symbolsToDigits.put(digit.getSymbol(), digit);
        }
    }

    @Override
    public Number parseNumberFromNumeral(String numeral) {

        Number retVal = new Number();
        DigitParser digitParser = new DigitParser(symbolsToDigits);
        digitChecker.reset();

        String partial = numeral;
        while (partial.length() > 0) {
            Digit digitToAdd = digitParser.parseDigit(partial.toCharArray());
            if (digitToAdd == null) {
                throwIllegalNumeralError(partial, numeral);
            } else {
                if (digitChecker.isInvalidDigitSequence(digitToAdd))
                {
                    throwIllegalNumeralError(partial, numeral);
                }
                retVal.addDigit(digitToAdd);
                partial = partial.substring(digitToAdd.getSymbol().length());
            }
            digitChecker.updateDigit(digitToAdd);
        }

        return retVal;
    }

    private static void throwIllegalNumeralError(String illegalSubString, String illegalNumeral) {
        throw new IllegalArgumentException(
                "numeral " + illegalNumeral + " is not valid: symbol " + illegalSubString + " does not exist or can not be in that position."
        );
    }   
}
