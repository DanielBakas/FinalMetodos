package com.mms.queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MMSKQueueTest {
    private MMSKQueue mmskQueue;

    @Test
    void mmskTest() {
        try {
            mmskQueue = new MMSKQueue(15, 12, 3, 2, 3, 1);
            assertEquals(0.24561402201652527, mmskQueue.getWq());
            assertEquals(0.5789473652839661, mmskQueue.getW());
            assertEquals(0.4307692050933838, mmskQueue.getLq());
            assertEquals(1.0153846740722656, mmskQueue.getL());
            assertEquals(18.461538314819336, mmskQueue.getC());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void mm1() {
        try {
            mmskQueue = new MM1Queue(120, 101, 161, 162);
            assertEquals(19301.74, mmskQueue.getC());
            assertEquals(161, mmskQueue.getL());
            assertEquals(160.00617, mmskQueue.getLq());
            assertEquals(1, mmskQueue.getW());
            assertEquals(0.993827, mmskQueue.getWq());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void mms() {
        try {
            mmskQueue = new MMsQueue(1, 50, 161, 162, 111);
            assertEquals(5550, mmskQueue.getC());
            assertEquals(0.5783674387227344, mmskQueue.getL());
            assertEquals(6.739407832675313e-2, mmskQueue.getLq());
            assertEquals(0.000004684806236414062, mmskQueue.getW());
            assertEquals(5.458955281780807e-215, mmskQueue.getWq());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void mg1() {
        try {
            MG1Queue mg1Queue = new MG1Queue(Distribution.LOGNORMAL, 13f, 14f, 0.99f, 101f, 120f);
            assertEquals(139960.28171428578, mg1Queue.getC());
            assertEquals(1166.4225857142862, mg1Queue.getL());
            assertEquals(1165.494014285715, mg1Queue.getLq());
            assertEquals(89.72481428571433, mg1Queue.getW());
            assertEquals(89.65338571428576, mg1Queue.getWq());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void md1() {
        try {
            MD1Queue queue = new MD1Queue(2f, 3f, 1f, 1f);
            assertEquals(1.08333, queue.getC());
            assertEquals(0.75, queue.getL());
            assertEquals(0.08333, queue.getLq());
            assertEquals(0.375, queue.getW());
            assertEquals(0.0416666, queue.getWq());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void me1() {
        try {
            ME1Queue queue = new ME1Queue(2f, 3f, 1f, 2f, 2f);
            assertEquals(2, queue.getL());
            assertEquals(1.33333, queue.getLq());
            assertEquals(1, queue.getW());
            assertEquals(0.6666, queue.getWq());
            assertEquals(4.6666, queue.getC());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}