import java.util.*;
public class christian1 {
    public static void main(String args[]){

        HashMap<Integer,String> hash_map= new HashMap<Integer,String>();

        hash_map.put(1,"Red");
        hash_map.put(2,"Green");
        hash_map.put(3,"Black");
        hash_map.put(4,"White");
        hash_map.put(5,"Blue");

        // get keyset value from map
        Set keyset = hash_map.keySet();

        // check key set values
        System.out.println("Key set values are: " + keyset);
        System.out.println("The Colors are: " + hash_map.values());
    }
}
