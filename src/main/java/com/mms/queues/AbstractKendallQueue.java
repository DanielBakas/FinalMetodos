package com.mms.queues;

/**
 * =============================================================================
 * # FinalMetodos
 *
 * Module | `AbstractKendallQueue.java`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01027543
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * May 26, 2022
 * =============================================================================
 */

public abstract class AbstractKendallQueue implements KendallQueueBehavior {
    protected Distribution A;
    protected Distribution B;
    protected int s;
    protected int N;
    protected int K;
    protected Discipline d;

    @Override
    public Distribution getA() { return this.A; }
    @Override
    public void setA(Distribution A) { this.A = A; }

    @Override
    public Distribution getB() { return this.B; }
    @Override
    public void setB(Distribution B) { this.B = B; }

    @Override
    public int getS() { return this.s; }
    @Override
    public void setS(int s) { this.s = s; }

    @Override
    public int getN() { return this.N; }
    @Override
    public void setN(int N) { this.N = N; }

    @Override
    public int getK() { return this.K; }
    @Override
    public void setK(int K) { this.K = K; }

    @Override
    public Discipline getD() { return this.d; }
    @Override
    public void setD(Discipline D) { this.d = D; }
}