/*
================================================================================
# Final Project
Module | `QueueCase.java`

Authors\

May 12, 2022
================================================================================
*/

public class MMSKQueue extends Queue {

    // Getters & Setters
    @Override
    public void setS(int s) throws Exception {
        if (s <= this.k)
            this.s = s;
        else
            throw new Exception("Attribute 's' can not be greater than 'k'.");
    }

    // Methods
    @Override
    public float getCn(int n) throws Exception {
        if (n > this.k)
            return 0;
        else if (n >= 0 && n <= this.getS()) {
            float temp1 = this.getLambda() / this.getMu();
            float temp2 = (float) Math.pow(temp1, n);
            float temp3 = Factorial.calculate(n);
            float result = temp2 / temp3;
            return result;
        } else if (n >= this.s && n <= this.k) {
            float temp1 = this.getLambda() / this.getMu();
            float temp2 = (float) Math.pow(temp1, n);
            float temp3 = Factorial.calculate(this.getS());
            temp3 *= (float) Math.pow(this.getS(), n - this.getS());
            float result = temp2 / temp3;
            return result;
        } else
            throw new Exception("Invalid value for parameter 'n'.");
    }

    @Override
    public float getLambdaE() throws Exception {
        float temp1 = 1 - this.getPn(this.getK());
        float result = this.getLambda() * temp1;
        return result;
    }

    @Override
    public float getLq() {
        // Product Left Side
        float temp1 = this.getLambda() / this.getMu();
        float temp2 = (float) Math.pow(temp1, this.getS());
        float temp3 = Factorial.calculate(this.getS());
        float temp4 = (float) Math.pow(1 - this.getRho(), 2);
        float temp5 = temp3 * temp4;
        float temp6 = this.getP0() * temp2 * this.getRho();
        float temp7 = temp6 / temp5;
        // Product Right Side
        float temp90 = (float) Math.pow(this.getRho(), this.getK() - this.getS());
        float temp93 = this.getK() - this.getS();
        float temp95 = 1 - this.getRho();
        float temp96 = temp93 * temp90 * temp95;
        float temp99 = 1 - temp90 - temp96;
        float result = temp7 * temp99;
        return result;
    }

    @Override
    public float getPn(int n) throws Exception {
        return (n > this.k) ? 0 : this.getCn(n) * this.getP0();
    }

    @Override
    public float getP0() {
        float temp1 = this.getLambda() / this.getMu();
        float temp2 = (float) Math.pow(temp1, this.getS());
        int temp3 = Factorial.calculate(this.getS());
        float temp4 = temp2 / temp3;
        float sum1 = 0.0f;
        float temp5 = 0.0f;
        float temp6 = 0.0f;
        float temp7 = 0.0f;
        for (int n = 0; n < this.getS(); n++) {
            temp5 = (float) Math.pow(temp1, n);
            temp6 = Factorial.calculate(n);
            temp7 = temp5 / temp6;
            sum1 += temp4 + temp7;
        }
        float sum2 = 0.0f;
        float temp10 = (float) Math.pow(temp1, this.getS());
        float temp11 = Factorial.calculate(this.getS());
        float temp12 = temp10 / temp11;
        float temp13 = 0.0f;
        for (int n = (this.getS() + 1); n <= this.getK(); n++) {
            temp13 = (float) Math.pow(this.getRho(), n - this.getS());
            sum2 += temp13;
        }
        float temp14 = temp12 * sum2;
        float temp15 = sum1 + temp14;
        float result = 1 / temp15;
        return result;
    }

    @Override
    public String print() throws Exception {
        StringBuilder result = new StringBuilder();
        result.append("M/M/S/K Queue:\n");
        result.append("- Attributes:\n");
        result.append("  - Distribution: " + this.getDistribution() + "\n");
        result.append("  - k: " + this.getK() + "\n");
        result.append("  - lambda: " + this.getLambda() + "\n");
        result.append("  - mu: " + this.getMu() + "\n");
        result.append("  - s: " + this.getS() + "\n");
        result.append("  - variance: " + this.getVariance() + "\n");
        result.append("- Results:\n");
        result.append("  - P0: " + this.getP0() + "\n");
        result.append("  - Pk: " + this.getPn(this.getK()) + "\n");
        result.append("  - Lambda E: " + this.getLambdaE() + "\n");
        result.append("  - Wq: " + this.getWq() + "\n");
        result.append("  - W: " + this.getW() + "\n");
        result.append("  - Lq: " + this.getLq() + "\n");
        result.append("  - L: " + this.getL() + "\n");
        return result.toString();
    }

    // Constructor
    public MMSKQueue(
            Distribution distribution,
            int k,
            float lambda,
            float mu,
            int s,
            float variance) throws Exception {
        this.distribution = distribution;
        this.k = k;
        this.lambda = lambda;
        this.mu = mu;
        this.setS(s);
        this.variance = variance;
    }
}