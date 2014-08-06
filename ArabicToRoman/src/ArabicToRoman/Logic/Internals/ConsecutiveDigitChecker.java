/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArabicToRoman.Logic.Internals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author brunot
 */
public class ConsecutiveDigitChecker {

    private final ArrayList<Digit> digitArray;

    private Digit currentDigit;

    public ConsecutiveDigitChecker(TreeSet<Digit> digits) {
        digitArray = new ArrayList<>();
        Iterator<Digit> iterator = digits.iterator();
        while (iterator.hasNext()) {
            digitArray.add(iterator.next());
        }
    }
    
    public void reset(){
        currentDigit = null;
    }

    public void updateDigit(Digit digit) {
        currentDigit = digit;
    }
    
    public Boolean isInvalidDigitSequence(Digit digit){
        return  currentDigit != null &&(
                (currentDigit.canBeConsecutiveTo(digit))
                ||
                (existsDigitBiggerThanCurrent() && getSumWithCurrentDigit(digit) == getValueOfBiggerThanCurrent())
                );
    }
    
    private Boolean existsDigitBiggerThanCurrent() {
        return digitArray.indexOf(currentDigit) < digitArray.size() - 1;
    }
    
    private int getSumWithCurrentDigit(Digit digit) {
        return currentDigit.getValue() + digit.getValue();
    }
    
    private int getValueOfBiggerThanCurrent() {
        return  digitArray.get(
                    digitArray.indexOf(currentDigit) + 1
                ).getValue();
    }
}
