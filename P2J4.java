/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab0Ddone;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import lab11done.Primes;

/**
 *
 * @author n.hans
 */
public class P2J4 {

    public static void main(String[] args) {
//        List<Integer> l = new LinkedList();
//        l.add(4);
//        l.add(99999);
//        l.add(2);
//        l.add(2);
//        l.add(99999);
//        l.add(4);
//        l.add(4);
//        l.add(4);
//        sortByElementFrequency(l);

        factorFactorial(100000);

    }

    public static List<Integer> runningMedianOfThree(List<Integer> items) {
        LinkedList<Integer> answerList = new LinkedList();
        int beginningOfThree = 0;
        int endOfThree = 3;
        answerList.add(items.get(0));
        answerList.add(items.get(1));
        while (endOfThree <= items.size()) { // this will be a problem
            List<Integer> tempList = new LinkedList();
            List<Integer> theThreeNums = items.subList(beginningOfThree, endOfThree);
            for (Integer n : theThreeNums) { // otherwise they reference the same list items and get rearranged there as well lol
                tempList.add(n);
            }
            Collections.sort(tempList);
            answerList.add(tempList.get(1));// thats the medidan
            beginningOfThree++;
            endOfThree++;
        }
        return answerList;
    }

    public static int firstMissingPositive(List<Integer> items) {

        if (items.size() < 1) {
            return 0;

        }

        int val = 1;
        Collections.sort(items);
        for (Integer n : items) {
            if (n == val) {
                val += 1;
            } else {
                return val;
            }
        }

        return 0;
    }

    public static void sortByElementFrequency(List<Integer> items) {

        HashMap<Integer, Integer> nums = new HashMap();
        for (Integer n : items) {
            if (nums.containsKey(n)) {
                nums.put(n, nums.get(n) + 1);
            } else {
                nums.put(n, 1);
            }
        }
        Compare c = new Compare(nums);
        Collections.sort(items, c);
    }

    private static class Compare implements Comparator<Integer> {

        HashMap<Integer, Integer> jValues = new HashMap();

        public Compare(HashMap<Integer, Integer> values) {
            jValues = values;
        }

        @Override
        public int compare(Integer a, Integer b) {
            if (jValues.get(a).equals(jValues.get(b))) {
                return a.compareTo(b);
            }
            return jValues.get(b) - jValues.get(a);
        }

    }

    public static List<Integer> factorFactorial(int n) {

        List<Integer> answer = new LinkedList();
        int currentProduct = 1;
        int multiplier = 2;
        while (multiplier <= n) {
            List<Integer> factored = Primes.factorize(multiplier);
            for (Integer num : factored) {
                answer.add(num);
            }
            multiplier += 1;
        }
        Collections.sort(answer);
        return answer;
    }

}
