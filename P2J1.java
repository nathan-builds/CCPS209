/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab0Adone;

import java.lang.reflect.Array;
import java.util.LinkedList;

/**
 *
 * @author n.hans
 */
public class P2J1 {

    public static long fallingPower(int n, int k) {
        LinkedList<Long> numsToMultiplyList = new LinkedList();
        for (long count = k; count > 0; count--) {
            numsToMultiplyList.add((long) n);
            n--;
        }
        long total = numsToMultiplyList.removeFirst();
        for (Long num : numsToMultiplyList) {
            total = total * num;
        }
        return total;
    }

    public static int[] everyOther(int[] arr) {

        if (arr.length == 0) {
            return arr;
        }

        double arrLength = (double) arr.length;
        double length2 = arrLength / 2; // double must be divided by double to get correct answer
        double ceil = Math.ceil(length2); // taking ceiling here gives number of even element positions that will be in the array, I'm counting 0 as even, may need to change this
        int arraySize = (int) ceil;
        int[] answer = new int[arraySize];
        int j = 0;
        for (int i = 0; i <= arr.length; i++) {
            if (i % 2 == 0) {
                answer[j] = arr[i];
            }
        }
        return answer;

    }

    public static int[][] createZigZag(int rows, int cols, int start) {
        int[][] answer = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    answer[i][j] = start;
                    start += 1;
                }
            } else {
                for (int j = cols - 1; j >= 0; j--) {
                    answer[i][j] = start;
                    start += 1;
                }
            }
        }

        return answer;
    }
    
    public static int countInversions(int[] arr){
        
        int inversionCount =0;
        
        for(int i =0; i<arr.length;i++){
            for(int j= i+1; j<arr.length;j++){ // start at +1 of i to go through the rest of the array after i 
                if(arr[i]>arr[j]){
                    inversionCount++;
                }
            }
        }
        return inversionCount;
    }

}
