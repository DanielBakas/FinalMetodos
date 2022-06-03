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

import com.mms.util.MathUtils;
import com.mms.util.Util.Distribution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueuesTests {
    private final float delta = MathUtils.decimalLimit;
    private Distribution B;
    private int s, K, lambda, mu, cs, cw;

    @Test
    @DisplayName("MM1Queue(2, 3, 100, 100)")
    void mm1_1() {
        B = Distribution.EXPONENTIAL;
        s = 1;
        K = MathUtils.infinity;
        lambda = 2;
        mu = 3;
        cs = 100;
        cw = 100;
        Queue queue = QueueFactory.create(B, s, K, lambda, mu, cs, cw);
        assertEquals(0.6666f, queue.calculateRho(), delta);
        assertEquals(1.3333f, queue.calculateLq(), delta);
        assertEquals(2, queue.calculateL(), delta);
        assertEquals(0.6666f, queue.calculateWq(), delta);
        assertEquals(1, queue.calculateW(), delta);
        assertEquals(233.3333f, queue.calculateCT(), delta);
    }

    @Test
    @DisplayName("MM1Queue(161, 162, 101, 120)")
    void mm1_2() {
        B = Distribution.EXPONENTIAL;
        s = 1;
        K = MathUtils.infinity;
        lambda = 161;
        mu = 162;
        cs = 101;
        cw = 120;
        Queue queue = QueueFactory.create(B, s, K, lambda, mu, cs, cw);
        assertEquals(0.9938f, queue.calculateRho(), delta);
        assertEquals(160.0062f, queue.calculateLq(), delta);
        assertEquals(161, queue.calculateL(), delta);
        assertEquals(0.9938f, queue.calculateWq(), delta);
        assertEquals(1, queue.calculateW(), delta);
        assertEquals(19301.742f, queue.calculateCT(), delta);
    }

    @Test
    @DisplayName("MM1Queue(100, 300, 101, 120)")
    void mm1_3() {
        B = Distribution.EXPONENTIAL;
        s = 1;
        K = MathUtils.infinity;
        lambda = 100;
        mu = 300;
        cs = 101;
        cw = 120;
        Queue queue = QueueFactory.create(B, s, K, lambda, mu, cs, cw);
        assertEquals(0.3333f, queue.calculateRho(), delta);
        assertEquals(0.1666f, queue.calculateLq(), delta);
        assertEquals(0.5f, queue.calculateL(), delta);
        assertEquals(0.0017f, queue.calculateWq(), delta);
        assertEquals(0.005f, queue.calculateW(), delta);
        assertEquals(121, queue.calculateCT(), delta);
    }

    @Test
    @DisplayName("MMsQueue(111, 161, 162, 50, 1)")
    void mms_1() {
        B = Distribution.EXPONENTIAL;
        s = 111;
        K = MathUtils.infinity;
        lambda = 161;
        mu = 162;
        cs = 50;
        cw = 1;
        Queue queue = QueueFactory.create(B, s, K, lambda, mu, cs, cw);
        assertEquals(0.009f, queue.calculateRho(), delta);
        assertEquals(0, queue.calculateLq(), delta);
        assertEquals(0.9938f, queue.calculateL(), delta);
        assertEquals(0, queue.calculateWq(), delta);
        assertEquals(0.0061f, queue.calculateW(), delta);
        assertEquals(5550, queue.calculateCT(), delta);
    }

    @Test
    @DisplayName("MMsQueue(2, 2, 3, 100, 101)")
    void mms_2() {
        B = Distribution.EXPONENTIAL;
        s = 2;
        K = MathUtils.infinity;
        lambda = 2;
        mu = 3;
        cs = 100;
        cw = 101;
        Queue queue = QueueFactory.create(B, s, K, lambda, mu, cs, cw);
        assertEquals(0.3333f, queue.calculateRho(), delta);
        assertEquals(0.0833f, queue.calculateLq(), delta);
        assertEquals(0.75f, queue.calculateL(), delta);
        assertEquals(0.0417f, queue.calculateWq(), delta);
        assertEquals(0.375f, queue.calculateW(), delta);
        assertEquals(208.4167f, queue.calculateCT(), delta);
    }

    @Test
    @DisplayName("MMsKQueue(1, 3, 2, 3, 100, 100)")
    void mmsk_1() {
        B = Distribution.EXPONENTIAL;
        s = 1;
        K = 3;
        lambda = 2;
        mu = 3;
        cs = 100;
        cw = 100;
        Queue queue = QueueFactory.create(B, s, K, lambda, mu, cs, cw);
        assertEquals(0.6666f, queue.calculateRho(), delta);
        assertEquals(0.4308f, queue.calculateLq(), delta);
        assertEquals(1.0154f, queue.calculateL(), delta);
        assertEquals(0.2456f, queue.calculateWq(), delta);
        assertEquals(0.5789f, queue.calculateW(), delta);
        assertEquals(143.0769f, queue.calculateCT(), delta);
    }
}