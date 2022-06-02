package com.mms.queues;

/**
 * =============================================================================
 * # Final Project
 *
 * Module | `Main.java`
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
import com.mms.util.Util.Distribution;

public class Main {
    public static void main(String[] args) {
        Distribution B;
        int s, K, lambda, mu;
        float cs, cw;
        B = Distribution.EXPONENTIAL;
        s = 3;
        K = Util.infinity;
        lambda = 60;
        mu = 24;
        cs = 20;
        cw = 48;
        Queue queue = QueueFactory.create(B, s, K, lambda, mu, cs, cw);
        System.out.println(queue);
    }
}