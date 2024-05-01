package main.util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();

    public static int getRandomInt(int bound) {
        return bound > 1 ? random.nextInt(bound) : 0;
    }


}
