class Entry<K, V> {
    public K key;
    public V value;
    public Entry<K, V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public void setValue(V value) {
        this.value = value;
    }

}

class HashMap<K, V> {
    public final int SIZE = 5;

    private final Entry<K, V>[] table;

    public HashMap() {
        table = new Entry[SIZE];
    }

    public V put(K key, V value) {
        int hash = key.hashCode() % SIZE;
        Entry<K, V> e = table[hash];

        if (e == null) {
            table[hash] = new Entry<K, V>(key, value);
        } else {
            while (e.next != null) {
                if (e.getKey() == key) {
                    e.setValue(value);
                    return value;
                }
                e = e.next;
            }

            if (e.getKey() == key) {
                e.setValue(value);
                return value;
            }

            e.next = new Entry<K, V>(key, value);
        }
        return value;
    }

    public Boolean contains(K key) {
        int hash = key.hashCode() % SIZE;
        Entry<K, V> e = table[hash];
        if (e == null) {
            return false;
        }
        while (e != null) {
            if (e.getKey() == key) {
                return true;
            }
            e = e.next;
        }

        return false;
    }

    public Boolean remove(K key) {
        int hash = key.hashCode() % SIZE;
        Entry<K, V> e = table[hash];

        if (e == null) {
            return false;
        }

        if (e.getKey() == key) {
            table[hash] = e.next;
            e.next = null;
            return true;
        }

        Entry<K, V> prev = e;
        e = e.next;
        while (e != null) {
            if (e.getKey() == key) {
                prev.next = e.next;
                e.next = null;
                return true;
            }
            prev = e;
            e = e.next;
        }
        return false;
    }
}
