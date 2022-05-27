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

import java.math.BigDecimal;

public abstract class AbstractKendallQueue {
    protected String name;
    protected Distribution A;
    protected Distribution B;
    protected BigDecimal s;
    protected BigDecimal N;
    protected BigDecimal K;
    protected Discipline d;

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public Distribution getA() { return this.A; }
    public void setA(Distribution A) { this.A = A; }

    public Distribution getB() { return this.B; }
    public void setB(Distribution B) { this.B = B; }

    public BigDecimal getS() { return this.s; }
    public void setS(BigDecimal s) { this.s = s; }

    public BigDecimal getN() { return this.N; }
    public void setN(BigDecimal N) { this.N = N; }

    public BigDecimal getK() { return this.K; }
    public void setK(BigDecimal K) { this.K = K; }

    public Discipline getD() { return this.d; }
    public void setD(Discipline D) { this.d = D; }
}