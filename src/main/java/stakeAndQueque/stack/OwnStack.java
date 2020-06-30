package stakeAndQueque.stack;

import lombok.Data;
import lombok.NoArgsConstructor;

class Run {
    public static void main(String[] args) {
        Stackable<String> stack = new OwnStack<>();
        stack.push("hello");
        stack.push("world");
        stack.push("!");

        String pop = stack.pop();
        stack.push("finish");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push("-----------------");
        System.out.println("finish");
    }
}

interface Stackable<T> {
    boolean isEmpty();

    int maxSize();

    T pop();

    T push(T element);

    T peek();

    boolean isFull();
}

@Data
@NoArgsConstructor
public class OwnStack<A> implements Stackable<A> {

    private int maxSize = 10;
    private int top = -1;
    A[] storage = (A[]) new Object[maxSize];

    public OwnStack(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int maxSize() {
        return maxSize;
    }

    @Override
    public A pop() {
        return (A) storage[top--];
    }

    @Override
    public A push(A element) {
        top++;
        storage[top] = element;
        return element;
    }

    @Override
    public A peek() {
        return storage[top];
    }

    @Override
    public boolean isFull() {
        return top == (maxSize - 1);
    }
}


