package com.mms.backend;

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

import com.mms.util.Util;

public abstract class AbstractQueue extends AbstractKendallQueue {
    //* Attributes
    protected float cs;
    protected float cw;
    protected float lambda;
    protected float mu;
    protected float std;

    //* Accessors
    public float getCs() { return this.cs; }
    public void setCs(float cs) { this.cs = cs; }

    public float getCw() { return this.cw; }
    public void setCw(float cw) { this.cw = cw; }

    public float getLambda() { return this.lambda; }
    public void setLambda(float lambda) { this.lambda = lambda; }

    public float getMu() { return this.mu; }
    public void setMu(float mu) { this.mu = mu; }

    public float getStd() { return this.std; }
    public void setStd(float std) { this.std = std; }

    //* Calculation Methods
    public float calculateCn(int n) {
        //* Calculations for Cn...
        // - when n equals 0, Cn has a value of 1.
        if (n == 0) return 1.0f;
        // - for all values of n.
        float result;
        float temp1 = this.getLambda() / this.getMu();
        result = (float) Math.pow(temp1, n);
        // - when n has a value between 1 and s.
        if (n >= 1 && n < this.getS())
            //* Result
            return result / Util.factorial(n);
        // - when n has a value between s and K.
        int temp3 = n - this.getS();
        float temp4, temp5, temp6;
        temp4 = Util.factorial(this.getS());
        temp5 = (float) Math.pow(this.getS(), temp3);
        temp6 = temp4 * temp5;
        //* Result
        return result / temp6;
    }

    public float calculateL() {
        float result;
        //* Calculations for L...
        // - when s is equal to 1 and K tends to infinity.
        if (this.getS() == 1 && this.getK() == Util.infinity) {
            float temp;
            temp = this.getMu() - this.getLambda();
            result = this.getLambda() / temp;
            //* Result
            return result;
        }
        // - when s greater or equal to 1 and K is lower than infinity.
        if (this.getS() >= 1 && this.getK() < Util.infinity) {
            result = this.calculateLambdaE() * this.calculateW();
            //* Result
            return result;
        }
        // - when s is greater than one and K tends to infinity.
        float temp;
        temp = this.getLambda() / this.getMu();
        result = this.calculateLq() + temp;
        //* Result
        return result;
    }

    public float calculateLambdaE() {
        float temp, result;
        //* Calculations for LambdaE...
        temp = 1 - this.calculatePn(this.getK());
        result = this.getLambda() * temp;
        //* Result
        return result;
    }

    public float calculateLq() {
        float result;
        //* Calculations for Lq...
        // - when s is equal to 1 and K tends to infinity.
        if (this.getS() == 1 && this.getK() == Util.infinity) {
            float temp1, temp2, temp3;
            temp1 = (float) Math.pow(this.getLambda(), 2);
            temp2 = this.getMu() - this.getLambda();
            temp3 = this.getMu() * temp2;
            result = temp1 / temp3;
            //* Result
            return result;
        }
        // - when s has a value lower or equal to K.
        float temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9;
        // Section ->
        temp1 = this.getLambda() / this.getMu();
        temp2 = (float) Math.pow(temp1, this.getS());
        temp3 = this.calculateP0() * temp2;
        temp4 = temp3 * this.calculateRho();
        // <- Section
        // Section ->
        temp5 = Util.factorial(this.getS());
        temp6 = 1 - this.calculateRho();
        temp7 = (float) Math.pow(temp6, 2);
        temp8 = temp5 * temp7;
        // <- Section
        // Section ->
        temp9 = temp4 / temp8;
        // <- Section
        if (this.getK() == Util.infinity) return temp9;
        // Section ->
        float temp10, temp11, temp12, temp13, temp14;
        temp10 = this.getK() - this.getS();
        temp11 = (float) Math.pow(this.calculateRho(), temp10);
        temp12 = temp10 * temp11 * temp6;
        temp13 = 1 - temp11;
        temp14 = temp13 - temp12;
        // <- Section
        result = temp9 * temp14;
        //* Result
        return result;
    }

    public float calculatePn(int n) {
        //* Result
        return this.calculateCn(n) * this.calculateP0();
    }

    public float calculateP0() {
        //* Calculations for P0...
        // Section ->
        float temp1, temp2, temp3, temp4, sum1;
        temp1 = this.getLambda() / this.getMu();
        sum1 = 0;
        for (int n = 0; n <= this.getS(); n++) {
            temp2 = (float) Math.pow(temp1, n);
            temp3 = Util.factorial(n);
            temp4 = temp2 / temp3;
            // Discard Non Significant Figures
            if (temp4 < Util.decimalLimit) break;
            sum1 = sum1 + temp4;
        }
        // <- Section
        // Section ->
        float temp5, temp6, temp7;
        temp5 = (float) Math.pow(temp1, this.getS());
        temp6 = Util.factorial(this.getS());
        temp7 = temp5 / temp6;
        // <- Section
        // Section ->
        float sum2 = 0;
        for (int n = (this.getS() + 1); n <= this.getK(); n++) {
            temp2 = n - this.getS();
            temp3 = (float) Math.pow(this.calculateRho(), temp2);
            if (temp3 < Util.decimalLimit) break;
            sum2 += temp3;
        }
        // <- Section
        float temp10, sum3, result;
        temp10 = temp7 * sum2;
        sum3 = sum1 + temp10;
        result = 1 / sum3;
        //* Result
        return result;
    }

    public float calculateRho() {
        //* Calculations for Rho...
        float temp1, result;
        temp1 = this.getS() * this.getMu();
        result = this.getLambda() / temp1;
        //* Result
        return result;
    }

    public float calculateW() {
        //* Calculations for W...
        // - when s has a value of 1 and K tends to infinity.
        if (this.getS() == 1 && this.getK() == Util.infinity)
            return this.calculateL() / this.getLambda();
        // - when s is greater or equal to 1.
        if (this.getS() >= 1) {
            float temp = (float) 1 / this.getMu();
            return this.calculateWq() + temp;
        }
        return -Util.infinity;
    }

    public float calculateWq() {
        //* Calculations for Wq...
        float temp, result;
        temp = (this.getK() < Util.infinity) ?
                // - when K is greater or equal to infinity.
                this.calculateLambdaE() :
                // - when K is greater or equal to infinity.
                this.getLambda();
        result = this.calculateLq() / temp;
        return result;
    }

    //* Cost Methods
    public float calculateCT() {
        //* Calculations for Wq...
        float temp1, temp2, result;
        temp1 = this.calculateLq() * this.getCw();
        temp2 = this.getS() * this.getCs();
        result = temp1 + temp2;
        return result;
    }

    //* Object Methods
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.getName() + "\n");
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
        result.append("- Cost Attributes:\n");
        result.append("  - cs: " + this.getCs() + "\n");
        result.append("  - cw: " + this.getCw() + "\n");
        result.append("- Results:\n");
        result.append("  - Cn: " + this.calculateCn(1) + "\n");
        result.append("  - P0: " + this.calculateP0() + "\n");
        result.append("  - Pn: " + this.calculatePn(1) + "\n");
        result.append("  - PK: " + this.calculatePn(this.getK()) + "\n");
        result.append("- Final Results:\n");
        result.append("  - rho: " + this.calculateRho() + "\n");
        result.append("  - Lq: " + this.calculateLq() + "\n");
        result.append("  - L: " + this.calculateL() + "\n");
        result.append("  - Wq: " + this.calculateWq() + "\n");
        result.append("  - W: " + this.calculateW() + "\n");
        result.append("  - CT: " + this.calculateCT() + "\n");
        //* Result
        return result.toString();
    }
}