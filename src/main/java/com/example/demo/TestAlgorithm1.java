package com.example.demo;

public class TestAlgorithm1 {

    static int[] arrays = {1,2,3,4,5,6,7,4,5,2,3,4,8,9,10};
    static int x = 10;

    public static void main(String[] args) {

        for (int startIndex = 0;
             startIndex < arrays.length / 2 + 1;
             startIndex ++) {

            for (int endIndex = startIndex + 1;
                 endIndex < arrays.length;
                 endIndex ++) {

                check(startIndex, endIndex);
            }
        }


    }

    private static void check(int startIndex, int endIndex) {
        if (arrays[startIndex] + arrays[endIndex] == x) {
            System.out.println(startIndex + ":" + arrays[startIndex] + "->" + endIndex + ":" + arrays[endIndex]);
        }
    }
}
