import java.util.ArrayList;
import java.util.List;

public class Tree {
    private Node root;
    
    private class Node {
        int value;
        List<Node> children = new ArrayList<>();
        
        Node(int value) {
            this.value = value;
        }
    }
    
    public void addRoot(int value) {
        root = new Node(value);
    }
    
    public void addChild(int parentValue, int childValue) {
        Node parent = find(root, parentValue);
        if (parent != null) {
            parent.children.add(new Node(childValue));
        }
    }
    
    private Node find(Node node, int value) {
        if (node == null) return null;
        if (node.value == value) return node;
        
        for (Node child : node.children) {
            Node found = find(child, value);
            if (found != null) return found;
        }
        return null;
    }
    
    public void print() {
        print(root, "");
    }
    
    private void print(Node node, String prefix) {
        if (node != null) {
            System.out.println(prefix + node.value);
            for (Node child : node.children) {
                print(child, prefix + "  ");
            }
        }
    }
    
    public boolean contains(int value) {
        return find(root, value) != null;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        
        tree.addRoot(1);
        tree.addChild(1, 2);
        tree.addChild(1, 3);
        tree.addChild(2, 4);
        tree.addChild(2, 5);
        tree.addChild(3, 6);
        
        System.out.println("Дерево:");
        tree.print();
        
        System.out.println("\nПоиск:");
        System.out.println("Есть 5? " + tree.contains(5));
        System.out.println("Есть 10? " + tree.contains(10));
    }
}
