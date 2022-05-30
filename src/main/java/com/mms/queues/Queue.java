package com.mms.queues;

/**
 * =============================================================================
 * # Final Project
 *
 * Module | `Queue.java`
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

import java.math.BigDecimal;

public class Queue extends AbstractQueue {
    //* Constructor
    public Queue(Util.Distribution A, Util.Distribution B, long s, long K,
                 long N, Discipline d, long lambda, long mu, double cs,
                 double cw) {
        // Main Attributes
        this.name = "A/B/s/K/N/d";
        // Kendall Attributes
        this.A = A;
        this.B = B;
        this.s = new BigDecimal(s);
        this.N = new BigDecimal(N);
        this.K = new BigDecimal(K);
        this.d = d;
        // Queue Attributes
        this.lambda = new BigDecimal(lambda);
        this.mu = new BigDecimal(mu);
        // Cost Attributes
        this.cs = new BigDecimal(cs);
        this.cw = new BigDecimal(cw);
    }
}