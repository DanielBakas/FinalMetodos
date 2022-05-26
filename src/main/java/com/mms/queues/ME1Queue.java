package com.mms.queues;

public class ME1Queue extends AbstractQueue {
    public ME1Queue(float lambda, float mu, float ew, float cs, float cw) {
    }

    @Override
    public float getCn(int n) throws Exception {
        return 0;
    }

    @Override
    public float getLambdaE() throws Exception {
        return 0;
    }

    @Override
    public float getLq() {
        return 0;
    }

    @Override
    public float getPn(int n) throws Exception {
        return 0;
    }

    @Override
    public float getP0() {
        return 0;
    }

    @Override
    public String print() throws Exception {
        return null;
    }
}
