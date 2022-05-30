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

import com.mms.util.Util.Discipline;
import com.mms.util.Util.Distribution;

public class Queue extends AbstractQueue {
    //* Constructor
    public Queue(Distribution A, Distribution B, int s, int K, int N,
                 Discipline d, int lambda, int mu, float cs, float cw) {
        // Main Attributes
        this.name = "A/B/s/K/N/d";
        // Kendall Attributes
        this.A = A;
        this.B = B;
        this.s = s;
        this.N = N;
        this.K = K;
        this.d = d;
        // Queue Attributes
        this.lambda = lambda;
        this.mu = mu;
        // Cost Attributes
        this.cs = cs;
        this.cw = cw;
    }
}