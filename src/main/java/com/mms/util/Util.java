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

public final class Util {
    public final static int scale = 4;
    public final static int infinity = (int) Math.pow(5, Util.scale);
    public final static float decimalLimit = (float) Math.pow(10, -Util.scale);

    public static int factorial(int n) {
        if (n > 30) return Util.infinity;
        if (n <= 1) return 1;
        else return n * factorial(n - 1);
    }

    public enum Discipline {
        FIFO,
        LCFS,
        SIRO,
        GD
    }

    public enum Distribution {
        DEGENERATE,
        ERLANG,
        EXPONENTIAL,
        GENERAL,
        POISSON
    }
}