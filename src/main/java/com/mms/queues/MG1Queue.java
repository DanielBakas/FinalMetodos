package com.mms.queues;/*
================================================================================
# Final Project
Module | `queues.MG1Queue.java`

Authors\

May 12, 2022
================================================================================
*/

public class MG1Queue extends Queue {

    @Override
    public float getCn(int n) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getLambdaE() throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getL() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getLq() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getPn(int n) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getP0() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getRho() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getW() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getWq() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String print() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    // Constructor
    public MG1Queue(
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