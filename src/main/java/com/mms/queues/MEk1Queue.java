package com.mms.queues;

import com.mms.util.Util;
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

public class MEk1Queue extends MG1Queue {
    //* Constructor
    public MEk1Queue(long lambda, long mu, double cs, double cw) {
        super(Util.Distribution.ERLANG, lambda, mu, cs, cw);
        // Main Attributes
        this.name = "M/Ek/1/∞/∞/FIFO";
    }
}