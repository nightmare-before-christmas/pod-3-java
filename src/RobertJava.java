import java.util.Arrays;

public class RobertJava {
    public static void main(String[] args) {
//    problem 1
        String[] strArray1 = {"s", "t", "r", "i", "n", "g", "w"};
        System.out.println(Arrays.toString(removeLetters(strArray1, "string")));
        String[] strArray2 = {"b", "b", "l", "l", "g", "n", "o", "a", "w"};
        System.out.println(Arrays.toString(removeLetters(strArray2, "balloon")));
        String[] strArray3 = {"d", "b", "t", "e", "a", "i"};
        System.out.println(Arrays.toString(removeLetters(strArray3, "edabit")));
    }

    //    Problem 1
//    site: https://edabit.com/challenge/6CkRcCdGAmCGPZnyb
//    Problem: Remove The Word!
//    Create a function that takes an array and string. The function should remove the letters in the string from the
//    array, and return the array.
    private static String[] removeLetters(String[] strArray, String word){
        String[] wordArray = new String[word.length()];
        int matches = 0;
        for (int i = 0; i < word.length();i++){
            wordArray[i] = String.valueOf(word.charAt(i));
        }

        for (int i = 0; i<strArray.length;i++){
            for (int j = 0; j < wordArray.length;j++){
                if (strArray[i].equalsIgnoreCase(wordArray[j])){
                    strArray[i] = "cleared";
                    wordArray[j] = "checked";
                    matches++;
                }
            }
        }

        String[] returnP = new String[strArray.length-matches];
        int index = 0;
        for (String letter: strArray) {
            if (!letter.equalsIgnoreCase("cleared") && (index !=strArray.length-matches)){
                returnP[index]= letter;
                index++;
            }
        }
        return  returnP;
    }


}
