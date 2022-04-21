import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.EmptyStackException;

public class TestStack {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack();
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(stack.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void throwsExceptionWhenPopped() {
        stack.pop();
    }

    @Test
    public void testPush() {
        Assert.assertEquals("Inserted 1", 1, stack.push(1));
        Assert.assertEquals("Inserted 2", 2, stack.push(2));
    }

    @Test
    public void testPeek() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Assert.assertEquals("Peeking 4", 4, stack.peek());
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Assert.assertEquals("popping 4", 4, stack.pop());
        Assert.assertEquals("popping 3", 3, stack.pop());
        Assert.assertEquals("popping 2", 2, stack.pop());
        Assert.assertEquals("popping 1", 1, stack.pop());
        thrown.expect(EmptyStackException.class);
        stack.pop();
    }

    @Test
    public void testIsEmpty() {
        stack.push(1);
        stack.push(2);
        Assert.assertFalse(stack.isEmpty());
        stack.pop();
        Assert.assertFalse(stack.isEmpty());
        stack.pop();
        Assert.assertTrue(stack.isEmpty());
    }
}