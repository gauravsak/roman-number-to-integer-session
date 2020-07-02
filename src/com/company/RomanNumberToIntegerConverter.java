package com.company;

public class RomanNumberToIntegerConverter {

    public static Integer convertRecursive(String rn) {
        if (rn.length() == 1)
            return value(rn.charAt(0));
        if (rn.length() > 1) {
            if (value(rn.charAt(0)) < value(rn.charAt(1)))
                return convertRecursive(rn.substring(1)) - value(rn.charAt(0));
        }
        return value(rn.charAt(0)) + convertRecursive(rn.substring(1));
    }

    public static int convertTailRecursive(String romanNumber) {
        return convertTailRecursive(romanNumber, 0);
    }

    private static int convertTailRecursive(String rn, int integer) {
        if (rn.length() == 0)
            return integer;
        if (rn.length() == 1)
            return integer + value(rn.charAt(0));
        if (value(rn.charAt(0)) < value(rn.charAt(1)))
            return convertTailRecursive(rn.substring(2), integer + value(rn.charAt(1)) - value(rn.charAt(0)));
        return convertTailRecursive(rn.substring(1), integer + value(rn.charAt(0)));
    }

    public static int convertIterative(String rn) {
        if (rn.length() == 1)
            return value(rn.charAt(0));
        int i = 0;
        int integer = 0;
        while (i < rn.length()) {
            if (i + 1 < rn.length() && value(rn.charAt(i)) < value(rn.charAt(i + 1))) {
                integer -= value(rn.charAt(i));
            } else
                integer += value(rn.charAt(i));
            i++;
        }
        return integer;
    }

    private static Integer value(Character romanNumeral) {
        switch (romanNumeral) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
        }
        return 1000;
    }
}
