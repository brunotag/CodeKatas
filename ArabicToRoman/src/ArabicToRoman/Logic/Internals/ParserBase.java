/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArabicToRoman.Logic.Internals;

import ArabicToRoman.Logic.Parser;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author brunot
 */
abstract class ParserBase implements Parser {

    protected final TreeSet<Digit> digits;

    protected ParserBase(Set<Digit> digits) {
        if (digits == null) {
            throw new IllegalArgumentException("the set of digits 'digits' must not be null.");
        }

        this.digits = new TreeSet<>(digits);
    }
}
