package com.mms.util;

/**
 * =============================================================================
 * # FinalMetodos
 *
 * Module | `Util`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01027543
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * may. 26, 2022
 * =============================================================================
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Util {
    public final static int scale = 4;
    public final static BigDecimal limit = new BigDecimal("5").pow(Util.scale);
    public final static BigDecimal factorialLimit = BigDecimal.ONE.divide(
            new BigDecimal("10").pow(Util.scale));
    public final static RoundingMode roundingMode = RoundingMode.HALF_UP;
    public static BigDecimal factorial(BigDecimal n) {
        if (n.compareTo(BigDecimal.ONE) <= 0) return BigDecimal.ONE;
        else return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
    }
}