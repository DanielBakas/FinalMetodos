package com.mms.queues;

/**
 * =============================================================================
 * # FinalMetodos
 *
 * Module | `AbstractCostQueue.java`
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

public abstract class AbstractCostQueue extends AbstractKendallQueue implements CostBehavior {
    protected BigDecimal cs;
    protected BigDecimal cw;

    // Accessors
    public BigDecimal getCs() { return this.cs; }
    public void setCs(BigDecimal cs) { this.cs = cs; }

    public BigDecimal getCw() { return this.cw; }
    public void setCw(BigDecimal cw) { this.cw = cw; }
}