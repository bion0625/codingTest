package doitStarter.ch0401;

import java.util.Arrays;

public class IntDataDeque {
    private int[] que;
    private int capacity;
    private int num;
    private int front;
    private int rear;
    DequeForward dequeForward;
    DequeReverse dequeReverse;

    public IntDataDeque(int maxlen) {
        capacity = maxlen;
        que = new int[capacity];
        num = 0;
        dequeForward = new DequeForward();
        dequeReverse = new DequeReverse();
    }

    public DequeForward getDequeForward() {
        return dequeForward;
    }

    public DequeReverse getDequeReverse() {
        return dequeReverse;
    }

    public void clear() {
        num = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }
    public boolean isFull() {
        return num >= capacity;
    }

    public class EmptyIntDueueException extends RuntimeException {
        public EmptyIntDueueException() { }
    }

    public class OverflowIntDueueException extends RuntimeException {
        public OverflowIntDueueException() { }
    }

    interface BaseDeque {
        public int enque(int x);
        public int deque();
        public int peek();
        public void clear();
        public int indexOf(int x);
        public int getCapacity();
        public int size();
        public boolean isEmpty();
        public boolean isFull();
        public void dump();
    }

    class DequeForward implements BaseDeque {
        @Override
        public int enque(int x) throws OverflowIntDueueException {
            if (num >= capacity)
                throw new OverflowIntDueueException();
            que[rear++] = x;
            num++;
            if (rear == capacity)
                rear = 0;
            return x;
        }

        @Override
        public int deque() throws EmptyIntDueueException {
            if (num <= 0) throw new EmptyIntDueueException();
            int x = que[front++];
            num--;
            if (front == capacity) front = 0;
            return x;
        }

        @Override
        public int peek() {
            if (num <= 0) throw new EmptyIntDueueException();
            return que[front];
        }

        @Override
        public void clear() {
            front = rear = 0;
            IntDataDeque.this.clear();
        }

        @Override
        public int indexOf(int x) {
            for (int i = 0; i < num; i++) {
                int idx = (i + front) % capacity;
                if (que[idx] == x) return i;
            }
            return -1;
        }

        @Override
        public int getCapacity() {
            return IntDataDeque.this.getCapacity();
        }

        @Override
        public int size() {
            return IntDataDeque.this.size();
        }

        @Override
        public boolean isEmpty() {
            return IntDataDeque.this.isEmpty();
        }

        @Override
        public boolean isFull() {
            return IntDataDeque.this.isFull();
        }

        @Override
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

    class DequeReverse implements BaseDeque {
        @Override
        public int enque(int x) {
            if (num >= capacity)
                throw new OverflowIntDueueException();
            if (front == 0) front = capacity - 1;
            else front--;
            que[front] = x;
            num++;
            return x;
        }

        @Override
        public int deque() {
            if (num <= 0) throw new EmptyIntDueueException();
            if (rear == 0) rear = capacity;
            int x = que[rear--];
            num--;
            return x;
        }

        @Override
        public int peek() {
            if (num <= 0) throw new EmptyIntDueueException();
            if (rear == 0) rear = capacity;
            return que[rear - 1];
        }

        @Override
        public void clear() {
            front = rear = 0;
            IntDataDeque.this.clear();
        }

        @Override
        public int indexOf(int x) {
            for (int i = num - 1; i >= 0; i--) {
                int idx = (i + front) % capacity;
                if (que[idx] == x) return num - i - 1;
            }
            return -1;
        }

        @Override
        public int getCapacity() {
            return IntDataDeque.this.getCapacity();
        }

        @Override
        public int size() {
            return IntDataDeque.this.size();
        }

        @Override
        public boolean isEmpty() {
            return IntDataDeque.this.isEmpty();
        }

        @Override
        public boolean isFull() {
            return IntDataDeque.this.isFull();
        }

        @Override
        public void dump() {
            if (num <= 0)
                System.out.println("큐가 비어 있습니다.");
            else {
                for (int i = num - 1; i >= 0; i--)
                    System.out.print(que[(i + front) % capacity] + " ");
                System.out.println();
            }
        }
    }

//    void printFrontAndRear(String methodName) { // todo del
//        System.out.println("\t[" +methodName + "] front: " + front + " | rear: " + rear);
//    }
}
