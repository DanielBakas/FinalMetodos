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

public abstract class AbstractQueue implements QueueBehavior, CostBehavior {
    // Attributes
    protected float cs;
    protected float cw;
    protected Discipline discipline;
    protected int k;
    protected float lambda;

    protected Distribution lambdaDistribution;
    protected float mu;
    protected float N;
    protected int s;
    protected Distribution sDistribution;
    protected float variance;

    // Accessors
    @Override
    public float getC() {
        float temp1 = this.getLq() * this.getCw();
        float temp2 = this.getS() * this.getCs();
        return temp1 + temp2;
    }
    @Override
    public float getCs() { return this.cs; }
    @Override
    public void setCs(float cs) { this.cs = cs; }
    @Override
    public float getCw() { return this.cw; }
    @Override
    public void setCw(float cw) { this.cw = cw; }
    @Override
    public Discipline getDiscipline() { return this.discipline; }
    @Override
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
    @Override
    public int getK() { return this.k; }
    @Override
    public void setK(int k) { this.k = k; }
    @Override
    public float getLambda() { return this.lambda; }
    @Override
    public void setLambda(int lambda) { this.lambda = lambda; }
    public Distribution getLambdaDistribution() { return this.lambdaDistribution; }
    @Override
    public void setLambdaDistribution(Distribution lambdaDistribution) { this.lambdaDistribution = lambdaDistribution; }
    @Override
    public float getMu() { return this.mu; }
    @Override
    public void setMu(int mu) { this.mu = mu; }

    @Override
    public float getN() { return this.N; }
    @Override
    public void setN(int N) { this.N = N; }
    @Override
    public float getRho() { return this.getLambda() / (this.getS() * this.getMu()); }
    @Override
    public int getS() { return this.s; }
    @Override
    public void setS(int s) throws Exception { this.s = s; }
    @Override
    public Distribution getSDistribution() { return this.sDistribution; }
    @Override
    public void setSDistribution(Distribution sDistribution) { this.sDistribution = sDistribution; }
    @Override
    public float getVariance() { return this.variance; }
    @Override
    public void setVariance(int variance) { this.variance = variance; }

    // Methods
    @Override
    public float getL() throws Exception { return this.getLambdaE() * this.getW(); }
    @Override
    public float getW() throws Exception {
        float temp1 = 1 / this.getMu();
        return this.getWq() + temp1;
    }
    @Override
    public float getWq() throws Exception { return this.getLq() / this.getLambdaE(); }
}