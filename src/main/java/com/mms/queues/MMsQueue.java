package com.mms.queues;

import org.apache.commons.math.util.MathUtils;
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

public class MMsQueue extends MMsKQueue {

    // Constructor
    public MMsQueue(int s, float lambda, float mu, float cs, float cw) {
        super(s, Integer.MAX_VALUE, lambda, mu, cs, cw);
    }

    // Methods
    @Override
    public float calculateLambdaE() {
        float temp1 = 1 - this.calculatePn(this.getK());
        float result = this.getLambda() * temp1;
        return result;
    }

    @Override
    public float calculateL() {
        float temp1 = this.getLambda() / this.getMu();
        float result = this.calculateLq() + temp1;
        return result;
    }

    @Override
    public float calculateLq() {
        float temp1 = this.getLambda() / this.getMu();
        float temp2 = (float) Math.pow(temp1, this.getS());
        float temp3 = this.calculateP0() * temp2 * this.calculateRho();
        float temp4 = (float) MathUtils.factorial(this.getS());
        float temp5 = 1 - this.calculateRho();
        float temp6 = (float) Math.pow(temp5, 2);
        temp4 *= temp6;
        float result = temp3 / temp4;
        return result;
    }

    @Override
    public float calculateP0() {
        if (this.getS() == 1) return 1 - this.calculateRho();
        float temp1 = this.getLambda() / this.getMu();
        float sum1 = 0;
        float temp2, temp3;
        for (int n = 0; n < this.getS(); n++) {
            temp2 = (float) Math.pow(temp1, n);
            temp3 = (float) MathUtils.factorial(n);
            sum1 += temp2 / temp3;
        }
        float temp4 = (float) Math.pow(temp1, this.getS());
        float temp5 = (float) MathUtils.factorial(this.getS());
        float temp6 = temp4 / temp5;
        float temp8 = 1 - this.calculateRho();
        float temp9 = 1 / temp8;
        float temp10 = temp6 * temp9;
        float sum2 = sum1 + temp10;
        float result = 1 / sum2;
        return result;
    }

    @Override
    public float calculateWq() { return this.calculateLq() / this.getLambda(); }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        result.append("M/M/s Queue:\n");
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