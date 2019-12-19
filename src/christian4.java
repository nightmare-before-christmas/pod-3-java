import java.util.Arrays;
public class christian4
{
    static int array[] = new int[]{10, 20, 30, 40, 50, 60};

    static void rotate_array()
    {
        int a = array[array.length-1], i;
        for (i = array.length-1; i > 0; i--)
            array[i] = array[i-1];
        array[0] = a;
    }

    public static void main(String[] args)
    {
        System.out.println("Original arraay:");
        System.out.println(Arrays.toString(array));

        rotate_array();

        System.out.println("Rotated arraay:");
        System.out.println(Arrays.toString(array));
    }
}