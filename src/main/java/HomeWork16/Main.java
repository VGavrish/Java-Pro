package HomeWork16;

public class Main {
    public static void main(String[] args) {
        SimpleTree tree = new SimpleTree();
        tree.add(8);
        tree.add(1);
        tree.add(3);
        tree.add(5);
        tree.add(2);
        tree.add(12);
        tree.add(23);
        tree.add(43);
        tree.add(54);
        tree.add(65);
        tree.add(57);
        tree.add(36);
        tree.add(22);

        System.out.println("Tree traversal: ");
        tree.traverse();
    }
}
