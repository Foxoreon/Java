public class Set {
    private Object[] items;
    private int count;
    
    public Set() {
        this.items = new Object[10];
        this.count = 0;
    }
    
    public boolean add(Object item) {
        if (contains(item)) {
            return false;
        }
        if (count == items.length) {
            resize();
        }
        items[count++] = item;
        return true;
    }
    
    public boolean remove(Object item) {
        for (int i = 0; i < count; i++) {
            if (item == null ? items[i] == null : item.equals(items[i])) {
                for (int j = i; j < count - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[--count] = null;
                return true;
            }
        }
        return false;
    }
    
    public boolean contains(Object item) {
        for (int i = 0; i < count; i++) {
            if (item == null ? items[i] == null : item.equals(items[i])) {
                return true;
            }
        }
        return false;
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
        if (count == 0) return "{}";
        
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < count; i++) {
            sb.append(items[i]);
            if (i < count - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        Set set = new Set();
        
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);
        
        System.out.println("Множество: " + set);
        System.out.println("Размер: " + set.size());
        System.out.println("Содержит 2: " + set.contains(2));
        
        set.remove(1);
        System.out.println("После удаления: " + set);
    }

}
