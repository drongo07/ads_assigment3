import java.util.Random;

public class TestHashTable {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> hashTable = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(1000);
            String name = "Name" + id;
            MyTestingClass key = new MyTestingClass(id, name);
            hashTable.put(key, "Value" + i);
        }

        for (int i = 0; i < hashTable.size(); i++) {
            int count = 0;
            MyHashTable<MyTestingClass, String>.HashNode<MyTestingClass, String> current = hashTable.getChainArrayElement(i);
            while (current != null) {
                count++;
                current = current.getNext();
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }
}
