import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobertJava {
    public static void main(String[] args) {
//    problem 1
        String[] strArray1 = {"s", "t", "r", "i", "n", "g", "w"};
        System.out.println(Arrays.toString(removeLetters(strArray1, "string")));
        String[] strArray2 = {"b", "b", "l", "l", "g", "n", "o", "a", "w"};
        System.out.println(Arrays.toString(removeLetters(strArray2, "balloon")));
        String[] strArray3 = {"d", "b", "t", "e", "a", "i"};
        System.out.println(Arrays.toString(removeLetters(strArray3, "edabit")));
        System.out.println();

//        Problem 2
        System.out.println(translateWord("flag"));
        System.out.println(translateWord("Apple"));
        System.out.println(translateWord("button"));
        System.out.println(translateWord(""));
        System.out.println(translateSentence("I like to eat honey waffles."));
        System.out.println(translateSentence("Do you think it is going to rain today?"));
        System.out.println();

//        Problem 3
        System.out.println(convertToRoman(2));
        System.out.println(convertToRoman(12));
        System.out.println(convertToRoman(16));
//        System.out.println(convertToRoman(3999));
        System.out.println();

//        problem 4
        System.out.println(longestSubstring("225424272163254474441338664823"));
        System.out.println(longestSubstring("594127169973391692147228678476"));
        System.out.println(longestSubstring("721449827599186159274227324466"));
        System.out.println();

//        Problem 5
        System.out.println(formula("6 * 4 = 24"));
        System.out.println(formula("18 / 17 = 2"));
        System.out.println(formula("16 * 10 = 160 = 40 + 120"));
        System.out.println(formula("16 * 10 = 160 = 14 + 120"));
        System.out.println(formula("16 * 10 = 160 = 10 + 120 + 30"));
        System.out.println(formula("16 * 10 = 160 = 10 + 120 + 31"));
        System.out.println();

//        ***************************** WEEK 2 **************************************
//        Problem 1
        String paragraph = "Sunset is the time of day when our sky meets the outer space solar winds. " +
                "There are blue, pink, and purple swirls, spinning and twisting, like clouds of balloons caught " +
                "in a whirlwind. The sun moves slowly to hide behind the line of horizon, while the moon races to " +
                "take its place in prominence atop the night sky. People slow to a crawl, entranced, fully " +
                "forgetting the deeds that must still be done. There is a coolness, a calmness, when the sun does set.";

        HashMap<String,Integer> wordsCount = countWords(paragraph);
        System.out.println("*****************************************************");
        for (HashMap.Entry<String,Integer> word: wordsCount.entrySet()) {
            System.out.printf("%s - %s%n",word.getKey(),word.getValue());
        }
        System.out.println("*****************************************************");
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

    private static String translateWord(String word) {
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

        StringBuilder wordBuilder = new StringBuilder();
        for (String letter : wordArray) {
            wordBuilder.append(letter);
        }
        wordBuilder.append("ay").append(specialHolder);
        return wordBuilder.toString();

    }

    private static String translateSentence(String sentence) {
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

    //    Problem 3
//    site: https://edabit.com/challenge/KnpqDdkibon22Eexa
//    Problem: Roman Numeral Converter
//    Create a function that takes an Arabic number and converts it into a Roman number.
    private static String convertToRoman(int num) {
        String[] romanArray = new String[50];
        String roman;
        int index = 0;
        while (num > 0) {
            if (num >= 1000) {
                roman = "M";
                num -= 1000;
            } else if (num >= 500) {
                roman = "D";
                num -= 500;
            } else if (num >= 100) {
                roman = "C";
                num -= 100;
            } else if (num >= 50) {
                roman = "L";
                num -= 50;
            } else if (num >= 10) {
                roman = "X";
                num -= 10;
            } else {
                switch (num) {
                    case 1:
                        roman = "I";
                        num = 0;
                        break;
                    case 2:
                        roman = "II";
                        num = 0;
                        break;
                    case 3:
                        roman = "III";
                        num = 0;
                        break;
                    case 4:
                        roman = "IV";
                        num = 0;
                        break;
                    case 5:
                        roman = "V";
                        num = 0;
                        break;
                    case 6:
                        roman = "VI";
                        num = 0;
                        break;
                    case 7:
                        roman = "VII";
                        num = 0;
                        break;
                    case 8:
                        roman = "VIII";
                        num = 0;
                        break;
                    case 9:
                        roman = "IX";
                        num = 0;
                        break;
                    default:
                        roman = "";
                        num = 0;
                        break;
                }
            }

            romanArray[index] = roman;
            index++;
        }
        String[] cleanArray = new String[index];
        System.arraycopy(romanArray, 0, cleanArray, 0, cleanArray.length);

        StringBuilder RomanBuilder = new StringBuilder();
        for (String s : cleanArray) {
            RomanBuilder.append(s);
        }

        return RomanBuilder.toString();
    }


    //    Problem 4
//    site: https://edabit.com/challenge/De5e8kdsCFmKvc6w8
//    Problem: Longest Alternating Substring
//    Given a string of digits, return the longest substring with alternating odd/even or even/odd digits.
//    If two or more substrings have the same length, return the substring that occurs first.
    private static String longestSubstring(String str) {
        int[] checker = new int[str.length()];
        ArrayList<String> substrings = new ArrayList<>();
        for (int i = 0; i < checker.length; i++) {
            checker[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        int startCheck = 0;
        int endCheck;
        String previousCheck = "";
        String currentCheck;
        for (int i = 0; i < checker.length; i++) {
            if (checker[i] % 2 == 0) {
                currentCheck = "even";
            } else {
                currentCheck = "odd";
            }
            if (previousCheck.equalsIgnoreCase("")) {
                previousCheck = currentCheck;
                startCheck = i;
            } else if (previousCheck.equalsIgnoreCase(currentCheck)) {
                previousCheck = currentCheck;
                endCheck = i;
                if (endCheck - startCheck != 1) {
                    substrings.add(str.substring(startCheck, endCheck));
                }
                startCheck = i;
            } else {
                if (i + 1 == checker.length) {
                    endCheck = i + 1;
                    substrings.add(str.substring(startCheck, endCheck));
                }
                previousCheck = currentCheck;
            }

        }

        String largest = "";
        for (String sub : substrings) {
            if (largest.length() < sub.length()) {
                largest = sub;
            }
        }

        return largest;
    }

    //    Problem 5
//    site: https://edabit.com/challenge/MLzJD3iHnYZo566nA
//    Problem: Check if the Formula is Correct
//    Create a function that takes a string and returns true or false depending on whether or not
//    the formula is correct.
    private static Boolean formula(String form) {
        String[] formulaSplit = form.split("\\s+");
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<String> conditionals = new ArrayList<>();

        for (String element : formulaSplit) {
//            boolean numeric = true;
            try {
                int num = Integer.parseInt(element);
                values.add(num);
            } catch (NumberFormatException e) {
//                numeric = false;
                if (element.equalsIgnoreCase("=")) {
                    conditionals.add(element);
                } else if (element.equalsIgnoreCase("+")) {
                    conditionals.add(element);
                } else if (element.equalsIgnoreCase("-")) {
                    conditionals.add(element);
                } else if (element.equalsIgnoreCase("*")) {
                    conditionals.add(element);
                } else if (element.equalsIgnoreCase("/")) {
                    conditionals.add(element);
                } else {
                    return false;
                }
            }
        }
        int index = 0;
//        ArrayList<Integer> calc = new ArrayList<>();
        int calculate = 0;
        int reverseEquals = 0;
//        int flipIndex;
        int condIndex = 0;
        boolean reset = false;
        boolean reverse = false;
        ArrayList<Boolean> equals = new ArrayList<>();
        for (String condition : conditionals) {
            if (condition.equalsIgnoreCase("=")) {
//                if (condIndex+1 < conditionals.size()-1 && !conditionals.get(condIndex+1).equalsIgnoreCase("=")){
//
//                }
                if (index == 0) {
                    reverseEquals = values.get(index);
                    reverse = true;
                    reset = true;
                    index++;
                }
                if (!reverse) {

                    equals.add(calculate == values.get(index + 1));
                    reverseEquals = values.get(index + 1);
//                    flipIndex = index+1;
                    index++;
                    if (condIndex != conditionals.size() - 1) {
                        reverse = true;
                        reset = true;
                    }
                } else {
                    calculate = 0;
                    index++;
                }

            } else if (condition.equalsIgnoreCase("+")) {
                if (index == 0 || reset) {
                    calculate = values.get(index) + values.get(index + 1);
                    index++;
                    reset = false;
                } else {
                    calculate += values.get(index + 1);
                    index++;
                }

            } else if (condition.equalsIgnoreCase("-")) {
                if (index == 0 || reset) {
                    calculate = values.get(index) - values.get(index + 1);
                    index++;
                    reset = false;
                } else {
                    calculate -= values.get(index + 1);
                    index++;
                }
            } else if (condition.equalsIgnoreCase("*")) {
                if (index == 0 || reset) {
                    calculate = values.get(index) * values.get(index + 1);
                    index++;
                    reset = false;
                } else {
                    calculate *= values.get(index + 1);
                    index++;
                }
            } else if (condition.equalsIgnoreCase("/")) {
                if (index == 0 || reset) {
                    calculate = values.get(index) / values.get(index + 1);
                    index++;
                    reset = false;
                } else {
                    calculate /= values.get(index + 1);
                    index++;
                }
            } else {
                return false;
            }
            condIndex++;
        }
        if (reverse) {
            equals.add(calculate == reverseEquals);
        }

        for (Boolean formula : equals) {
            if (!formula) {
                return false;
            }
        }
        return true;
    }

//    Problem 1
//    site: N/A
//    Problem: make 3 methods that will take in a string that counts: the number of times each word is used,
//      the number of each vowel is used, the number of times each word starts a sentence.
//    hint: hashmaps, and linklists.
    public static HashMap<String,Integer> countWords(String paragraph){
        HashMap<String,Integer> wordsCount = new HashMap<>();
//        ArrayList<String> wordsSplit = new ArrayList<>();
        String[] words = paragraph.split("\\s+");
        int counter;
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^a-zA-Z0-9]", "");
            words[i] = words[i].toLowerCase();
            if (wordsCount.containsKey(words[i])){
                counter = wordsCount.get(words[i]);
                counter++;
                wordsCount.replace(words[i],counter);
            }else {
                wordsCount.put(words[i],1);
            }
        }
        return wordsCount;
    }

    public static HashMap<String,Integer> countVowels(String paragraph){
        HashMap<String,Integer> vowelsCount = new HashMap<>();
        return vowelsCount;
    }

    public static HashMap<String,Integer> countBeginings(String paragraph){
        HashMap<String,Integer> startCount = new HashMap<>();
        return startCount;
    }







}
