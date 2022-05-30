package com.mms.queues;

import com.mms.util.Util;
/**
 * =============================================================================
 * # Final Project
 *
 * Module | `MMsKQueue.java`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01657110
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * May 12, 2022
 * =============================================================================
 */

public class MMsKQueue extends MGsKQueue {
    //* Constructor
    public MMsKQueue(long s, long K, long lambda, long mu, double cs,
                     double cw) {
        super(Util.Distribution.EXPONENTIAL, s, K, lambda, mu, cs, cw);
        // Main Attributes
        this.name = "M/M/s/K/∞/FIFO";
    }
}