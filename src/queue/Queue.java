package queue;


import java.util.Arrays;

public class Queue {

    private String[] theQueue;
    private int queueSize;
    private int front, rear, numberOfItems = 0;

    public Queue(int size) {
        queueSize = size;
        theQueue = new String[queueSize];
        Arrays.fill(theQueue, "-1");
    }

    public static void main(String[] args) {
        Queue queue = new Queue(10);
       // queue.offer("21");
       // queue.offer("12");
        queue.priorityInsert("21");
        queue.priorityInsert("3");
        queue.priorityInsert("43");
        queue.priorityInsert("14");
        queue.displayQueue();
        //queue.poll();
        //queue.displayQueue();


    }


    public void displayQueue() {
        for (int i = 0; i < queueSize; i++) {
            System.out.format("| %2s " + " ", i);
        }
        System.out.println("|");

        for (int i = 0; i < queueSize; i++) {
            if (theQueue[i].equals("-1")) System.out.print("|     ");
            else System.out.print(String.format("| %2s " + " ", theQueue[i]));
        }
        System.out.println("|");
    }


    public void offer(String input) {
        if (numberOfItems < queueSize) {
            theQueue[rear] = input;
            rear++;
            numberOfItems++;
        } else {
            System.out.println("The queue is full");
        }
    }


    public void poll() {
        if (numberOfItems > 0) {
            theQueue[front] = "-1";
            front++;
            numberOfItems--;
        } else {
            System.out.println("The queue is empty");
        }
    }


    public void peek() {
        System.out.println("The first element is " + theQueue[front]);
    }


    public void priorityInsert(String input) {
        int i;

        if (numberOfItems == 0) {
            offer(input);
        } else {
            for (i = numberOfItems; i >= 0; i--) {
                if (Integer.parseInt(input) > Integer.parseInt(theQueue[i])) {
                    theQueue[i + 1] = theQueue[i];
                }else break;
            }
            theQueue[i + 1] = input;
            rear++;
            numberOfItems++;
        }
    }


}
