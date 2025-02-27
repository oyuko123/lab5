package edu.cmu.cs.cs214.rec02;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IntQueueTest {

    private IntQueue mQueue;
    private List<Integer> testList;

    @Before
    public void setUp() {
        mQueue = new ArrayIntQueue(); 

        testList = new ArrayList<>(List.of(1, 2, 3));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(mQueue.isEmpty());
    }

    @Test
    public void testNotEmpty() {
        mQueue.enqueue(5);
        //assertFalse(mQueue.isEmpty());
        assertTrue(mQueue.isEmpty());
    }

    @Test
    public void testPeekEmptyQueue() {
        assertNull(mQueue.peek());
    }

    @Test
    public void testPeekNonEmptyQueue() {
        mQueue.enqueue(7);
        assertEquals(Integer.valueOf(7), mQueue.peek());
    }

    @Test
    public void testEnqueue() {
        for (int i = 0; i < testList.size(); i++) {
            mQueue.enqueue(testList.get(i));
            assertEquals(testList.get(0), mQueue.peek());
            assertEquals(i + 1, mQueue.size());
        }
    }

    @Test
    public void testDequeue() {
        mQueue.enqueue(10);
        mQueue.enqueue(20);
        assertEquals(Integer.valueOf(10), mQueue.dequeue());
        assertEquals(Integer.valueOf(20), mQueue.dequeue());
        assertNull(mQueue.dequeue()); 
    }

    @Test
    public void testDequeueUntilEmpty() {
        for (int num : testList) {
            mQueue.enqueue(num);
        }
        for (int num : testList) {
            assertEquals(Integer.valueOf(num), mQueue.dequeue());
        }
        assertTrue(mQueue.isEmpty());
    }

    @Test
    public void testSizeAfterOperations() {
        assertEquals(0, mQueue.size());
        mQueue.enqueue(100);
        assertEquals(1, mQueue.size());
        mQueue.enqueue(200);
        assertEquals(2, mQueue.size());
        mQueue.dequeue();
        assertEquals(1, mQueue.size());
        mQueue.clear();
        assertEquals(0, mQueue.size());
    }

    @Test
    public void testEnsureCapacityWorks() {
        for (int i = 0; i < 15; i++) { 
            mQueue.enqueue(i);
        }
        assertEquals(Integer.valueOf(0), mQueue.peek());
        for (int i = 0; i < 15; i++) {
            assertEquals(Integer.valueOf(i), mQueue.dequeue());
        }
        assertTrue(mQueue.isEmpty());
    }

    @Test
    public void testClear() {
        mQueue.enqueue(42);
        mQueue.enqueue(84);
        assertFalse(mQueue.isEmpty());
        mQueue.clear();
        assertTrue(mQueue.isEmpty());
        assertNull(mQueue.peek());
    }
}
