public class List {
    private Object[] items;
    private int count;
    
    public List() {
        this.items = new Object[10];
        this.count = 0;
    }
    
    public void add(Object item) {
        if (count == items.length) {
            resize();
        }
        items[count++] = item;
    }
    
    public Object get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return items[index];
    }
    
    public Object remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Object removed = items[index];
        for (int i = index; i < count - 1; i++) {
            items[i] = items[i + 1];
        }
        items[--count] = null;
        return removed;
    }
    
    public int size() {
        return count;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    private void resize() {
        Object[] newItems = new Object[items.length * 2];
        for (int i = 0; i < count; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }
    
    @Override
    public String toString() {
        if (count == 0) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            sb.append(items[i]);
            if (i < count - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        List list = new List();
        
        list.add("Банан");
        list.add("Яблоко");
        list.add("Апельсин");
        
        System.out.println("Список: " + list);
        System.out.println("Размер: " + list.size());
        System.out.println("Элемент 1: " + list.get(1));
        
        list.remove(0);
        System.out.println("После удаления: " + list);
    }
}