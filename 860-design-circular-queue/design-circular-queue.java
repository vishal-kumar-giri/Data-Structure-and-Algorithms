class MyCircularQueue {
    int[] data;
    int front, rear, size, capacity;

    public MyCircularQueue(int k) {
        data = new int[k];
        capacity = k;
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;  // move rear circularly
        data[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity; // move front circularly
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return data[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return data[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
