package com.mms.queues;

/**
 * =============================================================================
 * # Final Project
 *
 * Module | `MD1Queue.java`
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

import java.math.BigDecimal;

public class MD1Queue extends MG1Queue {
    //* Constructor
    public MD1Queue(long lambda, long mu, double cs, double cw) {
        // Super Constructor
        super(Util.Distribution.DEGENERATE, lambda, mu, cs, cw);
        // Main Attributes
        this.name = "M/D/1/∞/∞/FIFO";
        // Queue Attributes
        this.std = BigDecimal.ZERO;
    }
}