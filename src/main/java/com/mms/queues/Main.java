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
        //MM1 | Nosotros 1 ✅
        //MM1Queue nosotros1 = new MM1Queue(2, 3, 0, 0);
        //System.out.println(nosotros1.print());

        //MM1 | Eric 1 ✅
        //AbstractQueue eric1 = new MM1Queue(161, 162, 101, 120);
        //System.out.println(eric1.print());

        //MM1 | Eric 2 ✅
        //AbstractQueue eric2 = new MM1Queue(100, 300, 101, 120);
        //System.out.println(eric2.print());

        //MMs | Eric 3 ❌: Stack Overflow in Factorial (too many servers)
        //AbstractQueue eric3 = new MMsQueue(111, 161, 162, 50, 1);
        //System.out.println(eric3.print());

        // MMs | Nosotros 2 ✅
        //AbstractQueue nosotros2 = new MMsQueue(2, 2, 3, 0, 0);
        //System.out.println(nosotros2.print());

        // MMsK | Nosotros 3 ✅
        //AbstractQueue nosotros3 = new MMsKQueue(1, 3, 2, 3, 0, 0);
        //System.out.println(nosotros3.print());

        //MMs | Eric 4 ❌: Stack Overflow in Factorial (too many servers)
        //AbstractQueue eric4 = new MMsKQueue(34, 2000000, 12345, 21345, 299999
        //        , 299999);
        //System.out.println(eric4.print());

        // MG1 | Eric 4 ✅
        //AbstractQueue eric4 = new MG1Queue(Distribution.EXPONENTIAL, 13, 14,
        //        0.99f, 101, 120);
        //System.out.println(eric4.print());

        // MG1 | Eric 5 ✅
        //AbstractQueue eric5 = new MG1Queue(Distribution.EXPONENTIAL, 161, 162
        //        , 0, 101, 120);
        //System.out.println(eric5.print());

        // MEks | Eric 6 ✅
        //AbstractQueue eric6 = new MEksQueue(Distribution.EXPONENTIAL, 1, 2, 3
        //        , 2, 2);
        //System.out.println(eric6.print());

        // MEks | Eric 7 ✅
        //AbstractQueue eric7 = new MEksQueue(Distribution.EXPONENTIAL, 5, 25,
        //        30, 1, 1);
        //System.out.println(eric7.print());
    }
}