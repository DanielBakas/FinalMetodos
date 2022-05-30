package com.mms.queues;

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
import com.mms.util.Util.Distribution;

public class QueueFactory {
    public static Queue create(Distribution B, int s, int K, int lambda, int mu,
                               float cs, float cw) {
        // TODO: Implement Validation
        // - n cannot be lower than 0.
        // - n cannot be greater than K.
        // - s cannot be lower than 1.
        // - s cannot be greater than K.
        switch (B) {
            case DEGENERATE:
                return new MD1Queue(lambda, mu, cs, cw);
            case ERLANG:
                return new MEk1Queue(lambda, mu, cs, cw);
            case GENERAL:
                return new MG1Queue(B, lambda, mu, cs, cw);
            case EXPONENTIAL:
                if (K < Util.infinity)
                    return new MMsKQueue(s, K, lambda, mu, cs, cw);
                else if (s > 1) return new MMsQueue(s, lambda, mu, cs, cw);
                else return new MM1Queue(lambda, mu, cs, cw);
            default:
                return null;
        }
    }
}