package com.mms.queues;

/**
 * =============================================================================
 * # FinalMetodos
 *
 * Module | `QueueBehavior.java`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01027543
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * may. 25, 2022
 * =============================================================================
 */

public interface QueueBehavior {
    // Getters & Setters
    Distribution getDistribution();

    void setDistribution(Distribution distribution);

    int getK();

    void setK(int k);

    float getLambda();

    void setLambda(int lambda);

    float getMu();

    void setMu(int mu);

    int getS();

    void setS(int s) throws Exception;

    float getVariance();

    void setVariance(int variance);

    // Methods
    float getCn(int n) throws Exception;

    float getLambdaE() throws Exception;

    float getL() throws Exception;

    float getLq();

    float getPn(int n) throws Exception;

    float getP0();

    float getRho();

    float getW() throws Exception;

    float getWq() throws Exception;

    String print() throws Exception;
}