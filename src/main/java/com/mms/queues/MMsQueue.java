package com.mms.queues;

/**
 * =============================================================================
 * # Final Project
 *
 * Module | `MMsQueue.java`
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

public class MMsQueue extends MMsKQueue {
    // Constructor
    public MMsQueue(long s, long lambda, long mu, double cs, double cw) {
        // Super Constructor
        super(s, Util.infinity.intValue(), lambda, mu, cs, cw);
        // Main Attributes
        this.name = "M/M/s/∞/∞/FIFO";
    }
}