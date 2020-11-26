package de.hfu;
import org.junit.Test;
import de.hfu.Util;
import de.hfu.Queue;

import static org.junit.Assert.*;

public class QueueAndUtilTest {

    @Test
    public void queue() {
        Queue queue = new Queue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(queue.dequeue(),1);
        assertEquals(queue.dequeue(),2);
        assertEquals(queue.dequeue(),3);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals(queue.dequeue(),1);
        assertEquals(queue.dequeue(),2);
        assertEquals(queue.dequeue(),4);


    }



    @Test
    public void istErstesHalbjahr() {

        assertTrue( Util.istErstesHalbjahr(1));
        assertTrue( Util.istErstesHalbjahr(2));
        assertTrue( Util.istErstesHalbjahr(3));
        assertTrue( Util.istErstesHalbjahr(4));
        assertTrue( Util.istErstesHalbjahr(5));
        assertTrue( Util.istErstesHalbjahr(6));
        assertFalse( Util.istErstesHalbjahr(7));
        assertFalse( Util.istErstesHalbjahr(8));
        assertFalse( Util.istErstesHalbjahr(9));
        assertFalse( Util.istErstesHalbjahr(10));
        assertFalse( Util.istErstesHalbjahr(11));
        assertFalse( Util.istErstesHalbjahr(12));

    }
}






