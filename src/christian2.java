import java.util.ArrayList;
import java.util.Collections;
public class christian2 {
    public static void main(String[] args) {
        ArrayList<String> colors= new ArrayList<String>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Black");
        colors.add("White");
        colors.add("Pink");

        System.out.println("Array list before Swap:");
        for(String a: colors){
            System.out.println(a);
        }
        //Swapping 1st(index 0) element with the 3rd(index 2) element
        Collections.swap(colors, 0, 2);
        System.out.println("Array list after swap:");
        for(String b: colors){
            System.out.println(b);
        }
    }
}
