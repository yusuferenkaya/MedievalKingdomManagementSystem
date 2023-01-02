package GamePackage;

public class Queue {
    private int rear, front;
    private Object[] elements;
    private int capacityOfQueue;
    Queue(int capacity){
        elements = new Object[capacity];
        capacityOfQueue = elements.length;
        rear = -1;
        front = 0;
    }
    void enqueue(Object data) {
        if(isFull())
            System.out.println("Queue overflow");
        else {
            rear++;
            elements[rear] = data;
        }
    }
    Object dequeue() {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
            return null;
        }
        else {
            Object retData = elements[front];
            elements[front] = null;
            front++;
            return retData;
        }
    }
    Object peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        else {
            return elements[front];
        }
    }
    boolean isEmpty() {
        return rear<front;
    }
    boolean isFull() {
        return (rear+1 == elements.length);
    }
    int size() {
        return rear-front+1;
    }

    public int getCapacityOfQueue() {
        return capacityOfQueue;
    }

    public void setCapacityOfQueue(int capacityOfQueue) {
        this.capacityOfQueue = capacityOfQueue;
    }

    public String getFirst3(){
        int i = 0;
        int n = 0;
        String result = "";
        while(n<3){
            if(elements[i] != null){
            	if(n < 2)
            		result += elements[i] + ",";
            	else if(n==2)
            		result += elements[i];
                n++;
            }
            i++;
        }
        return result;

    }
    
    public Object[] getElements() {
    	return elements;
    }

    public void clearAll(){
        for(int i = 0; i<size();i++){
            dequeue();
        }
        rear = -1;
        front = 0;
    }

}
