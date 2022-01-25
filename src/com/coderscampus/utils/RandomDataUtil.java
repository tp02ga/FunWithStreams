package com.coderscampus.utils;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDataUtil {
    public static LocalDate generateDate() {
        long minDay = LocalDate.now().minusDays(90).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    }

    public static Integer generateRandomNumber(int lowerBound, int upperBound) {
        Random random = new Random();

        return random.nextInt(upperBound) + lowerBound;
    }
}
