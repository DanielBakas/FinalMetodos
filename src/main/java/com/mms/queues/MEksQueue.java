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

public class MEksQueue extends AbstractQueue {
    protected float kErlang;

    // Constructor
    public MEksQueue(Distribution B, float kErlang, float lambda, float mu,
                     float cs, float cw) {
        this.A = Distribution.POISSON;
        this.B = B;
        this.s = 1;
        this.N = Integer.MAX_VALUE;
        this.K = Integer.MAX_VALUE;
        this.d = Discipline.FCFS;
        this.kErlang = kErlang;
        this.lambda = lambda;
        this.mu = mu;
        this.variance = 0;
        this.cs = cs;
        this.cw = cw;
    }

    // Accessors
    public float getkErlang() { return kErlang; }
    public void setkErlang(float kErlang) { this.kErlang = kErlang; }

    @Override
    public float calculateCn(int n) {
        return 0;
    }
    @Override
    public float calculateLambdaE() {
        return 0;
    }
    @Override
    public float calculateL() { return this.calculateRho() + this.calculateLq(); }
    @Override
    public float calculateLq() {
        float temp1 = 1 + this.getkErlang();
        float temp2 = 2 * this.getkErlang();
        float temp3 = temp1 / temp2;
        float temp4 = (float) Math.pow(this.getLambda(), 2);
        float temp5 = this.getMu() - this.getLambda();
        float temp6 = this.getMu() * temp5;
        float temp7 = temp4 / temp6;
        float result = temp3 * temp7;
        return result;
    }
    @Override
    public float calculatePn(int n) {
        if (!this.validateN(n)) return 0;
        float temp = (float) Math.pow(this.calculateRho(), n);
        float result = temp * this.calculateP0();
        return result;
    }
    @Override
    public float calculateP0() { return 1 - this.calculateRho(); }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        result.append("M/Ek/s Queue:\n");
        result.append("- Kendall Attributes:\n");
        result.append("  - A: " + this.getA() + "\n");
        result.append("  - B: " + this.getB() + "\n");
        result.append("  - s: " + this.getS() + "\n");
        result.append("  - N: " + this.getN() + "\n");
        result.append("  - K: " + this.getK() + "\n");
        result.append("  - d: " + this.getD() + "\n");
        result.append("- Queue Attributes:\n");
        result.append("  - kErlang: " + this.getkErlang() + "\n");
        result.append("  - lambda: " + this.getLambda() + "\n");
        result.append("  - mu: " + this.getMu() + "\n");
        result.append("  - variance: " + this.getVariance() + "\n");
        result.append("  - rho: " + this.calculateRho() + "\n");
        result.append("- Cost Attributes:\n");
        result.append("  - cw: " + this.getCw() + "\n");
        result.append("  - cs: " + this.getCs() + "\n");
        result.append("- Results:\n");
        result.append("  - P0: " + this.calculateP0() + "\n");
        result.append("  - Pn: " + this.calculatePn(1) + "\n");
        result.append("- Final Results:\n");
        result.append("  - Lq: " + this.calculateLq() + "\n");
        result.append("  - L: " + this.calculateL() + "\n");
        result.append("  - Wq: " + this.calculateWq() + "\n");
        result.append("  - W: " + this.calculateW() + "\n");
        result.append("  - C: " + this.calculateC() + "\n");
        return result.toString();
    }
}