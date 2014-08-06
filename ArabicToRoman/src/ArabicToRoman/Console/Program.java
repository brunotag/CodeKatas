/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArabicToRoman.Console;

import ArabicToRoman.Logic.Universe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author brunot
 */
public class Program {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        Universe univ = Universe.getDefaultUniverse();
        BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(univ.getDigitsPrintout());

        char answer;
        do {
            System.out.println("Mode?(m:massive testing, n:normal)");
            answer = consoleIn.readLine().charAt(0);
        } while (answer != 'n' && answer != 'm');

        if (answer == 'm') {
            try {
                massiveTesting(univ, consoleIn);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (answer == 'n') {
            parseOrConvertSingles(univ, consoleIn);
        }
    }

    private static void massiveTesting(Universe univ, BufferedReader consoleIn) throws IOException, Exception {
        int maxNumber;
        System.out.println("Insert top number to reach");
        maxNumber = Integer.parseInt(consoleIn.readLine());
        for (int i = 1; i <= maxNumber; i++) {
            String numeral = univ.getConverter().getNumberFromValue(i).toString();
            int value = univ.getParser().parseNumberFromNumeral(numeral).getValue();
            if (value != i) {
                throw new Exception("No good: calculated is " + numeral + ", parsed is " + value + ", i is " + i);
            }
        }
        System.out.println("OK");
    }

    private static void parseOrConvertSingles(Universe univ, BufferedReader consoleIn) throws IOException {
        char answer;
        do {
            do {
                System.out.println("Action?(p:parse, c:convert, n:nothing)");
                answer = consoleIn.readLine().charAt(0);
            } while (answer != 'n' && answer != 'p' && answer != 'c');

            if (answer == 'c') {
                System.out.println("Input an integer number");
                int number = Integer.parseInt(consoleIn.readLine());
                System.out.println("Equivalent " + univ.getName() + " numeral:");
                System.out.println(univ.getConverter().getNumberFromValue(number));
            } else if (answer == 'p') {
                System.out.println("Input a " + univ.getName() + " numeral");
                String numeral = consoleIn.readLine();
                System.out.println("Equivalent integer number: ");
                System.out.println(univ.getParser().parseNumberFromNumeral(numeral).getValue());
            }
        } while (answer != 'n');
    }

}
