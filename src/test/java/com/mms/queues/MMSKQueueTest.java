package com.mms.queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MMSKQueueTest {
    private MMSKQueue mmskQueue;

    // GROUND TRUTH
    @Test
    void mmskTest() {
        try {
            mmskQueue = new MMSKQueue(15, 12, Distribution.EXPONENTIAL, 3, 2, 3, 1, 0);
            assertEquals(0.24561402201652527, mmskQueue.getWq());
            assertEquals(0.5789473652839661, mmskQueue.getW());
            assertEquals(0.4307692050933838, mmskQueue.getLq());
            assertEquals(1.0153846740722656, mmskQueue.getL());
            assertEquals(18.461538314819336, mmskQueue.getC());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //    @Test
    void mm1() {
        try {
            mmskQueue = new MMSKQueue(120, 101, Distribution.EXPONENTIAL, Integer.MAX_VALUE, 161, 162, 1, 0);
            assertEquals(19301.74, mmskQueue.getC());
            assertEquals(161, mmskQueue.getL());
            assertEquals(160.00617, mmskQueue.getLq());
            assertEquals(1, mmskQueue.getW());
            assertEquals(0.993827, mmskQueue.getWq());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //    @Test
    void mms() {
        try {
            mmskQueue = new MMSKQueue(1, 50, Distribution.EXPONENTIAL, Integer.MAX_VALUE, 100, 300, 111, 0);
            assertEquals(5550, mmskQueue.getC());
            assertEquals(0.5783674387227344, mmskQueue.getL());
            assertEquals(6.739407832675313e-2, mmskQueue.getLq());
            assertEquals(0.000004684806236414062, mmskQueue.getW());
            assertEquals(5.458955281780807e-215, mmskQueue.getWq());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //    @Test
    void mg1() {
        try {
            mmskQueue = new MMSKQueue(120, 101, Distribution.LOGNORMAL, Integer.MAX_VALUE, 13, 14, 1, 0.99f);
            assertEquals(139960.28171428578, mmskQueue.getC());
            assertEquals(1166.4225857142862, mmskQueue.getL());
            assertEquals(1165.494014285715, mmskQueue.getL());
            assertEquals(89.72481428571433, mmskQueue.getW());
            assertEquals(89.65338571428576, mmskQueue.getWq());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}