// Java program to show the implementation of the min stack without any extra space.

import java.util.Scanner;

public class MinStackWithoutExtraSpace {
    static Scanner sc = new Scanner(System.in);

    static int top = 0, smallest;

    static void push(int []stack, int size) {
        if (top == size)
            System.out.println("cannot insert element");
        else{
            System.out.println("Enter the data you want to enter: ");
            int data = sc.nextInt();
            if (top == 0) {
                smallest = data;
                stack[top] = data;
            } else if (smallest > data) {
                stack[top] = 2 * data - smallest;
                smallest = data;
            } else
                stack[top] = data;

            top++;
        }
    }

    static int pop(int []stack) {
        int last = -1;
        if (top == -1) {
            System.out.println("Pop operation is not possible");
        } else if(stack[top - 1] < smallest) {
            last = smallest;
            smallest = smallest * 2 - stack[top - 1];
            top--;
        } else {
            last = stack[top - 1];
            top--;
        }
        return last;
    }

    public static int getSmallest() {
        if (top == -1)
            System.out.println("Stack is empty");
        return smallest;
    }

    static void showStack(int []stack) {
        System.out.println("Elements in the stack: ");
        for (int i : stack) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int size;
        System.out.println("Enter the size of the stack: ");
        size = sc.nextInt();

        int []stack = new int[size];
        showStack(stack);
        System.out.println();
        push(stack, size);
        push(stack, size);
        push(stack, size);
        push(stack, size);
        push(stack, size);
        showStack(stack);

        System.out.println();

        System.out.println(pop(stack) + " popped successfully");
        System.out.println("smallest element is " + getSmallest());
        System.out.println(pop(stack) + " popped successfully");
        System.out.println("smallest element is " + getSmallest());
        System.out.println(pop(stack) + " popped successfully");
        System.out.println("smallest element is " + getSmallest());
        System.out.println(pop(stack) + " popped successfully");
        System.out.println("smallest element is " + getSmallest());
        System.out.println(pop(stack) + " popped successfully");
    }
}
