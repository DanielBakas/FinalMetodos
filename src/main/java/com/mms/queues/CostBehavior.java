package com.mms.queues;

/**
 * =============================================================================
 * # Final Project
 *
 * Module | `CostBehavior.java`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01657110
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * May 12, 2022
 * =============================================================================
 */

public interface CostBehavior {
    public float getC();

    public float getCs();

    public void setCs(float cs);

    public float getCw();

    public void setCw(float cw);
}