/*
 * Copyright (c) 2023. Chester
 */

package com.chester.leetcode_practice.algorithms.numbertheory;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GreatestCommonDivisor {
    public static int gcd(int a, int b) {
        if (a == 0 && b == 0) {
            throw new ArithmeticException();
        }
        int x = a;
        int y = b;
        while (y != 0) {
            int x1 = y;
            y = x % y;
            x = x1;
        }
        return x;
    }

    public static int gcdRecursive(int a, int b) {
        if (a == 0 && b == 0) {
            throw new ArithmeticException();
        }
        if (b == 0) {
            return a;
        }
        return gcdRecursive(b, a % b);
    }

    @Test
    public void testGCDPositiveNumbers() {
        int result = gcd(48, 18);
        assertEquals(6, result);
    }

    @Test
    public void testGCDFirstZero() {
        int result = gcd(0, 12);
        assertEquals(12, result);
    }

    @Test
    public void testGCDSecondZero() {
        int result = gcd(24, 0);
        assertEquals(24, result);
    }

    @Test
    public void testGCDBothZero() {
        assertThrows(ArithmeticException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                gcd(0, 0);
            }
        });
    }

    @Test
    public void testGCDNegativeNumbers() {
        int result = gcd(-36, -48);
        assertEquals(12, result);
    }
}
