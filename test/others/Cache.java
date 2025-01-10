package test.others;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class InfinixTest {
/* 
     LRU - Least recetly used

    size = 5
    data key, value
    access_count

    DS:
        key: count

        3, 4, 6, 1, 

        DLL
        HashMap 

*/







}



public interface Cache {
    final int capacity = 10;

    boolean add(String key, String data);
    String get(String key) throws Exception;


    
}

class LRU implements Cache{
    
    Map<String, String> data;
    Set<String> keyList = new LinkedHashSet<>();


    public boolean add(String key, String value){
        data.put(key, value);
        notifyDataAccessed(key);
        return true;
    }
    


    public String get(String key) throws Exception{

        if(data.containsKey(key)) {
            notifyDataAccessed(key);

            return data.get(key);
        }
        else{
            throw new Exception("No Data!!");
        }

    }

    private void notifyDataAccessed(String key) {
        
        // is full
        if(data.size() == capacity) {
            String deletekey = keyList.iterator().next();
            keyList.remove(deletekey);
        }
        // delete old cached data

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifyDataAccessed'");
    }

}
