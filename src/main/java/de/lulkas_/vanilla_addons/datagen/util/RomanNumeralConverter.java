package de.lulkas_.vanilla_addons.datagen.util;

public class RomanNumeralConverter {
    private static final int[] VALUES = {
            10000, 9000, 5000, 4000, 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    private static final String[] SYMBOLS = {
            "X̄", "M̄X̄", "V̄", "M̄V̄", "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    public static String integerToRoman(int num) {
        if (num <= 0 || num > 10000) {
            throw new IllegalArgumentException("Input must be between 1 and 10000");
        }

        StringBuilder roman = new StringBuilder();
        int remaining = num;

        for (int i = 0; i < VALUES.length; i++) {
            while (remaining >= VALUES[i]) {
                roman.append(SYMBOLS[i]);
                remaining -= VALUES[i];
            }
        }

        return roman.toString();
    }
}
