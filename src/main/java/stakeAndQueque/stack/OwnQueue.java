package stakeAndQueque.stack;

import lombok.SneakyThrows;

import javax.management.RuntimeErrorException;

class Start {
    public static void main(String[] args) throws QueueException {
        OwnQueue<String> queue = new OwnQueue<>();
        queue.insert("hello");
        queue.insert("world");
        queue.insert("!");
        queue.insert("!");
        queue.remove();
        queue.insert("!");
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.insert("-----------------");
        System.out.println("result");
    }
}

interface Queueable<T> {
    void insert(T element) throws QueueException;
    void remove();
    T peekFront();
    boolean isFull();
    boolean isEmpty();
}

public class OwnQueue<T> implements Queueable<T> {

    private int maxSize = 5;
    private T[] storage = (T[]) new Object[maxSize];
    private int front = 0;
    private int rear = -1;
    private int nElements = 0;

    @Override
    @SneakyThrows
    public void insert(T element)  {
        if (isFull()) throw new QueueException("the queue is full");
        if (rear == maxSize - 1) rear = -1;
        nElements++;
        storage[++rear] = element;
    }

    @Override
    @SneakyThrows
    public void remove() {
        if (isEmpty()) throw new QueueException("the queue is empty");
        if (front == maxSize ) front = 0;
        nElements--;
        front++;
    }

    @Override
    public T peekFront() {
        return null;
    }

    @Override
    public boolean isFull() {
        return nElements == maxSize;
    }

    @Override
    public boolean isEmpty() {
        return nElements == 0;
    }
}

class QueueException extends Exception {
    public QueueException(String message) {
        super(message);
    }
}
