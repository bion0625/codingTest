package doitStarter.ch0401;

public class Queue<E> {
    private E[] que;
    private int capacity;
    private int front;
    private int rear;
    private int num;

    public static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException() { }
    }

    public static class OverflowQueueException extends RuntimeException {
        public OverflowQueueException() { }
    }

    public Queue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        try {
            que = (E[]) new Object[maxlen];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public E enque(E x) throws OverflowQueueException {
        if (num >= capacity)
            throw new OverflowQueueException();
        que[rear++] = x;
        num++;
        if (rear == capacity)
            rear = 0;
        return x;
    }

    public E deque() throws EmptyQueueException {
        if (num <= 0) throw new EmptyQueueException();
        E x = que[front++];
        num--;
        if (front == capacity) front = 0;
        return x;
    }

    public E peek() throws EmptyQueueException {
        if (num <= 0) throw new EmptyQueueException();
        return que[front];
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int indexOf(E x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % capacity;
            if (que[idx] == x) return i;
        }
        return -1;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int size() {
        return this.num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= capacity;
    }

    public void dump() {
        if (num <= 0)
            System.out.println("큐가 비어 있습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[(i + front) % capacity] + " ");
            System.out.println();
        }
    }
}
