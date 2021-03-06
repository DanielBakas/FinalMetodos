/*
================================================================================
# Final Project
Module | `QueueCase.java`

Authors\

May 12, 2022
================================================================================
*/

public abstract class Queue implements QueueBehavior {
    // Attributes
    protected Distribution distribution;
    protected int k;
    protected float lambda;
    protected float mu;
    protected int s;
    protected float variance;

    public Distribution getDistribution() {
        return this.distribution;
    }

    @Override
    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    @Override
    public int getK() {
        return this.k;
    }

    @Override
    public void setK(int k) {
        this.k = k;
    }

    @Override
    public float getLambda() {
        return this.lambda;
    }

    @Override
    public void setLambda(int lambda) {
        this.lambda = lambda;
    }

    @Override
    public float getMu() {
        return this.mu;
    }

    @Override
    public void setMu(int mu) {
        this.mu = mu;
    }

    @Override
    public float getRho() {
        return this.getLambda() / (this.getS() * this.getMu());
    }

    @Override
    public int getS() {
        return this.s;
    }

    @Override
    public void setS(int s) throws Exception {
        this.s = s;
    }

    @Override
    public float getVariance() {
        return this.variance;
    }

    @Override
    public void setVariance(int variance) {
        this.variance = variance;
    }

    // Methods
    @Override
    public float getL() throws Exception {
        return this.getLambdaE() * this.getW();
    }

    @Override
    public float getW() throws Exception {
        float temp1 = 1 / this.getMu();
        return this.getWq() + temp1;
    }

    @Override
    public float getWq() throws Exception {
        return this.getLq() / this.getLambdaE();
    }
}