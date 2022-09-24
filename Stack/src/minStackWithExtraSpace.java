// Java program to implement the minStack

import java.util.Stack;

class minStackWithExtraSpace {
    static Stack<Integer> st = new Stack<>();
    static Stack<Integer> sst = new Stack<>();

    static void push(int data) {
        st.push(data);
        if (sst.empty() || st.peek() <= sst.peek())
            sst.push(data);
    }

    static int pop() {
        if (st.peek().equals(sst.peek())) {
            sst.pop();
        }
        return st.pop();
    }

    static int peek() {
        if (st.empty())
            return -1;
        return st.peek();
    }

    static int smallEle()
    {
        if (sst.empty())
            return -1;
        return sst.peek();
    }

    public static void main(String[] args) {
        push(18);
        System.out.println("The smallest element in the stack is " + smallEle());
        System.out.println("Element at the top of stack: " + peek());

        push(19);
        System.out.println("The smallest element in the stack is " + smallEle());
        System.out.println("Element at the top of stack: " + peek());

        push(29);
        System.out.println("The smallest element in the stack is " + smallEle());
        System.out.println("Element at the top of stack: " + peek());

        push(15);
        System.out.println("The smallest element in the stack is " + smallEle());
        System.out.println("Element at the top of stack: " + peek());
        System.out.println("Pop the element: " + pop());

        System.out.println("The smallest element in the stack is " + smallEle());
        System.out.println("Element at the top of stack: " + peek());
        push(16);
        System.out.println("The smallest element in the stack is " + smallEle());
        System.out.println("Element at the top of stack: " + peek());

        for (Integer ele: st) {
            System.out.print(ele + " ");
        }
    }
}