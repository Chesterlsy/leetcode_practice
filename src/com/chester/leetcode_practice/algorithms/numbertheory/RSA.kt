/*
 * Copyright (c) 2023. Chester
 */

package com.chester.leetcode_practice.algorithms.numbertheory

import com.chester.leetcode_practice.leetcodeutils.NumberUtil
import org.junit.jupiter.api.Test
import java.math.BigInteger
import java.util.*
import kotlin.test.assertEquals

/**
 * choose p, q large prime
 *
 * n = p*q
 *
 * phi = (p-1)*(q-1)
 *
 * choose e < phi and gcd(e, phi) = 1
 *
 * e*d = 1 (mod phi)
 *
 * choose 0 <= m < n
 *
 * m' = m ^ e (mod n)
 *
 * m = m' ^ d (mod n)
 */
class RSA {


    lateinit var n: BigInteger
    lateinit var phi: BigInteger
    lateinit var e: BigInteger
    lateinit var d: BigInteger

    fun init(p: BigInteger, q: BigInteger) {
        n = p * q
        phi = (p - BigInteger.ONE) * (q - BigInteger.ONE)

        e = (p + q) / BigInteger.TWO
        while (e < phi) {
            if (NumberUtil.gcd(e, phi) == BigInteger.ONE) break
            e++
        }

        //  e*d | 1 (mod phi)
        //  e * d - 1 = k * phi
//        var k = 0
//        while ((k.toBigInteger() * phi + BigInteger.ONE).remainder(e) != BigInteger.ZERO) {
//            k++
//        }
//        d = (k.toBigInteger() * phi + BigInteger.ONE) / e
        d = PulverizerBigInteger.pulverizerPositiveS(e, phi)[0]
    }

    fun encrypt(message: BigInteger, n: BigInteger, e: BigInteger): BigInteger {
        return message.modPow(e, n)
    }

    fun decrypt(eMessage: BigInteger, n: BigInteger, d: BigInteger): BigInteger {
        return eMessage.modPow(d, n)
    }

    fun test(p: BigInteger, q: BigInteger, m: BigInteger) {
        init(p, q)
        val eMessage = encrypt(m, n, e)
        println(
            "p = $p\n" +
                    "q = $q\n" +
                    "n = $n\n" +
                    "phi = $phi\n" +
                    "e = $e\n" +
                    "d = $d\n" +
                    "m = $m\n" +
                    "eM = $eMessage"
        )
        assertEquals(decrypt(eMessage, n, d), m)
    }

    @Test
    fun test1() {
        test(
            BigInteger.probablePrime(1024, Random()),
            BigInteger.probablePrime(1024, Random()),
            BigInteger(1900, Random())
        )
    }

    @Test
    fun test2() {
        test(Integer.valueOf(5).toBigInteger(), Integer.valueOf(5).toBigInteger(), Integer.valueOf(24).toBigInteger())
    }

}