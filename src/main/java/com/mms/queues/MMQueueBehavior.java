package com.mms.queues;

/**
 * =============================================================================
 * # FinalMetodos
 *
 * Module | `QueueBehavior.java`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01657110
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * may. 25, 2022
 * =============================================================================
 */

public interface MMQueueBehavior {
    // Accessors
    float getLambda();

    void setLambda(int lambda);

    float getMu();

    void setMu(int mu);

    float getVariance();

    void setVariance(int variance);

    // Calculation Methods
    float calculateCn(int n);

    float calculateLambdaE();

    float calculateL();

    float calculateLq();

    float calculatePn(int n);

    float calculateP0();

    float calculateRho();

    float calculateW();

    float calculateWq();

    // Validation Methods
    boolean validateN(int n);
}