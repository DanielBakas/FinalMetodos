package com.mms.queues;

/**
 * =============================================================================
 * # Final Project
 *
 * Module | `MMSKQueue.java`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01657110
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * May 12, 2022
 * =============================================================================
 */

public class MM1Queue extends MMsQueue {

    // Constructor
    public MM1Queue(long lambda, long mu, double cs, double cw) {
        // Super Constructor
        super(1, lambda, mu, cs, cw);
        // Main Attributes
        this.name = "M/M/1";
    }
}