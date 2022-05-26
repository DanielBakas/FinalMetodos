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
        //MM1 1 ✅
        //MM1Queue mm1_1 = new MM1Queue(2, 3, 100, 101);
        //System.out.println(mm1_1.print());

        //MM1 2 ✅
        //AbstractQueue mm1_2 = new MM1Queue(161, 162, 101, 120);
        //System.out.println(mm1_2.print());

        //MM1 3 ✅
        //AbstractQueue mm1_3 = new MM1Queue(100, 300, 101, 120);
        //System.out.println(mm1_3.print());

        //MMs 1 ❌: Stack Overflow in Factorial (too many servers)
        //AbstractQueue mms_1 = new MMsQueue(111, 161, 162, 50, 1);
        //System.out.println(mms_1.print());

        // MMs 2 ✅
        //AbstractQueue mms_2 = new MMsQueue(2, 2, 3, 100, 101);
        //System.out.println(mms_2.print());

        // MMsK 1 ✅
        //AbstractQueue mmsk_1 = new MMsKQueue(1, 3, 2, 3, 100, 100);
        //System.out.println(mmsk_1.print());

        //MMsK 2 ❌: Stack Overflow in Factorial (too many servers)
        //AbstractQueue mmsk_2 = new MMsKQueue(34, 2000000, 12345, 21345, 299999
        //        , 299999);
        //System.out.println(mmsk_2.print());

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