/*
 * Copyright (c) 2023. Chester
 */

package com.chester.leetcode_practice.algorithms.numbertheory

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigInteger

class PulverizerBigInteger {
    companion object {
        fun pulverizer(a: BigInteger, b: BigInteger): Array<BigInteger> =
            pulverizer(a, b, arrayOf(BigInteger.ONE, BigInteger.ZERO), arrayOf(BigInteger.ZERO, BigInteger.ONE))

        fun pulverizer(a: Int, b: Int): Array<BigInteger> =
            pulverizer(a.toBigInteger(), b.toBigInteger())
        fun pulverizer(a: BigInteger, b: BigInteger, ar: Array<BigInteger>, br: Array<BigInteger>): Array<BigInteger> {
            if (a == BigInteger.ZERO && b == BigInteger.ZERO) {
                throw ArithmeticException()
            }
            val result: Array<BigInteger>
            val x: BigInteger = ar[0] * a + ar[1] * b
            val y: BigInteger = br[0] * a + br[1] * b
            if (y == BigInteger.ZERO) {
                result = ar
            } else {
                val q = x / y
                result = pulverizer(
                    a,
                    b,
                    br,
                    arrayOf(ar[0] - q * br[0], ar[1] - q * br[1])
                )
            }
            // x < 0
            // x < 0
            if (result[0] * a + result[1] * b < BigInteger.ZERO) {
                result.forEach {
                    -it
                }
//                result[0] = -result[0]
//                result[1] = -result[1]
            }
            return result
        }

        fun pulverizerPositiveS(a: BigInteger, b: BigInteger): Array<BigInteger> {
            val result = pulverizer(a, b)
            val s = result[0]
            if (a != BigInteger.ZERO && b != BigInteger.ZERO && s < BigInteger.ZERO) {
                // (s + k*b)*a + (t - k*a)*b
                // k*b + s > 0
                val k: BigInteger
                = if (b > BigInteger.ZERO) { // k > -s/b
                    -s / b + BigInteger.ONE
                } else { // k < -s/b
                    -s / b - BigInteger.ONE
                }
                result[0] += k * b
                result[1] += -k * a
            }
            return result
        }

    }

    @Test
    fun test() {
        Assertions.assertArrayEquals(intArrayOf(-6, 11), Pulverizer.pulverizer(899, 493))
        Assertions.assertArrayEquals(intArrayOf(11, -6), Pulverizer.pulverizer(493, 899))
        Assertions.assertArrayEquals(intArrayOf(6, 11), Pulverizer.pulverizer(-899, 493))
        Assertions.assertArrayEquals(intArrayOf(-6, -11), Pulverizer.pulverizer(899, -493))
        Assertions.assertArrayEquals(intArrayOf(6, -11), Pulverizer.pulverizer(-899, -493))
        Assertions.assertArrayEquals(intArrayOf(1, 0), Pulverizer.pulverizer(899, 0))
        Assertions.assertArrayEquals(intArrayOf(0, 1), Pulverizer.pulverizer(0, 493))
    }

    @Test
    fun testPositiveS() {
        Assertions.assertArrayEquals(intArrayOf(487, -888), Pulverizer.pulverizerPositiveS(899, 493))
        Assertions.assertArrayEquals(intArrayOf(6, 11), Pulverizer.pulverizerPositiveS(-899, 493))
        Assertions.assertArrayEquals(intArrayOf(487, 888), Pulverizer.pulverizerPositiveS(899, -493))
        Assertions.assertArrayEquals(intArrayOf(6, -11), Pulverizer.pulverizerPositiveS(-899, -493))
        Assertions.assertArrayEquals(intArrayOf(1, 0), Pulverizer.pulverizerPositiveS(899, 0))
        Assertions.assertArrayEquals(intArrayOf(0, 1), Pulverizer.pulverizerPositiveS(0, 493))
    }
}