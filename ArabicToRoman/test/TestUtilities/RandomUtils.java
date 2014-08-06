/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestUtilities;

import TestUtilities.RandomString;
import java.util.Random;

/**
 *
 * @author brunot
 */
public class RandomUtils {

    private static final RandomString randomStringBuilder = new RandomString(10);
    private static final Random randomIntegerBuilder = new Random();

    public static String getRandomString() {
        return randomStringBuilder.nextString();
    }

    public static int getRandomPositiveInteger() {
        return getRandomPositiveIntegerLimited(1000000);
    }

    public static int getRandomPositiveIntegerLimited(int limit) {
        return randomIntegerBuilder.nextInt(limit) + 1;
    }
}
