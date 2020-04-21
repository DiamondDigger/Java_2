package CollcetJava;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleLRUCash<K,V> extends LinkedHashMap<K,V> {
    private int capacity;

    public SimpleLRUCash(int capacity) {

        // capacity +1 - because firstly will have been put the next element and only then will be existed
        // method removeElderEntry
        super(capacity,1.1f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size()>capacity;
    }
}
