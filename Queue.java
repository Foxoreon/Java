public class Queue {
    private int front;
    private int rear;
    private int size;
    private int[] items;
    private static final int DEFAULT_CAPACITY = 10;

    public Queue() {
        this.items = new int[DEFAULT_CAPACITY];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int item) {
        if (size == items.length) {
            resize();
        }
        rear = (rear + 1) % items.length;
        items[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int item = items[front];
        front = (front + 1) % items.length;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return items[front];
    }

    public int size() {
        return size;
    }

    private void resize() {
        int newCapacity = items.length * 2;
        int[] newItems = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[(front + i) % items.length];
        }
        items = newItems;
        front = 0;
        rear = size - 1;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        System.out.println("Размер: " + queue.size());
        System.out.println("Первый: " + queue.peek());
        
        System.out.println("Извлечен: " + queue.dequeue());
        System.out.println("Извлечен: " + queue.dequeue());
        
        System.out.println("Размер после извлечения: " + queue.size());
        
        while (!queue.isEmpty()) {
            System.out.println("Очистка: " + queue.dequeue());
        }
    }
}