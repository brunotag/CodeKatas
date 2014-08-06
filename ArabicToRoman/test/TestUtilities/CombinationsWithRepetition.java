/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestUtilities;

import ArabicToRoman.Logic.Internals.Digit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 *
 * @author brunot
 */
public class CombinationsWithRepetition {

    private final String[] alphabet;
    private final int k;

    public CombinationsWithRepetition(Set<String> alphabet, int k) {
        this.alphabet = alphabet.toArray(new String[alphabet.size()]);
        this.k = k;
    }

    public List<String[]> getVariations() {
        int l = alphabet.length;
        int permutations = (int) Math.pow(l, k);
        String[][] table;
        table = new String[permutations][k];
        for (int x = 0; x < k; x++) {
            int t2 = (int) Math.pow(l, x);
            for (int p1 = 0; p1 < permutations;) {
                for (int al = 0; al < l; al++) {
                    for (int p2 = 0; p2 < t2; p2++) {
                        table[p1][x] = alphabet[al];
                        p1++;
                    }
                }
            }
        }
        List<String[]> result = new ArrayList<>();
        result.addAll(Arrays.asList(table));
        return result;
    }
}
