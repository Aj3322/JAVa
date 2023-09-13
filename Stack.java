package Java;

import java.util.Scanner;

public class Stack {
    public static void main(String[] args) {
       final int MAXSTK = 10;
       int[] stackArray = new int[MAXSTK];
       int top = -1;
        int stack[]=new int[10];
        System.out.println("Enter the operation you want");
         System.out.println("To Pop the element: => I");
          System.out.println("To Push element: Enter => P");
           System.out.println("To Desplay the the stack: Enter => D");
           Scanner sc = new Scanner(System.in);
           char option = sc.next().charAt(0);
           switch (option) {
            case 'I':
            if (top >= 0) {
                int poppedValue = stackArray[top];
                top--;
                System.out.println("Popped " + poppedValue + " from the stack.");
            } else {
                System.out.println("Stack is empty. Cannot pop.");
            }
                break;
            case 'P':
            if(top == (MAXSTK - 1)){
                System.out.println("Stack is Full");
            }else {
                System.out.println("Enter the value to push");
             int value = sc.nextInt();
            if (top < MAXSTK - 1) {
                top++;
                stackArray[top] = value;
                System.out.println("Pushed " + value + " onto the stack.");
            } else {
                System.out.println("Stack is full. Cannot push " + value + ".");
            }
            }
                break;
            case 'D':
            if (top >= 0) {
                System.out.print("Stack: ");
                for (int i = 0; i <= top; i++) {
                    System.out.print(stackArray[i] + " ");
                }
                System.out.println();
            } else {
                System.out.println("Stack is empty.");
            }
                break;
           
            default:
             System.out.println("Please enter a valid option");
                break;
           }


    }
}
