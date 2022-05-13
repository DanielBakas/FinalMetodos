/*
================================================================================
# Final Project
Module | `QueueBehavior.java`

Authors\

May 12, 2022
================================================================================
*/

public interface QueueBehavior {
    // Getters & Setters
    public Distribution getDistribution();

    public void setDistribution(Distribution distribution);

    public int getK();

    public void setK(int k);

    public float getLambda();

    public void setLambda(int lambda);

    public float getMu();

    public void setMu(int mu);

    public int getS();

    public void setS(int s) throws Exception;

    public float getVariance();

    public void setVariance(int variance);

    // Methods
    public float getCn(int n) throws Exception;

    public float getLambdaE() throws Exception;

    public float getL() throws Exception;

    public float getLq();

    public float getPn(int n) throws Exception;

    public float getP0();

    public float getRho();

    public float getW() throws Exception;

    public float getWq() throws Exception;

    public String print() throws Exception;
}
