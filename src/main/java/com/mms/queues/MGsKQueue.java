package com.mms.queues;

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

public class MGsKQueue extends Queue {
    //* Constructor
    public MGsKQueue(Util.Distribution B, long s, long K, long lambda, long mu,
                     double cs, double cw) {
        super(Util.Distribution.POISSON, B, s, K, Util.infinity.longValue(),
                Discipline.FIFO, lambda, mu, cs, cw);
        // Main Attributes
        this.name = "M/G/s/K/∞/FIFO";
    }
}