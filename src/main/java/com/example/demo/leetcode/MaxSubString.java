package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.List;

public class MaxSubString {

//    public static int splitMaxSting(String str){
//       List<String> strings = Arrays.asList(str.split("\\s+"));
//       int max = 0;
//        for (String item: strings) {
//            if (item.length()>max) {
//                max = item.length();
//            }
//        }
//        return max;
//    }

    public static int maxString(String string) {
        int max = 0;
        while (max < string.length()) {
            int k = string.indexOf(" ");
            if (k < 0) {
                // e.g.最后一个子串时候 无空格。或者只有一个子串 k =-1
                return Math.max(max, string.length());
            }
            if (max < string.substring(0, k).length()) {
                max = string.substring(0, k).length();
            }
            string = string.substring(k + 1);
        }
        return max;
    }

    public static int maxString2(String string) {
        int max = 0;
        int index = 0;
        while (index < string.length()) {
            int k = string.indexOf(" ", index);
            if (k < 0) {
                return Math.max(max, string.length() - index);
            }
            max = Math.max(max, k - index);
            index = k + Math.max(max + 2, 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "ab aca c";
        System.out.println(MaxSubString.maxString2(str));
    }
}
