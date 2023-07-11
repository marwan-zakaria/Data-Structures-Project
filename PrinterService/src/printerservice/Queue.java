package printerservice;

/**
 *
 * @author marwan
 */
public class Queue {
    // two Nodes front to point at the first node and rear to point at the last node
    Node front, rear;
    //count the number of nodes in the queue
    int count;
    // time
    int t = 0;

    public Queue() {
        front = null;
        rear = null;
        t = 0;
        count = 0;
    }

    public void enqueue(int data) {
        if (data == 0) {
            //if the user enters 0 increase the timer and check to see if 5 minutes have passed
            t++;
            if (t % 5 == 0) {
                //if the timer is divisble by 5 this means 5 minutes have passed
                System.out.print("Time t = " + t);
                System.out.println(" Job " + dequeue() + " is processed");

            }
            return;
        } else if (data == -99) {
            //if the user enters -99 the company will close
            closePrinter();
            return;
        }
        // any other number will be added to the queue
        if (front == null) {
            // if the queue is empty front and rear will point at the first node
            front = new Node(data);
            rear = front;
        } else {
            // if the queue is not empty then front wil point at the first node and rear will point at the last
            rear.next = new Node(data);
            rear = rear.next;
        }
        count++;
        t++;
        System.out.print("Time t = " + t);
        System.out.println(" A request for print job " + data + " is issued");
        if (t % 5 == 0) {
            //if the timer is divisble by 5 this means 5 minutes have passed
            System.out.print("Time t = " + t);
            System.out.println(" Job " + dequeue() + " is processed");

        }
    }
    // check to see if queue is empty
    public boolean isEmpty() {
        return (front == null);
    }
    //remove the first node in the queue and decrease the counter and return the data in the first node
    public int dequeue() {
        if (isEmpty()) {
            //No elements in the queue
            return -1;
        }
        
        int val = front.data;
        front = front.next;
        count--;
        return val;
    }
// print the company closing and the remaining number of elements in the queue
    public void closePrinter() {
        System.out.println("Company is now closing");
        System.out.println("Remaining number of jobs in the queue " + count);
    }
}
