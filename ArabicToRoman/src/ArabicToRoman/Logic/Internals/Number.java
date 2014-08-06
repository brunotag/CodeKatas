/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArabicToRoman.Logic.Internals;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brunot
 */
public class Number {

    private final List<Digit> digits;

    public Number() {
        digits = new ArrayList<>();
    }

    public void addDigit(Digit digit) {
        digits.add(digit);
    }

    public void addDigitNTimes(Digit digit, int n) {
        for (int i = 0; i < n; i++) {
            this.addDigit(digit);
        }
    }

    public int getValue() {
        int totalValue = 0;
        for (Digit digit : digits) {
            totalValue += digit.getValue();
        }
        return totalValue;
    }

    public String getNumeral() {
        StringBuilder unsignedNumStringBuilder = buildUnsignedNumeral();
        return unsignedNumStringBuilder.toString();
    }

    protected StringBuilder buildUnsignedNumeral() {
        StringBuilder sb = new StringBuilder();
        for (Digit digit : digits) {
            sb.append(digit.getSymbol());
        }
        return sb;
    }

    @Override
    public String toString() {
        return getNumeral();
    }
}
