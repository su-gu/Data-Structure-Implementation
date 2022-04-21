
import java.util.EmptyStackException;

class Node {
    int data;
    Node next;
}

class Stack {
    Node top;

    public Stack() {
        this.top = null;
    }

    public int push(int element) {
        Node node = new Node();
        node.data = element;
        node.next = top;
        top = node;
        return (element);
    }

    public int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int element = top.data;
        top = top.next;
        return (element);
    }

    public int peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (top.data);
    }

    public boolean isEmpty() {
        return top == null;
    }
}