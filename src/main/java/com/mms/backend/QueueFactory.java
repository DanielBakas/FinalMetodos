package com.mms.backend;

/**
 * =============================================================================
 * # FinalMetodos
 *
 * Module | `QueueBuilder`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01027543
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * may. 30, 2022
 * =============================================================================
 */

import com.mms.util.Util;

public class QueueFactory {
    public static Queue create(int s, int K, int lambda, int mu, float cs,
                               float cw) {
        // TODO: Implement Validation
        // - n cannot be lower than 0.
        // - n cannot be greater than K.
        // - s cannot be lower than 1.
        // - s cannot be greater than K.
        if (K < Util.infinity) return new MMsKQueue(s, K, lambda, mu, cs, cw);
        else if (s > 1) return new MMsQueue(s, lambda, mu, cs, cw);
        else return new MM1Queue(lambda, mu, cs, cw);
    }
}