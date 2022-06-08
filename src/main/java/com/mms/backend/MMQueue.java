package com.mms.backend;

/**
 * =============================================================================
 * # Final Project
 *
 * Module | `MGsKQueue.java`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01657110
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * May 12, 2022
 * =============================================================================
 */

import com.mms.util.Util;
import com.mms.util.Util.Discipline;
import com.mms.util.Util.Distribution;

public class MMQueue extends Queue {
    //* Constructor
    public MMQueue(int s, int K, int lambda, int mu, float cs, float cw) {
        super(Distribution.POISSON, Distribution.EXPONENTIAL, s, K,
                Util.infinity, Discipline.FIFO, lambda, mu, cs, cw);
        // Main Attributes
        this.name = "M/G/s/K/∞/FIFO";
    }
}