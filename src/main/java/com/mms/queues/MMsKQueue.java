package com.mms.queues;

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

import com.mms.util.Util.Distribution;

public class MMsKQueue extends MGsKQueue {
    //* Constructor
    public MMsKQueue(int s, int K, int lambda, int mu, float cs, float cw) {
        super(Distribution.EXPONENTIAL, s, K, lambda, mu, cs, cw);
        // Main Attributes
        this.name = "M/M/s/K/∞/FIFO";
    }
}