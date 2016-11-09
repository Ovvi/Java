package stack;


import java.util.Arrays;

public class Stack {

    private String[] theStack;
    private int stackSize;
    private int topOfStack = -1;

    public Stack(int size) {
        stackSize = size;
        theStack = new String[stackSize];
        Arrays.fill(theStack, "-1");
    }


    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.displayStack();
        stack.push("32");
        stack.push("12");
        stack.pushMany("4 5 12 43");
        stack.displayStack();
        stack.popAll();
        stack.displayStack();

    }



    public void displayStack() {
        for (int i = 0; i < stackSize; i++) {
            System.out.format("| %2s " + " ", i);
        }
        System.out.println("|");

        for (int i = 0; i < stackSize; i++) {
            if (theStack[i].equals("-1")) System.out.print("|     ");
            else System.out.print(String.format("| %2s " + " ", theStack[i]));
        }
        System.out.println("|");
    }

    public void push(String input) {
        if (topOfStack + 1 < stackSize) {
            topOfStack++;
            theStack[topOfStack] = input;
        } else {
            System.out.println("The stack is full");
        }
    }

    public void pop() {
        if (topOfStack >= 0) {
            theStack[topOfStack] = "-1";
            theStack[topOfStack] = theStack[topOfStack--];
        } else {
            System.out.println("The stack is empty");
        }
    }

    public String peek(){
        return theStack[topOfStack];
    }

    public void pushMany(String multipleValues){
        String[] temp = multipleValues.split(" ");

        for (int i = 0; i < temp.length; i++) {
            push(temp[i]);
        }
    }

    public void popAll(){
        for (int i = topOfStack; i >=0 ; i--) {
            pop();
        }
    }


}
