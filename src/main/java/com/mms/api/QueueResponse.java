package com.mms.api;

public class QueueResponse {
    private double P0;
    private double pk;
    private double lambdaE;
    private double wq;
    private double w;
    private double lq;
    private double l;
    private double ct;

    public QueueResponse(double p0, double pk, double lambdaE, double wq,
                         double w, double lq, double l, double ct) {
        P0 = p0;
        this.pk = pk;
        this.lambdaE = lambdaE;
        this.wq = wq;
        this.w = w;
        this.lq = lq;
        this.l = l;
    }

    public QueueResponse() { }

    public double getPk() {
        return pk;
    }

    public void setPk(double pk) {
        this.pk = pk;
    }

    public double getLambdaE() {
        return lambdaE;
    }

    public void setLambdaE(double lambdaE) {
        this.lambdaE = lambdaE;
    }

    public double getWq() {
        return wq;
    }

    public void setWq(double wq) {
        this.wq = wq;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getLq() {
        return lq;
    }

    public void setLq(double lq) {
        this.lq = lq;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }

    public double getP0() {
        return P0;
    }

    public void setP0(double p0) { P0 = p0; }

    public double getCt() {
        return ct;
    }
    public void setCt(double ct) {
        this.ct = ct;
    }
}