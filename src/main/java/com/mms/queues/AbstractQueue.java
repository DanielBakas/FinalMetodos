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

public abstract class AbstractQueue extends AbstractCostQueue
        implements QueueBehavior {
    protected BigDecimal lambda;
    protected BigDecimal mu;
    protected BigDecimal std;

    // Accessors
    public BigDecimal getLambda() { return this.lambda; }
    public void setLambda(BigDecimal lambda) { this.lambda = lambda; }

    public BigDecimal getMu() { return this.mu; }
    public void setMu(BigDecimal mu) { this.mu = mu; }

    public BigDecimal getStd() { return this.std; }
    public void setStd(BigDecimal std) { this.std = std; }

    //  Methods
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
        if (this.isValid(this.getK()))
            result.append("  - PK: " + this.calculatePn(this.getK()) + "\n");
        result.append("- Final Results:\n");
        result.append("  - rho: " + this.calculateRho() + "\n");
        result.append("  - Lq: " + this.calculateLq() + "\n");
        result.append("  - L: " + this.calculateL() + "\n");
        result.append("  - Wq: " + this.calculateWq() + "\n");
        result.append("  - W: " + this.calculateW() + "\n");
        result.append("  - C: " + this.calculateCT() + "\n");
        return result.toString();
    }

    // Calculation Methods
    @Override
    public BigDecimal calculateCn(BigDecimal n) {
        if (!this.isValid(n)) return null;
        if (n.compareTo(BigDecimal.ZERO) == 0) return BigDecimal.ONE;
        if (n.compareTo(this.getK()) > 0) return BigDecimal.ZERO;
        BigDecimal result;
        BigDecimal temp1 = this.getLambda().divide(this.getMu(), Util.scale,
                Util.roundingMode);
        BigDecimal temp2 = temp1.pow(n.intValue());
        if (n.compareTo(BigDecimal.ONE) >= 0 && n.compareTo(this.getS()) < 0) {
            BigDecimal temp3 = Util.factorial(n);
            result = temp2.divide(temp3, Util.scale, Util.roundingMode);
            return result;
        } else if (n.compareTo(this.getS()) >= 0 && n.compareTo(
                this.getK()) <= 0) {
            BigDecimal temp3 = Util.factorial(this.getS());
            int temp4 = n.subtract(this.getS()).intValue();
            BigDecimal temp5 = this.getS().pow(temp4);
            BigDecimal temp6 = temp3.multiply(temp5);
            result = temp2.divide(temp6, Util.scale, Util.roundingMode);
            return result;
        }
        return null;
    }

    @Override
    public BigDecimal calculateL() {
        if (this.getS().compareTo(BigDecimal.ONE) == 0 && this.getK().compareTo(
                Util.limit) == 0) {
            BigDecimal temp = this.getMu().subtract(this.getLambda());
            BigDecimal result = this.getLambda().divide(temp);
            return result;
        } else if (this.getK().compareTo(Util.limit) < 0) {
            BigDecimal temp = this.calculateLambdaE().multiply(
                    this.calculateW());
            return temp.setScale(Util.scale, Util.roundingMode);
        } else if (this.getS().compareTo(BigDecimal.ONE) >= 0) {
            BigDecimal temp = this.getLambda().divide(this.getMu(), Util.scale,
                    Util.roundingMode);
            BigDecimal result = this.calculateLq().add(temp);
            return result.setScale(Util.scale, Util.roundingMode);
        }
        return null;
    }

    @Override
    public BigDecimal calculateLambdaE() {
        BigDecimal temp = BigDecimal.ONE.subtract(
                this.calculatePn(this.getK()));
        BigDecimal result = this.getLambda().multiply(temp);
        return result;
    }

    @Override
    public BigDecimal calculateLambdaN(BigDecimal n) {
        if (!this.isValid(n)) return null;
        return this.getLambda();
    }
    @Override
    public BigDecimal calculateLq() {
        if (this.getS().compareTo(BigDecimal.ONE) == 0 && this.getK().compareTo(
                Util.limit) == 0) {
            BigDecimal temp1 = this.getLambda().pow(2);
            BigDecimal temp2 = this.getMu().subtract(this.getLambda());
            temp2 = this.getMu().multiply(temp2);
            BigDecimal result = temp1.divide(temp2, Util.scale,
                    Util.roundingMode);
            return result;
        } else if (this.getS().compareTo(BigDecimal.ONE) >= 0) {
            // Left Side
            BigDecimal temp1 = this.getLambda().divide(this.getMu(), Util.scale,
                    Util.roundingMode);
            BigDecimal temp2 = temp1.pow(this.getS().intValue()).setScale(
                    Util.scale, Util.roundingMode);
            BigDecimal temp3 = this.calculateP0().multiply(temp2);
            BigDecimal temp4 = temp3.multiply(this.calculateRho());
            BigDecimal temp5 = Util.factorial(this.getS());
            BigDecimal temp6 = BigDecimal.ONE.subtract(this.calculateRho());
            BigDecimal temp7 = temp6.pow(2).setScale(Util.scale,
                    Util.roundingMode);
            BigDecimal temp8 = temp5.multiply(temp7);
            BigDecimal temp9 = temp4.divide(temp8, Util.scale,
                    Util.roundingMode);
            // HASTA AQUI BIEN
            // Right Side
            BigDecimal temp10 = this.getK().subtract(this.getS());
            if (temp10.compareTo(Util.limit) > 0) return BigDecimal.ZERO;
            BigDecimal temp11 = this.calculateRho().pow(temp10.intValue());
            BigDecimal temp13 = temp10.multiply(temp11);
            BigDecimal temp14 = temp13.multiply(temp6);
            BigDecimal temp12 = BigDecimal.ONE.subtract(temp11);
            BigDecimal temp15 = temp12.subtract(temp14);
            BigDecimal result = temp15.multiply(temp9);
            return result.setScale(Util.scale, Util.roundingMode);
        }
        return null;
    }

    @Override
    public BigDecimal calculateMuN(BigDecimal n) {
        BigDecimal result;
        if (!this.isValid(n)) return null;
        if (n.compareTo(BigDecimal.ONE) >= 0 && n.compareTo(this.getS()) < 0) {
            result = n.multiply(this.getMu());
            return result.setScale(Util.scale, Util.roundingMode);
        } else if (n.compareTo(this.getS()) >= 0) {
            result = this.getS().multiply(this.getMu());
            return result.setScale(Util.scale, Util.roundingMode);
        }
        return null;
    }
    @Override
    public BigDecimal calculatePn(BigDecimal n) {
        if (!this.isValid(n)) return null;
        BigDecimal result = this.calculateCn(n).multiply(this.calculateP0());
        return result.setScale(Util.scale, Util.roundingMode);
    }

    @Override
    public BigDecimal calculateP0() {
        if (!this.isValid(this.getS())) return null;
        if (this.getS().compareTo(BigDecimal.ONE) >= 0 && this.getS().compareTo(
                this.getK()) <= 0) {
            BigDecimal temp1 = this.getLambda().divide(this.getMu(), Util.scale,
                    Util.roundingMode);
            BigDecimal sum1 = BigDecimal.ZERO;
            BigDecimal temp2, temp3, temp4;
            for (int n = 0; n <= this.getS().intValue(); n++) {
                temp2 = temp1.pow(n);
                temp3 = Util.factorial(new BigDecimal(n));
                temp4 = temp2.divide(temp3, Util.scale, Util.roundingMode);
                if (temp4.compareTo(Util.factorialLimit) < 0) break;
                sum1 = sum1.add(temp4);
            }
            BigDecimal temp5 = temp1.pow(this.getS().intValue());
            BigDecimal temp6 = Util.factorial(this.getS());
            BigDecimal temp7 = temp5.divide(temp6, Util.scale,
                    Util.roundingMode);
            // Hasta aquí igual que MMs
            BigDecimal sum2 = BigDecimal.ZERO;
            for (int n = this.getS().intValue() + 1; n <= this.getK().doubleValue(); n++) {
                temp2 = new BigDecimal(n).subtract(this.getS());
                temp3 = this.calculateRho().pow(temp2.intValue());
                if (temp3.compareTo(Util.factorialLimit) < 0) break;
                sum2 = sum2.add(temp3);
            }
            BigDecimal temp10 = temp7.multiply(sum2);
            BigDecimal sum3 = sum1.add(temp10);
            BigDecimal result = BigDecimal.ONE.divide(sum3, Util.scale,
                    Util.roundingMode);
            return result;
        }
        return null;
    }
    @Override
    public BigDecimal calculateRho() {
        BigDecimal temp1 = this.getS().multiply(this.getMu());
        BigDecimal result = this.getLambda().divide(temp1, Util.scale,
                Util.roundingMode);
        return result;
    }

    @Override
    public BigDecimal calculateW() {
        if (this.getS().compareTo(BigDecimal.ONE) == 0 && this.getK().compareTo(
                Util.limit) == 0)
            return this.calculateL().divide(this.getLambda());
        else if (this.getS().compareTo(BigDecimal.ONE) >= 0) {
            BigDecimal temp = BigDecimal.ONE.divide(this.getMu(), Util.scale,
                    Util.roundingMode);
            return this.calculateWq().add(temp);
        }
        return null;
    }

    @Override
    public BigDecimal calculateWq() {
        if (this.getK().compareTo(Util.limit) < 0) {
            BigDecimal result = this.calculateLq().divide(
                    this.calculateLambdaE(), Util.scale, Util.roundingMode);
            return result.setScale(Util.scale, Util.roundingMode);
        }
        BigDecimal result = this.calculateLq().divide(this.getLambda(),
                Util.scale, Util.roundingMode);
        return result.setScale(Util.scale, Util.roundingMode);
    }

    // Cost Methods
    @Override
    public BigDecimal calculateCT() {
        BigDecimal temp1 = this.calculateLq().multiply(this.getCw());
        BigDecimal temp2 = this.getS().multiply(this.getCs());
        BigDecimal result = temp1.add(temp2);
        return result.setScale(Util.scale, Util.roundingMode);
    }

    // Validation Methods
    @Override
    public boolean isValid(BigDecimal value) {
        boolean result = value != null;
        result &= value.compareTo(BigDecimal.ZERO) >= 0;
        result &= value.compareTo(Util.limit) < 0;
        return result;
    }
}