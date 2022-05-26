package com.mms.queues;

/**
 * =============================================================================
 * # Final Project
 *
 * Module | `MMSKQueue.java`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01657110
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * May 12, 2022
 * =============================================================================
 */

public class MM1Queue extends MMsQueue {

    // Constructor
    public MM1Queue(float lambda, float mu, float cs, float cw) {
        super(1, lambda, mu, cs, cw);
    }

    @Override
    public float calculateL() {
        float temp1 = this.getMu() - this.getLambda();
        float result = this.getLambda() / temp1;
        return result;
    }

    // Methods
    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        result.append("M/M/1 Queue:\n");
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
        result.append("  - rho: " + this.calculateRho() + "\n");
        result.append("  - variance: " + this.getVariance() + "\n");
        result.append("- Cost Attributes:\n");
        result.append("  - cw: " + this.getCw() + "\n");
        result.append("  - cs: " + this.getCs() + "\n");
        result.append("- Results:\n");
        result.append("  - Cn: " + this.calculateCn(1) + "\n");
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