package com.mms.queues;/*
================================================================================
# Final Project
Module | `queues.Main.java`

Authors\

May 12, 2022
================================================================================
*/

public class Main {
    public static void main(String[] args) {
        try {
            MMSKQueue queue = new MMSKQueue(Distribution.Exponential, 3, 2, 3, 1, 0);
            System.out.println(queue.print());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
