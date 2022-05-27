package com.mms.queues;

import com.mms.util.Util;

import java.math.BigDecimal;
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

public class MMsKQueue extends AbstractQueue {
    // Constructor
    public MMsKQueue(long s, long K, long lambda, long mu, double cs,
                     double cw) {
        // Main Attributes
        this.name = "M/M/s/K";
        // Kendall Attributes
        this.A = Distribution.POISSON;
        this.B = Distribution.EXPONENTIAL;
        this.s = new BigDecimal(s);
        this.N = Util.limit;
        this.K = new BigDecimal(K);
        this.d = Discipline.FCFS;
        // Queue Attributes
        this.lambda = new BigDecimal(lambda);
        this.mu = new BigDecimal(mu);
        // Cost Attributes
        this.cs = new BigDecimal(cs);
        this.cw = new BigDecimal(cw);
    }
}
/*
    // Constructor
    public MMsKQueue(int s, int K, float lambda, float mu, float cs, float cw) {
        // Kendall Attributes
        this.A = Distribution.POISSON;
        this.B = Distribution.EXPONENTIAL;
        this.N = Integer.MAX_VALUE;
        this.s = s;
        this.K = K;
        this.d = Discipline.FCFS;
        // Queue Attributes
        this.lambda = lambda;
        this.mu = mu;
        this.std = 0;
        // Cost Attributes
        this.cs = cs;
        this.cw = cw;
    }

    @Override
    public float calculateCn(int n) {
        if (!this.nIsValid(n)) return 0;
        if (n >= 0 && n <= this.getS()) {
            float temp1 = this.getLambda() / this.getMu();
            float temp2 = (float) Math.pow(temp1, n);
            float temp3 = (float) MathUtils.factorial(n);
            float result = temp2 / temp3;
            return result;
        } else if (n >= this.s && n <= this.getK()) {
            float temp1 = this.getLambda() / this.getMu();
            float temp2 = (float) Math.pow(temp1, n);
            float temp3 = (float) MathUtils.factorial(this.getS());
            temp3 *= (float) Math.pow(this.getS(), n - this.getS());
            float result = temp2 / temp3;
            return result;
        }
        return 0;
    }
    // Calculation Methods
    @Override
    public float calculateL() { return this.calculateLambdaE() * this
    .calculateW(); }

    @Override
    public float calculateLq() {
        float temp1 = this.getLambda() / this.getMu();
        float temp2 = (float) Math.pow(temp1, this.getS());
        float temp3 = this.calculateP0() * temp2 * this.calculateRho();
        float temp4 = (float) MathUtils.factorial(this.getS());
        float temp5 = 1 - this.calculateRho();
        float temp6 = (float) Math.pow(temp5, 2);
        temp4 *= temp6;
        float temp7 = temp3 / temp4;
        float temp8 = this.getK() - this.getS();
        float temp9 = (float) Math.pow(this.calculateRho(), temp8);
        float temp11 = temp8 * temp9 * temp5;
        float temp12 = 1 - temp9 - temp11;
        float result = temp7 * temp12;
        return result;
    }

    @Override
    public float calculateLambdaE() {
        float temp = 1 - this.calculatePn(this.getK());
        float result = this.getLambda() * temp;
        return result;
    }

    @Override
    public float calculateP0() {
        float temp1 = this.getLambda() / this.getMu();
        float sum1 = 0;
        float temp2, temp3;
        for (int n = 0; n <= this.getS(); n++) {
            temp2 = (float) Math.pow(temp1, n);
            temp3 = (float) MathUtils.factorial(n);
            sum1 += temp2 / temp3;
        }
        float temp4 = (float) Math.pow(temp1, this.getS());
        float temp5 = (float) MathUtils.factorial(this.getS());
        float temp6 = temp4 / temp5;
        float sum2 = 0;
        float temp7, temp8;
        for (int n = this.getS() + 1; n <= this.getK(); n++) {
            temp7 = n - this.getS();
            temp8 = (float) Math.pow(this.calculateRho(), temp7);
            sum2 += temp8;
        }
        float temp10 = temp6 * sum2;
        float sum3 = sum1 + temp10;
        float result = 1 / sum3;
        return result;
    }

    @Override
    public float calculatePn(int n) {
        // TODO: Replace Condition with Exception
        if (!this.nIsValid(n)) return 0;
        return this.calculateCn(n) * this.calculateP0();
    }

    @Override
    public float calculateRho() {
        float temp = this.getS() * this.getMu();
        float result = this.getLambda() / temp;
        return result;
    }

    @Override
    public float calculateWq() { return this.calculateLq() / this
    .calculateLambdaE(); }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        result.append("M/M/s/K Queue:\n");
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
        result.append("  - variance: " + this.getStd() + "\n");
        result.append("  - rho: " + this.calculateRho() + "\n");
        result.append("- Cost Attributes:\n");
        result.append("  - cw: " + this.getCw() + "\n");
        result.append("  - cs: " + this.getCs() + "\n");
        result.append("- Results:\n");
        result.append("  - Cn: " + this.calculateCn(this.getK()) + "\n");
        result.append("  - P0: " + this.calculateP0() + "\n");
        result.append("  - PK: " + this.calculatePn(this.getK()) + "\n");
        result.append("  - Lambda E: " + this.calculateLambdaE() + "\n");
        result.append("- Final Results:\n");
        result.append("  - Lq: " + this.calculateLq() + "\n");
        result.append("  - L: " + this.calculateL() + "\n");
        result.append("  - Wq: " + this.calculateWq() + "\n");
        result.append("  - W: " + this.calculateW() + "\n");
        result.append("  - C: " + this.calculateC() + "\n");
        return result.toString();
    }
}

 */