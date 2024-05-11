public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(5, "Five");
        bst.put(3, "Three");
        bst.put(7, "Seven");
        bst.put(2, "Two");
        bst.put(4, "Four");
        bst.put(6, "Six");
        bst.put(8, "Eight");

        System.out.println("Value associated with key 4: " + bst.get(4));

        System.out.println("Deleting key 4...");
        bst.delete(4);

        System.out.println("Value associated with key 4 after deletion: " + bst.get(4));

        System.out.println("Iterating through keys in BST:");
        for (Integer key : bst.iterator()) {
            System.out.println(key + ": " + bst.get(key));
        }
    }
}
