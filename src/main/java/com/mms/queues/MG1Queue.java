package com.mms.queues;

/**
 * =============================================================================
 * # Final Project
 *
 * Module | `MG1Queue.java`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01657110
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * May 12, 2022
 * =============================================================================
 */

public class MG1Queue extends AbstractQueue {

    // Constructor
    public MG1Queue(Distribution B, float lambda, float mu, float variance, float cs, float cw){
    }
    @Override
    public float getCn(int n) throws Exception {
        return 0;
    }
    @Override
    public float getLambdaE() throws Exception {
        return 0;
    }
    @Override
    public float getLq() {
        return 0;
    }
    @Override
    public float getPn(int n) throws Exception {
        return 0;
    }
    @Override
    public float getP0() {
        return 0;
    }
    @Override
    public String print() throws Exception {
        return null;
    }
}