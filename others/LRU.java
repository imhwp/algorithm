package others;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRU extends LinkedHashMap<String, String> {
    private final int MAX_SIZE;
    public LRU(int size){
        //accessOrder为true表示按照访问顺序排序
        //false表示按照插入顺序排序
        super(size,0.75f,false
        );
        MAX_SIZE = size;
    }

    public boolean removeEldestEntry(Map.Entry entry){
        return size()>MAX_SIZE;
    }


    public static void printLRUCache(LRU lru){
        Set<Map.Entry<String, String>> entries = lru.entrySet();
        for (Map.Entry entry:entries){
            System.out.println(entry.getKey()+"=="+entry.getValue());
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put("1","1");
        lru.put("2","2");
        lru.put("3","3");
        lru.put("1","1");
        lru.put("4","4");
        printLRUCache(lru);
    }

}
