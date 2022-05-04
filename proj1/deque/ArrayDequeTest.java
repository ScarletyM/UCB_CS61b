package deque;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {


        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {


        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create ArrayDeques with different parameterized types*/
    public void multipleParamTest() {


        ArrayDeque<String>  lld1 = new ArrayDeque<String>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {


        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }


    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        /*
        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }
         */

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }

    @Test
    public void maxArrayDequeTest() {

        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<Integer>((o1, o2) -> {
            return ((int) o1 - (int) o2);
        });
        lld1.addLast(10);
        lld1.addLast(1);
        lld1.addLast(-7);
        lld1.addLast(132);
        lld1.addFirst(132);
        lld1.addFirst(3);
        lld1.addFirst(45);
        lld1.addFirst(95);
        lld1.addFirst(38);

        lld1.printDeque();
        assertEquals("Should have the same value", 132, lld1.max(), 0.0);


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void equalTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> lld2 = new ArrayDeque<Integer>();
        for (int i = 0; i < 100000; i++) {
            lld1.addLast(i);
            lld2.addLast(i);
        }

        boolean result = lld1.equals(lld2);

        assertEquals("Should be true", true, result);


    }

    @Test
    public void testIterator() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            lld1.addLast(i);
        }

        for (int i : lld1) {
            System.out.println(i);
        }
    }

    @Test
    public void testGet() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        lld1.addFirst(0);
        lld1.removeLast();
        lld1.isEmpty();
        lld1.addFirst(3);
        lld1.removeLast();

        /*
        for (int i = 0; i < 10; i++) {
            lld1.addFirst(i);
        }

        assertEquals("Should be true", 6, lld1.get(3),0.0);
        assertEquals("Should be true", 4, lld1.get(5),0.0);

         */
    }

}
