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
    public MG1Queue(Distribution B, float lambda, float mu, float variance,
                    float cs, float cw) {
        this.A = Distribution.POISSON;
        this.B = B;
        this.s = 1;
        this.N = Integer.MAX_VALUE;
        this.K = Integer.MAX_VALUE;
        this.d = Discipline.FCFS;
        this.lambda = lambda;
        this.mu = mu;
        this.variance = variance;
        this.cs = cs;
        this.cw = cw;
    }
    @Override
    public float calculateCn(int n) { return 0; }
    @Override
    public float calculateLambdaE() { return 0; }
    @Override
    public float calculateL() { return this.calculateRho() + this.calculateLq(); }
    @Override
    public float calculateLq() {
        float temp1 = (float) Math.pow(this.getLambda(), 2);
        float temp2 = (float) Math.pow(this.getVariance(), 2);
        float temp3 = (float) Math.pow(this.calculateRho(), 2);
        float temp4 = (temp1 * temp2) + temp3;
        float temp5 = 2 * (1 - this.calculateRho());
        float result = temp4 / temp5;
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
    public float calculateWq() { return this.calculateLq() / this.getLambda(); }
    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        result.append("M/G/1 Queue:\n");
        result.append("- Kendall Attributes:\n");
        result.append("  - A: " + this.getA() + "\n");
        result.append("  - B: " + this.getB() + "\n");
        result.append("  - s: " + this.getS() + "\n");
        result.append("  - N: " + this.getN() + "\n");
        result.append("  - K: " + this.getK() + "\n");
        result.append("  - d: " + this.getD() + "\n");
        result.append("- Queue Attributes:\n");
        result.append("  - lambda: " + this.getLambda() + "\n");
        result.append("  - mu: " + this.getMu() + "\n");
        result.append("  - variance: " + this.getVariance() + "\n");
        result.append("  - rho: " + this.calculateRho() + "\n");
        result.append("- Cost Attributes:\n");
        result.append("  - cw: " + this.getCw() + "\n");
        result.append("  - cs: " + this.getCs() + "\n");
        result.append("- Results:\n");
        result.append("  - P0: " + this.calculateP0() + "\n");
        result.append("  - PK: " + this.calculatePn(this.getK()) + "\n");
        result.append("- Final Results:\n");
        result.append("  - Lq: " + this.calculateLq() + "\n");
        result.append("  - L: " + this.calculateL() + "\n");
        result.append("  - Wq: " + this.calculateWq() + "\n");
        result.append("  - W: " + this.calculateW() + "\n");
        result.append("  - C: " + this.calculateC() + "\n");
        return result.toString();
    }
}