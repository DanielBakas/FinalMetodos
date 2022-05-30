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

import com.mms.util.Util;

import java.math.BigDecimal;

public abstract class AbstractQueue extends AbstractKendallQueue {
    //* Attributes
    protected BigDecimal cs;
    protected BigDecimal cw;
    protected BigDecimal lambda;
    protected BigDecimal mu;
    protected BigDecimal std;

    //* Accessors
    public BigDecimal getCs() { return this.cs; }
    public void setCs(BigDecimal cs) { this.cs = cs; }

    public BigDecimal getCw() { return this.cw; }
    public void setCw(BigDecimal cw) { this.cw = cw; }

    public BigDecimal getLambda() { return this.lambda; }
    public void setLambda(BigDecimal lambda) { this.lambda = lambda; }

    public BigDecimal getMu() { return this.mu; }
    public void setMu(BigDecimal mu) { this.mu = mu; }

    public BigDecimal getStd() { return this.std; }
    public void setStd(BigDecimal std) { this.std = std; }

    //* Calculation Methods
    public BigDecimal calculateCn(BigDecimal n) {
        //* Calculations for Cn...
        // - when n equals 0, Cn has a value of 1.
        if (n.compareTo(BigDecimal.ZERO) == 0) return BigDecimal.ONE;
        // - for all values of n.
        BigDecimal result;
        BigDecimal temp1 = this.getLambda().divide(this.getMu(), Util.scale,
                Util.roundingMode);
        result = temp1.pow(n.intValue());
        // - when n has a value between 1 and s.
        if (n.compareTo(BigDecimal.ONE) >= 0 && n.compareTo(this.getS()) < 0)
            //* Result
            return result.divide(Util.factorial(n), Util.scale,
                    Util.roundingMode);
        // - when n has a value between s and K.
        int temp3 = n.subtract(this.getS()).intValue();
        BigDecimal temp4, temp5, temp6;
        temp4 = Util.factorial(this.getS());
        temp5 = this.getS().pow(temp3);
        temp6 = temp4.multiply(temp5);
        //* Result
        return result.divide(temp6, Util.scale, Util.roundingMode);
    }

    public BigDecimal calculateL() {
        BigDecimal result;
        //* Calculations for L...
        // - when s is equal to 1 and K tends to infinity.
        if (this.getS().compareTo(BigDecimal.ONE) == 0 && this.getK().compareTo(
                Util.infinity) == 0) {
            BigDecimal temp;
            temp = this.getMu().subtract(this.getLambda());
            result = this.getLambda().divide(temp);
            //* Result
            return result;
        }
        // - when s is not 1 and K is lower than infinity.
        if (this.getK().compareTo(Util.infinity) < 0) {
            result = this.calculateLambdaE().multiply(this.calculateW());
            //* Result
            return result.setScale(Util.scale, Util.roundingMode);
        }
        // - when s is greater than one and K tends to infinity.
        BigDecimal temp;
        temp = this.getLambda().divide(this.getMu(), Util.scale,
                Util.roundingMode);
        result = this.calculateLq().add(temp);
        //* Result
        return result;
    }

    public BigDecimal calculateLambdaE() {
        BigDecimal temp, result;
        //* Calculations for LambdaE...
        temp = BigDecimal.ONE.subtract(this.calculatePn(this.getK()));
        result = this.getLambda().multiply(temp);
        //* Result
        return result;
    }

    public BigDecimal calculateLq() {
        BigDecimal result;
        //* Calculations for Lq...
        // - when s is equal to 1 and K tends to infinity.
        if (this.getS().compareTo(BigDecimal.ONE) == 0 && this.getK().compareTo(
                Util.infinity) == 0) {
            BigDecimal temp1, temp2, temp3;
            temp1 = this.getLambda().pow(2);
            temp2 = this.getMu().subtract(this.getLambda());
            temp3 = this.getMu().multiply(temp2);
            result = temp1.divide(temp3, Util.scale, Util.roundingMode);
            //* Result
            return result;
        }
        // - when s has a value lower or equal to K.
        BigDecimal temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8,
                temp9;
        // Section ->
        temp1 = this.getLambda().divide(this.getMu(), Util.scale,
                Util.roundingMode);
        temp2 = temp1.pow(this.getS().intValue());
        temp3 = this.calculateP0().multiply(temp2);
        temp4 = temp3.multiply(this.calculateRho());
        temp5 = Util.factorial(this.getS());
        temp6 = BigDecimal.ONE.subtract(this.calculateRho());
        temp7 = temp6.pow(2);
        temp8 = temp5.multiply(temp7);
        temp9 = temp4.divide(temp8, Util.scale, Util.roundingMode);
        // <- Section
        BigDecimal temp10, temp11, temp12, temp13, temp14, temp15;
        // Section ->
        temp10 = this.getK().subtract(this.getS());
        if (temp10.compareTo(Util.infinity) > 0) return BigDecimal.ZERO;
        temp11 = this.calculateRho().pow(temp10.intValue());
        temp12 = BigDecimal.ONE.subtract(temp11);
        temp13 = temp10.multiply(temp11);
        temp14 = temp13.multiply(temp6);
        temp15 = temp12.subtract(temp14);
        // <- Section
        result = temp15.multiply(temp9);
        //* Result
        return result.setScale(Util.scale, Util.roundingMode);
    }

    public BigDecimal calculatePn(BigDecimal n) {
        //* Result
        return this.calculateCn(n).multiply(this.calculateP0());
    }

    public BigDecimal calculateP0() {
        //* Calculations for P0...
        // Section ->
        BigDecimal temp1, temp2, temp3, temp4, sum1;
        temp1 = this.getLambda().divide(this.getMu(), Util.scale,
                Util.roundingMode);
        sum1 = BigDecimal.ZERO;
        for (int n = 0; n <= this.getS().intValue(); n++) {
            temp2 = temp1.pow(n);
            temp3 = Util.factorial(new BigDecimal(n));
            temp4 = temp2.divide(temp3, Util.scale, Util.roundingMode);
            // Discard Non Significant Figures
            if (temp4.compareTo(Util.decimalLimit) < 0) break;
            sum1 = sum1.add(temp4);
        }
        // <- Section
        // Section ->
        BigDecimal temp5, temp6, temp7;
        temp5 = temp1.pow(this.getS().intValue());
        temp6 = Util.factorial(this.getS());
        temp7 = temp5.divide(temp6, Util.scale, Util.roundingMode);
        // <- Section
        // Section ->
        BigDecimal sum2 = BigDecimal.ZERO;
        for (int n = this.getS().intValue() + 1; n <= this.getK().doubleValue(); n++) {
            temp2 = new BigDecimal(n).subtract(this.getS());
            temp3 = this.calculateRho().pow(temp2.intValue());
            if (temp3.compareTo(Util.decimalLimit) < 0) break;
            sum2 = sum2.add(temp3);
        }
        // <- Section
        BigDecimal temp10, sum3, result;
        temp10 = temp7.multiply(sum2);
        sum3 = sum1.add(temp10);
        result = BigDecimal.ONE.divide(sum3, Util.scale, Util.roundingMode);
        //* Result
        return result;
    }

    public BigDecimal calculateRho() {
        //* Calculations for Rho...
        BigDecimal temp1, result;
        temp1 = this.getS().multiply(this.getMu());
        result = this.getLambda().divide(temp1, Util.scale, Util.roundingMode);
        return result;
    }

    public BigDecimal calculateW() {
        //* Calculations for W...
        // - when s has a value of 1 and K tends to infinity.
        if (this.getS().compareTo(BigDecimal.ONE) == 0 && this.getK().compareTo(
                Util.infinity) == 0)
            return this.calculateL().divide(this.getLambda());
        // - when s is greater or equal to 1.
        if (this.getS().compareTo(BigDecimal.ONE) >= 0) {
            BigDecimal temp = BigDecimal.ONE.divide(this.getMu(), Util.scale,
                    Util.roundingMode);
            return this.calculateWq().add(temp);
        }
        return null;
    }

    public BigDecimal calculateWq() {
        //* Calculations for Wq...
        BigDecimal temp, result;
        temp = (this.getK().compareTo(Util.infinity) < 0) ?
                // - when K is greater or equal to infinity.
                this.calculateLambdaE() :
                // - when K is greater or equal to infinity.
                this.getLambda();
        result = this.calculateLq().divide(temp, Util.scale, Util.roundingMode);
        return result;
    }

    //* Cost Methods
    public BigDecimal calculateCT() {
        //* Calculations for Wq...
        BigDecimal temp1, temp2, result;
        temp1 = this.calculateLq().multiply(this.getCw());
        temp2 = this.getS().multiply(this.getCs());
        result = temp1.add(temp2);
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
        result.append("  - Cn: " + this.calculateCn(BigDecimal.ONE) + "\n");
        result.append("  - P0: " + this.calculateP0() + "\n");
        result.append("  - Pn: " + this.calculatePn(BigDecimal.ONE) + "\n");
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