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

import com.mms.util.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueuesTests {
    private Util.Distribution B;
    private long K;
    private int s, lambda, mu, cs, cw;

    @Test
    @DisplayName("MM1Queue(2, 3, 100, 100)")
    void mm1_1() {
        B = Util.Distribution.EXPONENTIAL;
        s = 1;
        K = Util.infinity.longValue();
        lambda = 2;
        mu = 3;
        cs = 100;
        cw = 100;
        Queue queue = QueueFactory.create(B, s, K, lambda, mu, cs, cw);
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
        B = Util.Distribution.EXPONENTIAL;
        s = 1;
        K = Util.infinity.longValue();
        lambda = 161;
        mu = 162;
        cs = 101;
        cw = 120;
        Queue queue = QueueFactory.create(B, s, K, lambda, mu, cs, cw);
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
        B = Util.Distribution.EXPONENTIAL;
        s = 1;
        K = Util.infinity.longValue();
        lambda = 100;
        mu = 300;
        cs = 101;
        cw = 120;
        Queue queue = QueueFactory.create(B, s, K, lambda, mu, cs, cw);
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
        B = Util.Distribution.EXPONENTIAL;
        s = 111;
        K = Util.infinity.longValue();
        lambda = 161;
        mu = 162;
        cs = 50;
        cw = 1;
        Queue queue = QueueFactory.create(B, s, K, lambda, mu, cs, cw);
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
        B = Util.Distribution.EXPONENTIAL;
        s = 2;
        K = Util.infinity.longValue();
        lambda = 2;
        mu = 3;
        cs = 100;
        cw = 101;
        Queue queue = QueueFactory.create(B, s, K, lambda, mu, cs, cw);
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
        B = Util.Distribution.EXPONENTIAL;
        s = 1;
        K = 3;
        lambda = 2;
        mu = 3;
        cs = 100;
        cw = 100;
        Queue queue = QueueFactory.create(B, s, K, lambda, mu, cs, cw);
        assertEquals(new BigDecimal("0.6667"), queue.calculateRho());
        assertEquals(new BigDecimal("0.4308"), queue.calculateLq());
        assertEquals(new BigDecimal("1.0153"), queue.calculateL());
        assertEquals(new BigDecimal("0.2456"), queue.calculateWq());
        assertEquals(new BigDecimal("0.5789"), queue.calculateW());
        assertEquals(new BigDecimal("143.0800"), queue.calculateCT());
    }
}