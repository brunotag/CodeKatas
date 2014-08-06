/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArabicToRoman.Logic.Internals;

/**
 *
 * @author brunot
 */
public class Digit implements Comparable<Digit> {

    private final String symbol;
    private final int value;
    private final Boolean isConsecutiveToItself;

    public Digit(String symbol, int value){
        this(symbol, value, true);
    }
    
    public Digit(String symbol, int value, Boolean canBeConsecutiveToItself) {
        this.symbol = symbol;
        this.value = value;
        this.isConsecutiveToItself = canBeConsecutiveToItself;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }
    
    @Override
    public int compareTo(Digit otherDigit) {
        return value - otherDigit.value;
    }
        
    public Boolean canBeConsecutiveTo(Digit digit){
        return this.hasSameSymbol(digit) && !this.isConsecutiveToItself;
    }
    
    private Boolean hasSameSymbol(Digit digit){
        return this.getSymbol().equals(digit.getSymbol());
    }    
}
