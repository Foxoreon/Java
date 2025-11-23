public class Stack {
    private int top;
    private int[] items;
    
    public Stack() {
        this(10);
    }
    
    public Stack(int capacity) {
        this.top = -1;
        this.items = new int[capacity];
    }
    
    public void initStack() {
        this.top = -1;
    }
    
    public void push(int item) {
        if (top == items.length - 1) {
            resize();
        }
        top += 1;
        items[top] = item;
    }
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return Integer.MIN_VALUE;
        } else {
            int item = items[top];
            top -= 1;
            return item;
        }
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.println("Stack (top to bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println("  " + items[i]);
        }
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot peek.");
            return Integer.MIN_VALUE;
        }
        return items[top];
    }
    
    public int size() {
        return top + 1;
    }
    
    private void resize() {
        int newCapacity = items.length * 2;
        int[] newItems = new int[newCapacity];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
        System.out.println("Stack resized to " + newCapacity);
    }
    
    public void clear() {
        top = -1;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack: []";
        }
        
        StringBuilder sb = new StringBuilder("Stack: [");
        for (int i = 0; i <= top; i++) {
            sb.append(items[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.initStack();
        
        System.out.println("=== ТЕСТИРОВАНИЕ СТЕКА ===");
        
        System.out.println("\n1. Добавляем элементы 10, 20, 30:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.displayStack();
        
        System.out.println("\n2. Просматриваем вершину стека:");
        System.out.println("Вершина: " + stack.peek());
        
        System.out.println("\n3. Извлекаем элемент:");
        int popped = stack.pop();
        System.out.println("Извлечен: " + popped);
        stack.displayStack();
        
        System.out.println("\n4. Проверяем размер стека:");
        System.out.println("Размер: " + stack.size());
        
        System.out.println("\n5. Добавляем еще элементов для теста расширения:");
        for (int i = 4; i <= 15; i++) {
            stack.push(i * 10);
        }
        stack.displayStack();
        System.out.println("Текущий размер: " + stack.size());
        
        System.out.println("\n6. Извлекаем все элементы:");
        while (!stack.isEmpty()) {
            System.out.println("Извлечен: " + stack.pop());
        }
        
        System.out.println("\n7. Пытаемся извлечь из пустого стека:");
        stack.pop();
        
        System.out.println("\n8. Проверяем пустоту стека:");
        System.out.println("Стек пуст: " + stack.isEmpty());
    }
}
