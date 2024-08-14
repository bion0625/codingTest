package doitStarter.ch0401;

import java.util.Scanner;

public class Q {
    public static void main(String[] args) {

        Q q = new Q();

//        q1();
//
//        q2();
//
//        q3();
//
//        q4();
//
//        q.q5();
//
//        q.q6();

        q.q7();
    }

    static void q1() {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while (true) {
            System.out.println();
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (5) 클리어 (6) 인덱스오브 (0) 종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    s.clear();
                    break;

                case 6:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    int idx = s.indexOf(x);
                    if (idx < 0) System.out.println("값이 없습니다.");
                    else System.out.println("데이터 " + x + "은 x[" + idx + "]에 있습니다.");
            }
        }
    }

    static void q2() {
        Scanner stdIn = new Scanner(System.in);
        Stack<String> s = new Stack<>(64);

        while (true) {
            System.out.println();
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (5) 클리어 (6) 인덱스오브 (0) 종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            String x;
            switch (menu) {
                case 1:
                    System.out.print("데이터: ");
                    x = stdIn.next();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    s.clear();
                    break;

                case 6:
                    System.out.print("데이터: ");
                    x = stdIn.next();
                    int idx = s.indexOf(x);
                    if (idx < 0) System.out.println("값이 없습니다.");
                    else System.out.println("데이터 " + x + "은 x[" + idx + "]에 있습니다.");
            }
        }
    }

    static void q3() {
        Scanner stdIn = new Scanner(System.in);
        IntDataStack stack = new IntDataStack(64);
        IntDataStack.BaseStack s = stack.getDataStack();

        while (true) {
            System.out.println();
            System.out.print("(1) forward (2) reverse (0) 종료: ");
            int direction = stdIn.nextInt();
            if (direction != 1 && direction != 2) break;
            switch (direction) {
                case 1: s = stack.getDataStack(); break;
                case 2: s = stack.getReverseStack(); break;
            }
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (5) 클리어 (6) 인덱스오브 (0) 종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    s.clear();
                    break;

                case 6:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    int idx = s.indexOf(x);
                    if (idx < 0) System.out.println("값이 없습니다.");
                    else System.out.println("데이터 " + x + "은 x[" + idx + "]에 있습니다.");
            }
        }
    }

    static void q4() {
        IntArrayQueueTester tester = new IntArrayQueueTester();
        tester.main(new String[0]);
    }

    void q5() {
        Scanner stdIn = new Scanner(System.in);
        IntQueueForQ5 s = new IntQueueForQ5(64);

        while (true) {
            System.out.println();
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1) 인큐 (2) 디큐 (3) 피크 (4) 덤프 (5) 검색 (0) 종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.enque(x);
                    } catch (IntQueue.OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.deque();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    System.out.print("검색할 데이터: ");
                    x = stdIn.nextInt();
                    int idx = s.search(x);
                    System.out.println(x + "는 " + (idx + 1) + "번째 데이터입니다.");
            }
        }
    }

    private class IntQueueForQ5 {

        private int[] que;
        private int capacity;
        private int front;
        private int rear;
        private int num;

        public class EmptyIntQueueFor5QException extends RuntimeException {
            public EmptyIntQueueFor5QException() { }
        }

        public class OverflowIntQueueFor5QException extends RuntimeException {
            public OverflowIntQueueFor5QException() { }
        }

        public IntQueueForQ5(int maxlen) {
            num = front = rear = 0;
            capacity = maxlen;
            try {
                que = new int[capacity];
            } catch (OutOfMemoryError e) {
                capacity = 0;
            }
        }

        public int enque(int x) throws OverflowIntQueueFor5QException {
            if (num >= capacity)
                throw new OverflowIntQueueFor5QException();
            que[rear++] = x;
            num++;
            if (rear == capacity)
                rear = 0;
            return x;
        }

        public int deque() throws EmptyIntQueueFor5QException {
            if (num <= 0) throw new EmptyIntQueueFor5QException();
            int x = que[front++];
            num--;
            if (front == capacity) front = 0;
            return x;
        }

        public int peek() throws EmptyIntQueueFor5QException {
            if (num <= 0) throw new EmptyIntQueueFor5QException();
            return que[front];
        }

        public void clear() {
            num = front = rear = 0;
        }

        public int indexOf(int x) {
            for (int i = 0; i < num; i++) {
                int idx = (i + front) % capacity;
                if (que[idx] == x) return idx;
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

        public int search(int x) {
            if (num <= 0)
                System.out.println("큐가 비어 있습니다.");
            else {
                for (int i = 0; i < num; i++) {
                    if (que[(i + front) % capacity] == x) return i;
                }
            }
            return -1;
        }
    }

    void q6() {
        Scanner stdIn = new Scanner(System.in);
        Queue<String> s = new Queue(64);

        while (true) {
            System.out.println();
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1) 인큐 (2) 디큐 (3) 피크 (4) 덤프 (0) 종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            String x;
            switch (menu) {
                case 1:
                    System.out.print("데이터: ");
                    x = stdIn.next();
                    try {
                        s.enque(x);
                    } catch (Queue.OverflowQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.deque();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (Queue.EmptyQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (Queue.EmptyQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;
            }
        }
    }

    void q7() {
        Scanner stdIn = new Scanner(System.in);
        IntDataDeque deque = new IntDataDeque(64);
        IntDataDeque.BaseDeque s = deque.getDequeForward();
        while (true) {
            System.out.println();
            System.out.printf("all data: %d / %d", s.size(), s.getCapacity());
            System.out.println();
            System.out.print("(1) forward (2) reverse (0) close: ");
            int menu = stdIn.nextInt();

            if (menu == 0) break;
            switch (menu) {
                case 1: s = deque.dequeForward; break;
                case 2: s = deque.dequeReverse; break;
            }

            System.out.print("(1) enque (2) deque (3) peek (4) dump (5) indexOf (0) close: ");
            menu = stdIn.nextInt();

            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("data: ");
                    x = stdIn.nextInt();
                    s.enque(x);
                    break;
                case 2:
                    s.deque();
                    break;
                case 3:
                    x = s.peek();
                    System.out.println("peek is " + x);
                    break;
                case 4:
                    s.dump();
                    break;
                case 5:
                    System.out.print("indexOf about: ");
                    x = stdIn.nextInt();
                    System.out.println(x + " index is " + s.indexOf(x));
            }
        }
    }
}
