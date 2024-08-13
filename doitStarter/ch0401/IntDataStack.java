package doitStarter.ch0401;

public class IntDataStack {
    private int[] stk;
    private int capacity;
    private int ptr;
    private DataStack dataStack;
    private ReverseStack reverseStack;

    public IntDataStack(int maxlen) {
        ptr = 0;
        this.dataStack = new DataStack();
        this.reverseStack = new ReverseStack();

        capacity = maxlen;
        try {
            stk = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public DataStack getDataStack() {
        return this.dataStack;
    }

    public ReverseStack getReverseStack() {
        return this.reverseStack;
    }

    public abstract class BaseStack {
        abstract int push(int x);
        abstract int pop();
        abstract int peek();
        abstract int indexOf(int x);
        abstract void dump();

        public void clear() {
            IntDataStack.this.clear();
        }

        public int getCapacity() {
            return IntDataStack.this.capacity;
        }

        public int size() {
            return IntDataStack.this.size();
        }

        public boolean isEmpty() {
            return IntDataStack.this.isEmpty();
        }

        public boolean isFull() {
            return IntDataStack.this.isFull();
        }
    }

    // 실행 시 예외: 스택이 비어 있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    // 실행 시 예외: 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    public void clear() {
        ptr = 0;
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

    class DataStack extends BaseStack {
        @Override
        public int push(int x) throws OverflowIntStackException {
            if (ptr >= capacity) throw new OverflowIntStackException();
            return stk[ptr++] = x;
        }

        @Override
        public int pop() throws EmptyIntStackException {
            if (ptr <= 0) throw new EmptyIntStackException();
            return stk[--ptr];
        }

        @Override
        public int peek() throws EmptyIntStackException {
            if (ptr <= 0) throw new EmptyIntStackException();
            return stk[ptr-1];
        }

        @Override
        public int indexOf(int x) {
            for (int i = ptr - 1; i >= 0; i--) {
                if (stk[i] == x) return i;
            }
            return -1;
        }

        @Override
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
    class ReverseStack extends BaseStack {
        @Override
        public int push(int x) throws OverflowIntStackException {
            if (ptr >= capacity) throw new OverflowIntStackException();
            ptr++;
            for (int i = ptr - 1; i > 0; i--) {
                stk[i] = stk[i-1];
            }
            return stk[0] = x;
        }

        @Override
        public int pop() throws EmptyIntStackException {
            if (ptr <= 0) throw new EmptyIntStackException();
            int pop = stk[0];
            for (int i = 0; i < ptr; i++) {
                stk[i] = stk[i+1];
            }
            --ptr;
            return pop;
        }

        @Override
        public int peek() throws EmptyIntStackException {
            if (ptr <= 0) throw new EmptyIntStackException();
            return stk[0];
        }

        @Override
        public int indexOf(int x) {
            for (int i = 0; i <= ptr - 1; i++) {
                if (stk[i] == x) return ptr - i - 1;
            }
            return -1;
        }

        @Override
        public void dump() {
            if (ptr <= 0)
                System.out.println("스택이 비어 있습니다.");
            else {
                for (int i = ptr - 1; i >= 0; i--)
                    System.out.print(stk[i] + " ");
                System.out.println();
            }
        }
    }
}
