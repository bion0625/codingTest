package doitStarter.ch0401;

public class Stack<E>  {
    private E[] stk;      // 스택용 배열
    private int capacity;   // 스택 용량
    private int ptr;        // 스택 포인터

    // 실행 시 예외: 스택이 비어 있음
    public static class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    // 실행 시 예외: 스택이 가득 참
    public static class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    public Stack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = (E[]) new Object[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public E push(E x) throws OverflowIntStackException {
        if (ptr >= capacity) throw new OverflowIntStackException();
        return this.stk[ptr++] = x;
    }

    public E pop() throws EmptyIntStackException {
        if (ptr <= 0) throw new EmptyIntStackException();
        return this.stk[--ptr];
    }

    public E peek() throws EmptyIntStackException {
        if (ptr <= 0) throw new EmptyIntStackException();
        return this.stk[ptr-1];
    }

    public void clear() {
        ptr = 0;
    }

    public int indexOf(E x) {
        for (int i = ptr - 1; i >= 0; i--) {
            if (stk[i].equals(x)) return i;
        }
        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= capacity;
    }

    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}
