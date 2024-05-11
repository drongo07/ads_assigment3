import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.KeyValueEntry<K, V>> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }

    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            size--;
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    private Node min(Node x) {
        while (x.left != null) x = x.left;
        return x;
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public Iterable<K> keysIterator() {
        Queue<K> keys = new LinkedList<>();
        inOrder(root, keys);
        return keys;
    }

    private void inOrder(Node x, Queue<K> keys) {
        if (x == null) return;
        inOrder(x.left, keys);
        keys.add(x.key);
        inOrder(x.right, keys);
    }

    public int size() {
        return size;
    }

    public class KeyValueEntry<K, V> {
        private K key;
        private V value;

        public KeyValueEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    @Override
    public Iterator<KeyValueEntry<K, V>> iterator() {
        Queue<KeyValueEntry<K, V>> entries = new LinkedList<>();
        inOrderEntries(root, entries);
        return entries.iterator();
    }

    private void inOrderEntries(Node x, Queue<KeyValueEntry<K, V>> entries) {
        if (x == null) return;
        inOrderEntries(x.left, entries);
        entries.add(new KeyValueEntry<>(x.key, x.val));
        inOrderEntries(x.right, entries);
    }
}
