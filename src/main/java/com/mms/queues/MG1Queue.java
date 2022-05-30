package com.mms.queues;

/**
 * =============================================================================
 * # Final Project
 *
 * Module | `MG1Queue.java`
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

public class MG1Queue extends MGsKQueue {
    //* Constructor
    public MG1Queue(Util.Distribution B, long lambda, long mu, double cs,
                    double cw) {
        super(B, 1, Util.infinity.longValue(), lambda, mu, cs, cw);
        // Main Attributes
        this.name = "M/G/1/∞/∞/FIFO";
    }
}