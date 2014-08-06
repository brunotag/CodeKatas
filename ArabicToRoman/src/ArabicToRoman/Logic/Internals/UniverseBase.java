/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ArabicToRoman.Logic.Internals;

import ArabicToRoman.Logic.Universe;
import java.util.Set;

/**
 *
 * @author brunot
 */
abstract class UniverseBase extends Universe {
    
    Set<Digit> digits;
    
    protected final void buildDefaultImplementation(Set<Digit> digits){
        this.conv = new ConverterImpl(digits);
        this.parser = new ParserImpl(digits);
        this.digits = digits;
    }
    
    @Override
    public String getDigitsPrintout(){
        StringBuilder resultBuilder = new StringBuilder();
        for(Digit digit : digits){
            resultBuilder.append(digit.getSymbol());
            resultBuilder.append(" = ");
            resultBuilder.append(digit.getValue());
            resultBuilder.append(System.lineSeparator());
        }
        return resultBuilder.toString();
    }
}
