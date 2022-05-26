package com.mms.queues;

public class MD1Queue extends AbstractQueue {

    public MD1Queue(float lambda, float mu, float cs, float cw) {
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
