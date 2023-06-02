/*
 * Copyright (c) 2023. Chester
 */

package com.chester.leetcode_practice.algorithms.numbertheory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Pulverizer {

    /*
    gcd(a, b) = s*a + t*b
     */
    public static int[] pulverizer(int a, int b) {
        return pulverizer(a, b, new int[]{1, 0}, new int[]{0, 1});
    }

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
        // x < 0
        if (result[0] * a + result[1] * b < 0) {
            result[0] *= -1;
            result[1] *= -1;
        }
        return result;
    }

    public static int[] pulverizerPositiveS(int a, int b) {
        int[] result = pulverizer(a, b);
        int s = result[0];
        if (a != 0 && b != 0 && s < 0) {
            // (s + k*b)*a + (t - k*a)*b
            // k*b + s > 0
            int k;
            if (b > 0) { // k > -s/b
                k = -s / b + 1;
            } else { // k < -s/b
                k = -s / b - 1;
            }
            result[0] += k * b;
            result[1] += -k * a;
        }
        return result;
    }

    @Test
    void test() {
        assertArrayEquals(new int[]{-6, 11}, pulverizer(899, 493));
        assertArrayEquals(new int[]{11, -6}, pulverizer(493, 899));
        assertArrayEquals(new int[]{6, 11}, pulverizer(-899, 493));
        assertArrayEquals(new int[]{-6, -11}, pulverizer(899, -493));
        assertArrayEquals(new int[]{6, -11}, pulverizer(-899, -493));
        assertArrayEquals(new int[]{1, 0}, pulverizer(899, 0));
        assertArrayEquals(new int[]{0, 1}, pulverizer(0, 493));
    }

    @Test
    void testPositiveS() {
        assertArrayEquals(new int[]{487, -888}, pulverizerPositiveS(899, 493));
        assertArrayEquals(new int[]{6, 11}, pulverizerPositiveS(-899, 493));
        assertArrayEquals(new int[]{487, 888}, pulverizerPositiveS(899, -493));
        assertArrayEquals(new int[]{6, -11}, pulverizerPositiveS(-899, -493));
        assertArrayEquals(new int[]{1, 0}, pulverizerPositiveS(899, 0));
        assertArrayEquals(new int[]{0, 1}, pulverizerPositiveS(0, 493));
    }

}
