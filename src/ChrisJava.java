import org.w3c.dom.ls.LSOutput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;
import java.util.Scanner;

public class ChrisJava {

    public static String reverseString(String word){
        return new StringBuilder(word).reverse().toString();
    }

    public static int triangleArea(int num1, int num2){
        return (num1 * num2) / 2;
    }


//
//    private static int getOddOccurrence(int[] arr) {
//        int arr_size = arr.length;
//        {
//            int i;
//            for (i = 0; i < arr_size; i++) {
//                int count = 0;
//                for (int j = 0; j < arr_size; j++) {
//                    if (arr[i] == arr[j])
//                        count++;
//                }
//                if (count % 2 == 1)
//                    return arr[i];
//            }
//            return -1;
//        }
//    }
//
//    //initializing a map for the reusable roman numerals using the TreeMap util//
//    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
//
//    static {
//
//        map.put(1000, "M");
//        map.put(900, "CM");
//        map.put(500, "D");
//        map.put(400, "CD");
//        map.put(100, "C");
//        map.put(90, "XC");
//        map.put(50, "L");
//        map.put(40, "XL");
//        map.put(10, "X");
//        map.put(9, "IX");
//        map.put(5, "V");
//        map.put(4, "IV");
//        map.put(1, "I");
//
//    }
//
//
//    public static String toRoman(int number) {
//        //below takes the highest value without going over the number passed in the toRoman//
//        int l = map.floorKey(number);
//        //if the number is equal to the map provided number then grab that number//
//        if (number == l) {
//            return map.get(number);
//        }
//        //else it's going to take the number passed and subtract the map number to get the remainder and add it to the end
//        //to get the the proper roman numeral value
//        return map.get(l) + toRoman(number - l);
//    }


    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("reverse(Howdy) = " + reverseString("Howdy"));

        System.out.println("triangleArea(10, 10) = " + triangleArea(10, 10));


//        boolean anothernumber = true;
//
//
//        while(anothernumber) {
//            System.out.println("give me a number to convert to roman numerals");
//            int num = scan.nextInt();
//            System.out.println(toRoman(num));
//            System.out.println("do you want to convert another number? y/n");
//            //the following nextLine is used to reset the scanner to go to a string from an int
//            scan.nextLine();
//            String response = scan.nextLine();
//            if (response.equalsIgnoreCase("Y")){
//                anothernumber = true;
//            } else {
//                anothernumber = false;
//            }
//        }
//
//
//
//
//        //find an int that only appears an odd amount of times and pull it out and return it//
//        int[] numsArray = new int[]{1, 2, 2, 1, 4, 5, 5};
//        System.out.println("getOddOccurrence(numsArray) = " + getOddOccurrence(numsArray));
//
//
//        //take input in 12hr AM/PM time format and return them as 24hr format//
//        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
//        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ss a");
//        Date date = parseFormat.parse("12:00:00 AM");
//        System.out.println(parseFormat.format(date) + " = " + displayFormat.format(date));




    }
}
