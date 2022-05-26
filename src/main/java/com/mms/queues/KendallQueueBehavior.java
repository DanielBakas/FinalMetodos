package com.mms.queues;

/**
 * =============================================================================
 * # FinalMetodos
 *
 * Module | `QueueBehavior.java`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01657110
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * may. 25, 2022
 * =============================================================================
 */

public interface KendallQueueBehavior {
    // Accessors
    Distribution getA();

    void setA(Distribution A);

    Distribution getB();

    void setB(Distribution B);

    int getS();

    void setS(int s);

    int getN();

    void setN(int N);

    int getK();

    void setK(int K);

    Discipline getD();

    void setD(Discipline D);

    // Methods
    String print();
}