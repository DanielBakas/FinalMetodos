package com.mms.queues;

/**
 * =============================================================================
 * # Final Project
 *
 * Module | `QueueTests.java`
 *
 * Daniel Bakas Amuchástegui          A01657103
 * Santiago Hernández Guerrero        A01027543
 * Oscar Vargas Pérez                 A01657110
 * Oscar Alfredo Belmont Rodríguez    A01654861
 *
 * May 12, 2022
 * =============================================================================
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueuesTests {
    @Test
    @DisplayName("MM1Queue(2, 3, 100, 100)")
    void mm1_1() {
        AbstractQueue queue = new MM1Queue(2, 3, 100, 100);
        assertEquals(new BigDecimal("0.6667"), queue.calculateRho());
        assertEquals(new BigDecimal("1.3333"), queue.calculateLq());
        assertEquals(new BigDecimal("2"), queue.calculateL());
        assertEquals(new BigDecimal("0.6667"), queue.calculateWq());
        assertEquals(new BigDecimal("1"), queue.calculateW());
        assertEquals(new BigDecimal("233.3300"), queue.calculateCT());
    }

    @Test
    @DisplayName("MM1Queue(161, 162, 101, 120)")
    void mm1_2() {
        AbstractQueue queue = new MM1Queue(161, 162, 101, 120);
        assertEquals(new BigDecimal("0.9938"), queue.calculateRho());
        assertEquals(new BigDecimal("160.0062"), queue.calculateLq());
        assertEquals(new BigDecimal("161"), queue.calculateL());
        assertEquals(new BigDecimal("0.9938"), queue.calculateWq());
        assertEquals(new BigDecimal("1"), queue.calculateW());
        assertEquals(new BigDecimal("19301.7440"), queue.calculateCT());
    }

    @Test
    @DisplayName("MM1Queue(100, 300, 101, 120)")
    void mm1_3() {
        AbstractQueue queue = new MM1Queue(100, 300, 101, 120);
        assertEquals(new BigDecimal("0.3333"), queue.calculateRho());
        assertEquals(new BigDecimal("0.1667"), queue.calculateLq());
        assertEquals(new BigDecimal("0.5"), queue.calculateL());
        assertEquals(new BigDecimal("0.0017"), queue.calculateWq());
        assertEquals(new BigDecimal("0.005"), queue.calculateW());
        assertEquals(new BigDecimal("121.0040"), queue.calculateCT());
    }

    @Test
    @DisplayName("MMsQueue(111, 161, 162, 50, 1)")
    void mms_1() {
        AbstractQueue queue = new MMsQueue(111, 161, 162, 50, 1);
        assertEquals(new BigDecimal("0.0090"), queue.calculateRho());
        assertEquals(new BigDecimal("0.0000"), queue.calculateLq());
        assertEquals(new BigDecimal("0.9938"), queue.calculateL());
        assertEquals(new BigDecimal("0.0000"), queue.calculateWq());
        assertEquals(new BigDecimal("0.0062"), queue.calculateW());
        assertEquals(new BigDecimal("5550.0000"), queue.calculateCT());
    }

    @Test
    @DisplayName("MMsQueue(2, 2, 3, 100, 101)")
    void mms_2() {
        AbstractQueue queue = new MMsQueue(2, 2, 3, 100, 101);
        assertEquals(new BigDecimal("0.3333"), queue.calculateRho());
        assertEquals(new BigDecimal("0.0833"), queue.calculateLq());
        assertEquals(new BigDecimal("0.7500"), queue.calculateL());
        assertEquals(new BigDecimal("0.0417"), queue.calculateWq());
        assertEquals(new BigDecimal("0.3750"), queue.calculateW());
        assertEquals(new BigDecimal("208.4133"), queue.calculateCT());
    }

    @Test
    @DisplayName("MMsKQueue(1, 3, 2, 3, 100, 100)")
    void mmsk_1() {
        AbstractQueue queue = new MMsKQueue(1, 3, 2, 3, 100, 100);
        assertEquals(new BigDecimal("0.6667"), queue.calculateRho());
        assertEquals(new BigDecimal("0.4308"), queue.calculateLq());
        assertEquals(new BigDecimal("1.0153"), queue.calculateL());
        assertEquals(new BigDecimal("0.2456"), queue.calculateWq());
        assertEquals(new BigDecimal("0.5789"), queue.calculateW());
        assertEquals(new BigDecimal("143.0800"), queue.calculateCT());
    }
}
/*
    @Test
    void mmsk_2() {
        try {
            AbstractQueue queue = new MMsKQueue(34, 2000000, 12345, 21345,
                    100, 100);
            queue.calculateL();
        } catch (ArithmeticException e) { }
    }

    @Test
    void mg1_1() {
        AbstractQueue queue = new MG1Queue(Distribution.EXPONENTIAL, 13, 14,
                0.99f, 101, 120);
        assertEquals(1165.49365234375, queue.calculateLq());
        assertEquals(1166.4222412109375, queue.calculateL());
        assertEquals(89.65335845947266, queue.calculateWq());
        assertEquals(89.72478485107422, queue.calculateW());
        assertEquals(139960.234375, queue.calculateCT());
    }

    @Test
    void mg1_2() {
        AbstractQueue queue = new MG1Queue(Distribution.EXPONENTIAL, 161, 162
                , 0, 101, 120);
        assertEquals(80.00313568115234, queue.calculateLq());
        assertEquals(80.99696350097656, queue.calculateL());
        assertEquals(0.496913880109787, queue.calculateWq());
        assertEquals(0.5030867457389832, queue.calculateW());
        assertEquals(9701.3759765625, queue.calculateCT());
    }

    @Test
    void meks_1() {
        AbstractQueue queue = new MEksQueue(1, 2, 3, 2, 2);
        assertEquals(1.3333333730697632, queue.calculateLq());
        assertEquals(2, queue.calculateL());
        assertEquals(1, queue.calculateW());
        assertEquals(0.6666666865348816, queue.calculateWq());
        assertEquals(4.6666669845581055, queue.calculateCT());
    }

    @Test
    void meks_2() {
        AbstractQueue queue = new MEksQueue(5, 25, 30, 1, 1);
        assertEquals(2.5, queue.calculateLq());
        assertEquals(3.3333332538604736, queue.calculateL());
        assertEquals(0.10000000149011612, queue.calculateWq());
        assertEquals(0.13333334028720856, queue.calculateW());
        assertEquals(3.5, queue.calculateCT());
    }
}
     */