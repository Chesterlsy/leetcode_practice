/*
 * Copyright (c) 2023. Chester
 */

package com.chester.leetcode_practice.leetcodeutils;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberUtil {
    /*
    a < b
     */
    public static int gcd(int a, int b) {
        if (a == 0) return b;
        else return gcd(b%a, a);
    }
    public static BigInteger gcd(BigInteger a, BigInteger b) {
        if (a.equals(BigInteger.ZERO)) return b;
        else return gcd(b.remainder(a), a);
    }

    public static BigInteger generateBigInteger(int bits) {
        BigInteger prime;
        do {
            prime = new BigInteger(bits, new Random());
        } while (!prime.isProbablePrime(100));
        return prime;
    }

    @Test
    public void testBI() {
        BigInteger prime = BigInteger.probablePrime(1024, new Random());
        System.out.println(prime);
        System.out.println(isPrime(prime.longValue()));
        for (BigInteger e = BigInteger.TWO; e.compareTo(prime)<0; e = e.add(BigInteger.ONE)) {

        }
    }

    public static Boolean isPrime(long n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
            if (i % n == 0) return false;
        }
        return true;
    }
}
