/*
 * Copyright (c) 2023. Chester
 */

package com.chester.leetcode_practice.algorithms

import com.chester.leetcode_practice.leetcodeutils.NumberUtil
import org.junit.jupiter.api.Test
import java.math.BigInteger
import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.util.*
import javax.print.attribute.standard.NumberUp
import javax.security.auth.kerberos.EncryptionKey
import kotlin.test.assertEquals

class RSA {

    /*
    p, q large prime
    e < phi
    0 <= m < n
     */
    lateinit var n: BigInteger
    lateinit var phi: BigInteger
    lateinit var e: BigInteger
    lateinit var d: BigInteger

    fun init(p: BigInteger, q: BigInteger) {
        e = BigInteger.TWO
        n = p * q
        phi = (p - BigInteger.ONE) * (q - BigInteger.ONE)
        while (e < phi) {
            if (NumberUtil.gcd(e, phi) == BigInteger.ONE) break
            e += BigInteger.ONE
        }
//        e = Integer.valueOf(11).toBigInteger()
        var k = 0
        //  e*d | 1 (mod phi)
        //  e * d - 1 = k * phi
        while ((k.toBigInteger() * phi + BigInteger.ONE).remainder(e) != BigInteger.ZERO) {
            k++
        }
        d = (k.toBigInteger() * phi + BigInteger.ONE) / e
//        d = BigInteger.ONE.mod(phi) / e
    }
    fun encrypt(message: BigInteger, n: BigInteger, e: BigInteger): BigInteger {
        return message.modPow(e, n)
    }

    fun decrypt(eMessage: BigInteger, n: BigInteger, d: BigInteger): BigInteger {
        return eMessage.modPow(d, n)
    }

    fun test(p: BigInteger, q: BigInteger, m: BigInteger) {
        init(p, q)
        val message = m
        val eMessage = encrypt(message, n, e)
        println("p = $p\n" +
                "q = $q\n" +
                "n = $n\n" +
                "phi = $phi\n" +
                "e = $e\n" +
                "d = $d\n" +
                "m = $m\n" +
                "eM = $eMessage")
        assertEquals(decrypt(eMessage, n, d), message)
    }

    @Test
    fun test1() {
        test(BigInteger.probablePrime(1024, Random()), BigInteger.probablePrime(1024, Random()), BigInteger(1900, Random()))
    }

    @Test
    fun test2() {
        test(Integer.valueOf(5).toBigInteger(), Integer.valueOf(5).toBigInteger(), Integer.valueOf(24).toBigInteger())
    }

}