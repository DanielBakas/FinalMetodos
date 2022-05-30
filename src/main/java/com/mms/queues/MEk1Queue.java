package com.mms.queues;

/**
 * =============================================================================
 * # Final Project
 *
 * Module | `MEk1Queue.java`
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

public class MEk1Queue extends MG1Queue {
    //* Constructor
    public MEk1Queue(int lambda, int mu, float cs, float cw) {
        super(Distribution.ERLANG, lambda, mu, cs, cw);
        // Main Attributes
        this.name = "M/Ek/1/∞/∞/FIFO";
    }
}