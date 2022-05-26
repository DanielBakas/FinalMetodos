package com.mms.queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueuesTests {
    @Test
    void mm1_1() {
        AbstractQueue queue = new MM1Queue(2, 3, 100, 101);
        assertEquals(1.3333334922790527, queue.calculateLq());
        assertEquals(2.0, queue.calculateL());
        assertEquals(0.6666667461395264, queue.calculateWq());
        assertEquals(1.0000001192092896, queue.calculateW());
        assertEquals(234.66668701171875, queue.calculateC());
    }

    @Test
    void mm1_2() {
        AbstractQueue queue = new MM1Queue(161, 162, 101, 120);
        assertEquals(161, queue.calculateL());
        assertEquals(160.0062713623047, queue.calculateLq());
        assertEquals(1.0000005960464478, queue.calculateW());
        assertEquals(0.993827760219574, queue.calculateWq());
        assertEquals(19301.751953125, queue.calculateC());
    }

    @Test
    void mm1_3() {
        AbstractQueue queue = new MM1Queue(100, 300, 101, 120);
        assertEquals(0.5, queue.calculateL());
        assertEquals(0.1666666865348816, queue.calculateLq());
        assertEquals(0.005000000353902578, queue.calculateW());
        assertEquals(0.0016666668234393, queue.calculateWq());
        assertEquals(121.0, queue.calculateC());
    }

    @Test
    void mms_1() {
        try {
            AbstractQueue queue = new MMsQueue(111, 161, 162, 50, 1);
            queue.calculateL();
        } catch (ArithmeticException e) { }
    }

    @Test
    void mms_2() {
        AbstractQueue queue = new MMsQueue(2, 2, 3, 100, 101);
        assertEquals(0.08333335071802139, queue.calculateLq());
        assertEquals(0.7500000596046448, queue.calculateL());
        assertEquals(0.041666675359010696, queue.calculateWq());
        assertEquals(0.3750000298023224, queue.calculateW());
        assertEquals(208.4166717529297, queue.calculateC());
    }

    @Test
    void mmsk_1() {
        AbstractQueue queue = new MMsKQueue(1, 3, 2, 3, 100, 101);
        assertEquals(0.4307692050933838, queue.calculateLq());
        assertEquals(1.0153846740722656, queue.calculateL());
        assertEquals(0.24561402201652527, queue.calculateWq());
        assertEquals(0.5789473652839661, queue.calculateW());
        assertEquals(143.5076904296875, queue.calculateC());
    }

    @Test
    void mmsk_2() {
        try {
            AbstractQueue queue = new MMsKQueue(34, 2000000, 12345, 21345,
                    100, 100);
            queue.calculateL();
        } catch (ArithmeticException e) { }
    }

    @Test
    void mg1_1() {
        AbstractQueue queue = new MG1Queue(Distribution.EXPONENTIAL, 13, 14,
                0.99f, 101, 120);
        assertEquals(1165.49365234375, queue.calculateLq());
        assertEquals(1166.4222412109375, queue.calculateL());
        assertEquals(89.65335845947266, queue.calculateWq());
        assertEquals(89.72478485107422, queue.calculateW());
        assertEquals(139960.234375, queue.calculateC());
    }

    @Test
    void mg1_2() {
        AbstractQueue queue = new MG1Queue(Distribution.EXPONENTIAL, 161, 162
                , 0, 101, 120);
        assertEquals(80.00313568115234, queue.calculateLq());
        assertEquals(80.99696350097656, queue.calculateL());
        assertEquals(0.496913880109787, queue.calculateWq());
        assertEquals(0.5030867457389832, queue.calculateW());
        assertEquals(9701.3759765625, queue.calculateC());
    }

    @Test
    void meks_1() {
        AbstractQueue queue = new MEksQueue(1, 2, 3, 2, 2);
        assertEquals(1.3333333730697632, queue.calculateLq());
        assertEquals(2, queue.calculateL());
        assertEquals(1, queue.calculateW());
        assertEquals(0.6666666865348816, queue.calculateWq());
        assertEquals(4.6666669845581055, queue.calculateC());
    }

    @Test
    void meks_2() {
        AbstractQueue queue = new MEksQueue(5, 25, 30, 1, 1);
        assertEquals(2.5, queue.calculateLq());
        assertEquals(3.3333332538604736, queue.calculateL());
        assertEquals(0.10000000149011612, queue.calculateWq());
        assertEquals(0.13333334028720856, queue.calculateW());
        assertEquals(3.5, queue.calculateC());
    }
}