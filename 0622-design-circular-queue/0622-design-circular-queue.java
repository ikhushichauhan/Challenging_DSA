class MyCircularQueue {
    int[] arr;
    int front;
    int rear;
    int size;
    int cap;
  public MyCircularQueue(int k) {
        arr = new int[k];
        cap = k;
        size = 0;
        front = 0;
        rear = -1;
    }
public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % cap;
        arr[rear] = value;
        size++;
        return true;
    }
public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % cap;
        size--;
        return true;
    }
public int Front() {
        if (isEmpty()) return -1;
        return arr[front];
    }
    public int Rear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }
 public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == cap;
    }
}