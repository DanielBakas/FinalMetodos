package com.mms.queues;

/**
 * =============================================================================
 * # Final Project
 *
 * Module | `AbstractQueue.java`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01657110
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * May 12, 2022
 * =============================================================================
 */

public abstract class AbstractQueue extends AbstractKendallQueue implements MMQueueBehavior, CostBehavior {
    protected float lambda;
    protected float mu;
    protected float variance;
    protected float cs;
    protected float cw;

    // Accessors
    @Override
    public float getLambda() { return this.lambda; }
    @Override
    public void setLambda(int lambda) { this.lambda = lambda; }
    @Override
    public float getMu() { return this.mu; }
    @Override
    public void setMu(int mu) { this.mu = mu; }
    @Override
    public float getVariance() { return this.variance; }
    @Override
    public void setVariance(int variance) { this.variance = variance; }
    @Override
    public float getCs() { return this.cs; }
    @Override
    public void setCs(float cs) { this.cs = cs; }
    @Override
    public float getCw() { return this.cw; }
    @Override
    public void setCw(float cw) { this.cw = cw; }
    @Override
    public float calculateRho() { return this.getLambda() / (this.getS() * this.getMu()); }

    @Override
    public float calculateW() {
        float temp = 1 / this.getMu();
        float result = this.calculateWq() + temp;
        return result;
    }

    @Override
    public float calculateWq() {
        return this.calculateLq() / this.getLambda();
    }

    @Override
    public float calculateC() {
        float temp1 = this.calculateLq() * this.getCw();
        float temp2 = this.getS() * this.getCs();
        return temp1 + temp2;
    }

    // Validation Methods
    @Override
    public boolean validateN(int n) { return n >= 0; }
}