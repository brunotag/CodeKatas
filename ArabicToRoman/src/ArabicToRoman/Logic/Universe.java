/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArabicToRoman.Logic;

import ArabicToRoman.Logic.Internals.UfoUniverse;
import ArabicToRoman.Logic.Internals.*;
import java.util.Set;

/**
 *
 * @author brunot
 */
public abstract class Universe {

    protected Converter conv;
    protected Parser parser;

    public Converter getConverter() {
        return conv;
    }
    
    public Parser getParser() {
        return parser;
    }

    public abstract String getName();
    
    public static Universe getDefaultUniverse(){
        return new WithNineAndFourRomanUniverse();
    }
    
    public abstract String getDigitsPrintout();
}
