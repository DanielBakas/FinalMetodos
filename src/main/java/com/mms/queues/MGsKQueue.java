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

import com.mms.util.MathUtils;
import com.mms.util.Util.Discipline;
import com.mms.util.Util.Distribution;

public class MGsKQueue extends Queue {
    //* Constructor
    public MGsKQueue(Distribution B, int s, int K, int lambda, int mu, float cs,
                     float cw) {
        super(Distribution.POISSON, B, s, K, MathUtils.infinity, Discipline.FIFO,
                lambda, mu, cs, cw);
        // Main Attributes
        this.name = "M/G/s/K/∞/FIFO";
    }
}