package doitStarter.ch0401;

public class IntArrayQueue {
    private int[] que;
    private int capacity;
    private int num;

    public class OverflowIntStackException extends RuntimeException {
        OverflowIntStackException() { }
    }

    public class EmptyIntStackException extends RuntimeException {
        EmptyIntStackException() { }
    }

    public IntArrayQueue(int maxum) {
        this.capacity = maxum;
        que = new int[this.capacity];
        num = 0;
    }

    public int enque(int x) {
        return this.que[this.num++] = x;
    }
    public int deque() {
        if (num <= 0) throw new EmptyIntStackException();
        int result = this.que[0];
        num--;
        for (int i = 0; i < num; i++) {
            que[i] = que[i+1];
        }
        return result;
    }
    public int peek() {
        return this.que[0];
    }
    public void clear() {
        num = 0;
    }
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            if (x == que[i]) return i;
        }
        return -1;
    }
    public int getCapacity() {
        return this.capacity;
    }
    public int size(){
        return this.num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }
    public boolean isFull() {
        return this.num >= this.capacity;
    }
    public boolean dump() {
        if (num <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[i] + " ");
            System.out.println();
        }
        return false;
    }



}
