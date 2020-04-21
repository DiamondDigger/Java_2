package CollcetJava;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(2);
        set.add(2);
        set.add(5);

        System.out.println("set: "+set);
    }
}
