package com.mms.queues;

import com.mms.util.Util;

import java.math.BigDecimal;
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

public class MMsKQueue extends AbstractQueue {
    // Constructor
    public MMsKQueue(long s, long K, long lambda, long mu, double cs,
                     double cw) {
        // Main Attributes
        this.name = "M/M/s/K";
        // Kendall Attributes
        this.A = Distribution.POISSON;
        this.B = Distribution.EXPONENTIAL;
        this.s = new BigDecimal(s);
        this.N = Util.limit;
        this.K = new BigDecimal(K);
        this.d = Discipline.FCFS;
        // Queue Attributes
        this.lambda = new BigDecimal(lambda);
        this.mu = new BigDecimal(mu);
        // Cost Attributes
        this.cs = new BigDecimal(cs);
        this.cw = new BigDecimal(cw);
    }
}