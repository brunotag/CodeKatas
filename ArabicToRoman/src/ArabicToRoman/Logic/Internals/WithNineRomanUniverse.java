/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArabicToRoman.Logic.Internals;

import ArabicToRoman.Logic.Universe;
import java.util.TreeSet;

/**
 *
 * @author brunot
 */
public class WithNineRomanUniverse extends UniverseBase {

    public WithNineRomanUniverse() {
        TreeSet<Digit> digits = new TreeSet<>();

        digits.add(new Digit("I", 1));
        digits.add(new Digit("V", 5));
        digits.add(new Digit("IX", 9, false));
        digits.add(new Digit("X", 10));
        digits.add(new Digit("L", 50));
        digits.add(new Digit("C", 100));
        digits.add(new Digit("XC", 90, false));
        digits.add(new Digit("D", 500));
        digits.add(new Digit("CM", 900, false));
        digits.add(new Digit("M", 1000));

        buildDefaultImplementation(digits);
    }

    @Override
    public String getName() {
        return "Roman (9s)";
    }
}
