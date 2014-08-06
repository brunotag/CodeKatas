/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArabicToRoman.Logic.Internals;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author brunot
 */
class DigitParser {

    Map<String, Digit> availableSymbolsToDigits;

    public DigitParser(Map<String, Digit> symbolsToDigit) {
        availableSymbolsToDigits = new HashMap<>(symbolsToDigit);
    }

    public Digit parseDigit(char[] digitNumeral) {

        StringBuilder currentStringBuilder = new StringBuilder();
        String currentString = currentStringBuilder.toString();

        for (int i = 0; i < digitNumeral.length; i++) {
            currentStringBuilder.append(digitNumeral[i]);
            currentString = currentStringBuilder.toString();
            int occurrences = countSymbolStartsWithString(currentString);
            if (occurrences == 1) {
                return getDigitAndUpdateStatus(currentString);
            }
        }

        if (availableSymbolsToDigits.containsKey(currentString)) {
            return getDigitAndUpdateStatus(currentString);
        }

        for (int i = currentStringBuilder.length() - 1; i >= 0; i--) {
            currentStringBuilder.deleteCharAt(i);
            currentString = currentStringBuilder.toString();
            if (availableSymbolsToDigits.containsKey(currentString)) {
                return getDigitAndUpdateStatus(currentString);
            }
        }

        return null;
    }

    private Digit getDigitAndUpdateStatus(String key) {
        Digit retVal = availableSymbolsToDigits.get(key);
        if (retVal != null) {
            removeBiggerDigits(retVal);
        }
        return retVal;
    }

    private int countSymbolStartsWithString(String str) {
        int retVal = 0;
        for (String symbol : availableSymbolsToDigits.keySet()) {
            if (symbol.startsWith(str)) {
                retVal++;
            }
        }
        return retVal;
    }

    private void removeBiggerDigits(Digit digitToAdd) {
        Set<String> localCopy = new TreeSet<>(availableSymbolsToDigits.keySet());
        for (String currentSymbol : localCopy) {
            Digit currentDigit = availableSymbolsToDigits.get(currentSymbol);
            if (currentDigit.getValue() > digitToAdd.getValue()) {
                availableSymbolsToDigits.remove(currentSymbol);
            }
        }
    }
}
