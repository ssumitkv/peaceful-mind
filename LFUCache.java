import java.util.Map;
import java.util.PriorityQueue;


public class LFUCache {

    // storage
    static Map<String, Object> cache;
    static PriorityQueue<String> frequency;
    static int CAPACITY = 10;
    

    // Map = key , value, 
    // <key, 1> "key", "frequency"

    public static Object get(String key) {
        if(cache.containsKey(key)) {
            updateFrequency(key);
            return cache.get(key);
        }
        return -1;
    }

    public static void put(String key, Object value) {
        if(CAPACITY == cache.size()) {
            clean();
        }
        cache.put(key, value);
        updateFrequency(key);
    }

    // Async
    private static void clean() {
        String key = frequency.poll();
        cache.remove(key);
    }

    private static void updateFrequency(String key) {
        frequency.add(key);
    }

    public static void main(String[] args) {
        
    }

}