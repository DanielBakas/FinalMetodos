package com.mms.queues;

/**
 * =============================================================================
 * # Final Project
 *
 * Module | `Factorial.java`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01657110
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * May 12, 2022
 * =============================================================================
 */

public class Factorial {
    public static int calculate(int n) {
        if (n <= 1) return 1;
        else return n * calculate(n - 1);
    }
}