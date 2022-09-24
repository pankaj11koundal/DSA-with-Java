// Java program to show the stack implementation using arrays.

import java.util.Scanner;

public class StackImplementation {
    static Scanner sc = new Scanner(System.in), sin = new Scanner(System.in);


    static int push(int []stack, int size, int top) {
        char choose;
        do {
            if (top == size) {
                System.out.print("Stack is full, can't push more elements, pop some elements first: ");
                break;
            }
            System.out.print("Enter the element at " + (top + 1) + ": ");
            stack[top++] = sc.nextInt();
            System.out.print("Want to enter more elements(press y for yes: ");
            choose = sin.next().charAt(0);
        } while (choose == 'y' || choose =='Y');
        return top;
    }

    static void pop(int []stack, int top) {
        char choose;
        do {
            if (top < 0) {
                System.out.print("Stack is empty, can't pop more elements, push some elements first: ");
                break;
            }

            System.out.print("Element " + stack[top] + " is pop");
            top --;
            System.out.println("Want to pop more elements?(press y for yes): ");
            choose = sin.next().charAt(0);
        } while (choose == 'y' || choose =='Y');
    }

    static void traverse(int []stack, int top) {
        System.out.println("Elements in the array: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
    }

    static int seek(int []stack, int top) {
        return stack[top];
    }

    static int find(int []stack, int ele, int top) {
        for (int i = 0; i <= top; i++) {
            if (stack[i] == ele) {
                return i + 1;
            }
        }

        return -1;
    }

    static int poll(int []stack, int top) {
        if (top < 0) {
            System.out.print("Stack is empty, can't pop more elements, push some elements first: ");
            return -1;
        }

        System.out.print("Element " + stack[top] + " is pop");
        top --;
        return stack[top + 1];
    }

    public static void main(String[] args) {
        int size, option;
        int top = 0;
        char choose;
        System.out.print("Enter the size of the stack: ");
        size = sc.nextInt();

        int []stack = new int[size];

        System.out.println("Enter the operation you want to perform: ");
        System.out.println("1) Push");
        System.out.println("2) Pop");
        System.out.println("3) Traverse");
        System.out.println("4) Seek");
        System.out.println("5) Find");
        System.out.print("6) Poll: ");
        option = sc.nextInt();
        sc.next();

        do {
            switch (option) {
                case 1 -> {
                    System.out.println("Pushing elements into stack: ");
                    top = push(stack, size, top);
                }
                case 2 -> {
                    System.out.println("Pop elements out of stack");
                    pop(stack, top);
                }
                case 3 -> {
                    System.out.println("Traversing stack: ");
                    traverse(stack, top);
                }
                case 4 -> System.out.println("Element at the top is " + seek(stack, top));
                case 5 -> {
                    int ele, pos;
                    System.out.print("Enter the element you want to find: ");
                    ele = sc.nextInt();
                    pos = find(stack, ele, top);
                    if (pos != -1)
                        System.out.println("Element found at " + pos);
                    else
                        System.out.println("Element not found");
                }
                case 6 -> {
                    System.out.println("Polling element");
                    System.out.println("Element polled is " + poll(stack, top));
                }
            }
            System.out.println("Want to perform more operation(press y for yes: )");
            choose = sin.next().charAt(0);
        }while(choose == 'y' || choose == 'Y');
    }
}
