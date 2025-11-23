public class BinaryTree {
    private Node root;
    
    private class Node {
        int value;
        Node left, right;
        
        Node(int value) {
            this.value = value;
        }
    }
    
    public void add(int value) {
        root = addRecursive(root, value);
    }
    
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        
        return current;
    }
    
    public boolean contains(int value) {
        return containsRecursive(root, value);
    }
    
    private boolean containsRecursive(Node current, int value) {
        if (current == null) return false;
        if (value == current.value) return true;
        
        return value < current.value 
            ? containsRecursive(current.left, value)
            : containsRecursive(current.right, value);
    }
    
    public void printInOrder() {
        printInOrderRecursive(root);
        System.out.println();
    }
    
    private void printInOrderRecursive(Node node) {
        if (node != null) {
            printInOrderRecursive(node.left);
            System.out.print(node.value + " ");
            printInOrderRecursive(node.right);
        }
    }
    
    public void printTree() {
        printTreeRecursive(root, "");
    }
    
    private void printTreeRecursive(Node node, String prefix) {
        if (node != null) {
            printTreeRecursive(node.right, prefix + "    ");
            System.out.println(prefix + node.value);
            printTreeRecursive(node.left, prefix + "    ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);
        
        System.out.println("Дерево:");
        tree.printTree();
        
        System.out.println("\nIn-order обход:");
        tree.printInOrder();
        
        System.out.println("\nПоиск:");
        System.out.println("Есть 40? " + tree.contains(40));
        System.out.println("Есть 90? " + tree.contains(90));
    }
}
