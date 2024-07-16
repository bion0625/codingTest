package interview.ch09;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        for (int i = 0; i < 5; i++) {
            System.out.println(stack.pop());
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());

        Deque<Integer> dequeStack = new ArrayDeque<>();
        dequeStack.push(1);
        dequeStack.push(2);
        dequeStack.push(3);
        System.out.println(dequeStack.pop());
    }
}
