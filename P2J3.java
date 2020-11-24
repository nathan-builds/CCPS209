/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab0Cdone;

import java.util.LinkedList;

/**
 *
 * @author n.hans
 */
public class P2J3 {

    public static void reverseAscendingSubarrays(int[] items) {

        LinkedList<Integer> tempList = new LinkedList();
        LinkedList<Integer> finalList = new LinkedList();
        int previous = items[0];
        tempList.add(previous);
        for (int i = 1; i < items.length; i++) {
            int current = items[i];
            if (current > previous) {
                tempList.add(current);

            } else {

                for (int j = tempList.size() - 1; j >= 0; j--) {
                    int num = tempList.get(j);
                    finalList.add(num);
                }
                tempList.clear();
                tempList.add(current);
                previous = current;
            }
        }

        for (int j = tempList.size() - 1; j >= 0; j--) {
            int num = tempList.get(j);
            finalList.add(num);
        }
        int counter = 0;
        for (Integer n : finalList) {
            items[counter] = n;
            counter += 1;
        }

    }

    public static String reverseVowels(String text) {

        LinkedList<String> vowels = new LinkedList();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");
        vowels.add("A");
        vowels.add("E");
        vowels.add("I");
        vowels.add("O");
        vowels.add("U");

        LinkedList<Character> vowelsInText = new LinkedList();
        String finalAnswer = "";

        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);
            if (vowels.contains(String.valueOf(c))) {
                vowelsInText.add(c);
            }
        }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (vowels.contains(String.valueOf(c))) {
                char lastVowel = vowelsInText.getLast();
                if (Character.isUpperCase(lastVowel)) {
                    finalAnswer += String.valueOf(Character.toUpperCase(lastVowel));
                } else {
                    finalAnswer += String.valueOf(Character.toLowerCase(lastVowel));
                }

                vowelsInText.removeLast();

            } else {
                if (Character.isUpperCase(c)) {
                    finalAnswer += String.valueOf(Character.toUpperCase(c));
                } else {
                    finalAnswer += String.valueOf(Character.toLowerCase(c));
                }

            }
        }
        return finalAnswer;
    }

    public static String pancakeScramble(String text) {

        int substring = 2;  
        StringBuilder mainText = new StringBuilder(text);
        for (int i = 0; i < text.length() - 1; i++) {
            String reversePart = mainText.substring(0, substring);
            String safePart = mainText.substring(substring); // believe its inclusive?
            String reversedString = new StringBuilder(reversePart).reverse().toString();
            mainText.delete(0, mainText.length());
            mainText.append(reversedString);
            mainText.append(safePart);
            substring+=1;

        }
        
        return mainText.toString();
    }
    
     

}
