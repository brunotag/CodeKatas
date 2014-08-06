/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArabicToRoman.Logic;

import ArabicToRoman.Logic.Internals.Number;

/**
 *
 * @author brunot
 */
public interface Parser {

    Number parseNumberFromNumeral(String numeral);

}
