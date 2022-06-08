package com.mms.backend;

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

import com.mms.util.Util.Discipline;
import com.mms.util.Util.Distribution;

public abstract class AbstractKendallQueue {
    protected String name;
    protected Distribution A;
    protected Distribution B;
    protected int s;
    protected int N;
    protected int K;
    protected Discipline d;

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public Distribution getA() { return this.A; }
    public void setA(Distribution A) { this.A = A; }

    public Distribution getB() { return this.B; }
    public void setB(Distribution B) { this.B = B; }

    public int getS() { return this.s; }
    public void setS(int s) { this.s = s; }

    public int getN() { return this.N; }
    public void setN(int N) { this.N = N; }

    public int getK() { return this.K; }
    public void setK(int K) { this.K = K; }

    public Discipline getD() { return this.d; }
    public void setD(Discipline D) { this.d = D; }
}