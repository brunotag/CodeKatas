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
public class UfoUniverse extends UniverseBase {

    public UfoUniverse() {
        TreeSet<Digit> digits = new TreeSet<>();

        digits.add(new Digit("Uno", 1));
        digits.add(new Digit("Tre", 3));
        digits.add(new Digit("Otto", 8));
        digits.add(new Digit("TrDc", 13));
        digits.add(new Digit("QtDc", 14));
        digits.add(new Digit("OtDc", 18));

        buildDefaultImplementation(digits);
    }

    @Override
    public String getName() {
        return "ufo";
    }
}
