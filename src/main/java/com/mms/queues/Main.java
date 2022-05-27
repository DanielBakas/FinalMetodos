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
        //MMsK 2
        AbstractQueue mmsk_2 = new MMsKQueue(34, 2000000, 12345, 21345, 299999,
                299999);
        System.out.println(mmsk_2);

        // MG1 1 ✅
        //AbstractQueue mg1_1 = new MG1Queue(Distribution.EXPONENTIAL, 13, 14,
        //        0.99f, 101, 120);
        //System.out.println(mg1_1.print());

        // MG1 2 ✅
        //AbstractQueue mg1_2 = new MG1Queue(Distribution.EXPONENTIAL, 161, 162
        //        , 0, 101, 120);
        //System.out.println(mg1_2.print());

        // MEks 1 ✅
        //AbstractQueue meks_1 = new MEksQueue(1, 2, 3, 2, 2);
        //System.out.println(meks_1.print());

        // MEks 2 ✅
        //AbstractQueue meks_2 = new MEksQueue(5, 25, 30, 1, 1);
        //System.out.println(meks_2.print());
    }
}