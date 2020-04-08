import java.util.Scanner;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;
        private boolean removed;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public void remove() {
             removed = true;   
        }

        public boolean isRemoved() {
             return removed;   
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            // put your code here
            int idx = findKey(key);
            if (idx == -1)
                return false;
            table[idx] = new TableEntry(key, value);
            return true;

        }

        public T get(int key) {
            // put your code here
            int idx = findKey(key);
            if (idx == -1 || table[idx] == null || table[idx].isRemoved())
                return null;
            return (T) table[idx].getValue();
        }

        public void remove(int key) {
            // put your code here
            int idx = findKey(key);
            if (idx != -1 && table[idx] != null && !table[idx].isRemoved()){
                table[idx].remove();

            }


        }

        private int findKey(int key) {
            // put your code here

            int hash = key % size;
            while (!(table[hash] == null || table[hash].getKey() == key)){
                hash = (hash + 1) % size;
                if (hash == key % size)
                    return -1;
            }
            return hash;
        }

        private void rehash() {
            // put your code here
        }
    }

    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashTable<String> table = new HashTable<>(n);
        for (int i = 0; i < n; i++){
            String s = scanner.next();
            int id = scanner.nextInt();
            if (s.equals("put")){
                String number = scanner.next();
                table.put(id, number);

            }
            if (s.equals("get")){
                String q = (table.get(id) != null) ? table.get(id) : "-1";
                System.out.println(q);
            }
            if (s.equals("remove")){
                table.remove(id);
            }
        }

    }
}