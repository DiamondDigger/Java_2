package CollcetJava;

import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {
        // create TreeSet from args - arguments for the main thread

        Set<String> set = new TreeSet<String>(Arrays.asList(args));
        System.out.println("set: "+set);

        Map<Integer,String> hashMap = new HashMap<Integer, String>();
        hashMap.put(5,"a");
        hashMap.put(4,"b");
        hashMap.put(3,"c");
        hashMap.put(2,"d");
        hashMap.put(1,"e");
        System.out.println("hashMap: "+hashMap);

        Map<Integer,String> linkedHashMap = new LinkedHashMap<Integer, String>();
        hashMap.put(5,"a");
        hashMap.put(4,"b");
        hashMap.put(3,"c");
        hashMap.put(2,"d");
        hashMap.put(1,"e");
        System.out.println("linkedHashMap: "+linkedHashMap);
    }
}
