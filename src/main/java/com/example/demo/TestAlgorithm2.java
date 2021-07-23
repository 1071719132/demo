package com.example.demo;

public class TestAlgorithm2 {

    static int[] arrays = {1,2,3,4,5,6,7,4,5,2,3,4,8,9,10};
    static int x = 4;

    static int currentSum = 0;
    static int currentStartIndex = 0;

    public static void main(String[] args) {

        for (int startIndex = 0; startIndex <= arrays.length -x; startIndex++) {
            check(startIndex);

        }

        System.out.println(currentStartIndex + ">>>>>>" + currentSum);

    }

    private static void check(int startIndex) {
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += arrays[startIndex + i];
        }

        System.out.println(startIndex + "------" + sum);

        if (currentSum < sum) {
            currentSum = sum;
            currentStartIndex = startIndex;
        }
    }
}
