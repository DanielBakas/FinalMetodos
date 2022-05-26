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

public class Main {
    public static void main(String[] args) {
        try {
            MMSKQueue queue = new MMSKQueue(20, 10, 3, 2, 3, 1);
            System.out.println(queue.print());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}