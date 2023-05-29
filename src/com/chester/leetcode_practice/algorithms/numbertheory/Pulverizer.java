/*
 * Copyright (c) 2023. Chester
 */

package com.chester.leetcode_practice.algorithms.numbertheory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Pulverizer {
    /*
    x = s1*a + t1*b
    y = s2*a + t2*b
    r = x - q*y = (s1 - q*s2)*a + (t1 - q*t2)*b
     */
    public static int[] pulverizer(int a, int b, int[] ar, int[] br) {
        if (a == 0 && b == 0) {
            throw new ArithmeticException();
        }
        int[] result;
        int x = ar[0] * a + ar[1] * b;
        int y = br[0] * a + br[1] * b;
        if (y == 0) {
            result = ar;
        } else {
            int q = x / y;
            result = pulverizer(a,
                    b,
                    br,
                    new int[]{ar[0] - q * br[0], (ar[1] - q * br[1])});
        }
        return result;
    }

    @Test
    void test() {
        int[] actual = pulverizer(899, 493, new int[]{1, 0}, new int[]{0, 1});
        int[] expect = {-6, 11};
        assertArrayEquals(expect, actual);
    }

}
