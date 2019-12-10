import java.util.Arrays;

public class RobertJava {
    public static void main(String[] args) {
//    problem 1
//        String[] strArray1 = {"s", "t", "r", "i", "n", "g", "w"};
//        System.out.println(Arrays.toString(removeLetters(strArray1, "string")));
//        String[] strArray2 = {"b", "b", "l", "l", "g", "n", "o", "a", "w"};
//        System.out.println(Arrays.toString(removeLetters(strArray2, "balloon")));
//        String[] strArray3 = {"d", "b", "t", "e", "a", "i"};
//        System.out.println(Arrays.toString(removeLetters(strArray3, "edabit")));


//        Problem 2
        System.out.println(translateWord("flag"));
        System.out.println(translateWord("Apple"));
        System.out.println(translateWord("button"));
        System.out.println(translateWord(""));

        System.out.println(translateSentence("I like to eat honey waffles."));
        System.out.println(translateSentence("Do you think it is going to rain today?"));


    }

    //    Problem 1
//    site: https://edabit.com/challenge/6CkRcCdGAmCGPZnyb
//    Problem: Remove The Word!
//    Create a function that takes an array and string. The function should remove the letters in the string from the
//    array, and return the array.
    private static String[] removeLetters(String[] strArray, String word) {
        String[] wordArray = new String[word.length()];
        int matches = 0;
        for (int i = 0; i < word.length(); i++) {
            wordArray[i] = String.valueOf(word.charAt(i));
        }

        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < wordArray.length; j++) {
                if (strArray[i].equalsIgnoreCase(wordArray[j])) {
                    strArray[i] = "cleared";
                    wordArray[j] = "checked";
                    matches++;
                }
            }
        }

        String[] returnP = new String[strArray.length - matches];
        int index = 0;
        for (String letter : strArray) {
            if (!letter.equalsIgnoreCase("cleared") && (index != strArray.length - matches)) {
                returnP[index] = letter;
                index++;
            }
        }
        return returnP;
    }

    //    Problem 2
//    site: https://edabit.com/challenge/6dEDvruWbEDqXb7dk
//    Problem: English to Pig Latin Translator
//    Pig latin has two very simple rules:
//
// 1. If a word starts with a consonant move the first letter(s) of the word, till you reach a vowel, to the end of the word and add "ay" to the end.
//      have ➞ avehay
//      cram ➞ amcray
//      take ➞ aketay
//      cat ➞ atcay
//      shrimp ➞ impshray
//      trebuchet ➞ ebuchettray
//2. If a word starts with a vowel add "yay" to the end of the word.
//      ate ➞ ateyay
//      apple ➞ appleyay
//      oaken ➞ oakenyay
//      eagle ➞ eagleyay
//Write two functions to make an English to pig latin translator. The first function translateWord(word) takes a
// single word and returns that word translated into pig latin. The second function translateSentence(sentence) takes
// an English sentince and returns that sentence translated into pig latin.

    public static String translateWord(String word) {
        String specialHolder = "";
        if (word.equalsIgnoreCase("")) {
            return word;
        }
        String[] wordSetup = new String[word.length()];
        String[] wordArray;
        for (int i = 0; i < word.length(); i++) {
            wordSetup[i] = String.valueOf(word.charAt(i));
        }
        if (wordSetup[wordSetup.length - 1].equalsIgnoreCase("!") ||
                wordSetup[wordSetup.length - 1].equalsIgnoreCase(",") ||
                wordSetup[wordSetup.length - 1].equalsIgnoreCase(".") ||
                wordSetup[wordSetup.length - 1].equalsIgnoreCase("?")) {
            specialHolder = wordSetup[wordSetup.length - 1];
            wordArray = new String[word.length() - 1];
            for (int i = 0; i < word.length() - 1; i++) {
                wordArray[i] = String.valueOf(word.charAt(i));
            }
        } else {
            wordArray = wordSetup;
        }
        if (wordArray[0].equalsIgnoreCase("a") || wordArray[0].equalsIgnoreCase("e") ||
                wordArray[0].equalsIgnoreCase("i") || wordArray[0].equalsIgnoreCase("o") ||
                wordArray[0].equalsIgnoreCase("u")) {
            return word + "yay" + specialHolder;

        }

        do {
            String tempHold = wordArray[0];
            for (int i = 0; i < wordArray.length - 1; i++) {
                if (!Character.isUpperCase(wordArray[i].charAt(0))) {
                    wordArray[i] = wordArray[i + 1].toLowerCase();
                } else {
                    wordArray[i] = wordArray[i + 1].toUpperCase();
                }

            }
            wordArray[wordArray.length - 1] = tempHold;
        } while (!wordArray[0].equalsIgnoreCase("a") && !wordArray[0].equalsIgnoreCase("e") &&
                !wordArray[0].equalsIgnoreCase("i") && !wordArray[0].equalsIgnoreCase("o") &&
                !wordArray[0].equalsIgnoreCase("u"));

        String wordReturn;
        StringBuilder wordBuilder = new StringBuilder();
        for (String letter : wordArray) {
            wordBuilder.append(letter);
        }
        wordBuilder.append("ay").append(specialHolder);
        return wordBuilder.toString();

    }

    public static String translateSentence(String sentence) {
        String[] sentenceSplit = sentence.split("\\s+");
        for (int i = 0; i < sentenceSplit.length; i++) {
            sentenceSplit[i] = translateWord(sentenceSplit[i]);
        }

        StringBuilder wordBuilder = new StringBuilder();
        for (int i = 0; i < sentenceSplit.length; i++) {
            if (i == sentenceSplit.length - 1) {
                wordBuilder.append(sentenceSplit[i]);
            } else {
                wordBuilder.append(sentenceSplit[i]).append(" ");
            }
        }
        return wordBuilder.toString();
    }

    //    Problem 1
//    site: https://edabit.com/challenge/6CkRcCdGAmCGPZnyb
//    Problem: Remove The Word!

}
