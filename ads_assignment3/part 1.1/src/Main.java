public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer, String> hashTable = new MyHashTable<>();

        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(3, "Three");

        System.out.println("Value for key 2: " + hashTable.get(2));

        System.out.println("Removing value for key 1: " + hashTable.remove(1));

        System.out.println("Contains value 'Three': " + hashTable.contains("Three"));

        System.out.println("Key for value 'Two': " + hashTable.getKey("Two"));
    }
}
