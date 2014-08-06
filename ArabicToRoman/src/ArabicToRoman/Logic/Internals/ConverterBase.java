/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArabicToRoman.Logic.Internals;

import ArabicToRoman.Logic.Converter;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author brunot
 */
abstract class ConverterBase implements Converter {

    protected final TreeSet<Digit> digits;

    protected ConverterBase(Set<Digit> digits) {
        if (digits == null) {
            throw new IllegalArgumentException("the set of digits 'digits' must not be null.");
        }

        if (!seeIfContainsOne(digits)) {
            throw new IllegalArgumentException("the set of digits 'digits' must contain a digit with a value of '1'.");
        }

        this.digits = new TreeSet<>(digits);
    }

    private Boolean seeIfContainsOne(Set<Digit> digits) {
        for (Digit digit : digits) {
            if (1 == digit.getValue()) {
                return true;
            }
        }
        return false;
    }
}
