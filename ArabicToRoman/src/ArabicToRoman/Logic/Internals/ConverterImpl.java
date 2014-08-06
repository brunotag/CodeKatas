/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArabicToRoman.Logic.Internals;

import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author brunot
 */
class ConverterImpl extends ConverterBase {

    public ConverterImpl(Set<Digit> digits) {
        super(digits);
    }

    @Override
    public Number getNumberFromValue(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("the number must be positive integer");
        }

        Number resultingNumber = new Number();

        resultingNumber = convertWithMaxDivAlgorithm(number, resultingNumber);

        return resultingNumber;
    }

    private Number convertWithMaxDivAlgorithm(int integerToBeConverted, Number resultingNumber) {
        Iterator iterator = digits.descendingIterator();
        while (iterator.hasNext() && integerToBeConverted > 0) {
            Digit currentDigit = (Digit) iterator.next();
            int integerDivision = integerToBeConverted / currentDigit.getValue();
            if (integerDivision > 0) {
                resultingNumber.addDigitNTimes(currentDigit, integerDivision);
                integerToBeConverted -= integerDivision * currentDigit.getValue();
            }
        }
        return resultingNumber;
    }

}
