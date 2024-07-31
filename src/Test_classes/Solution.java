/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test_classes;

/**
 *
 * @author Monzur Elahi Shamim
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        
        if (needleLength > haystackLength) {
            return -1;
        }

        int needleHash = computeHash(needle);
        int haystackHash = computeHash(haystack.substring(0, needleLength));

        for (int i = 0; i <= haystackLength - needleLength; i++) {
            if (needleHash == haystackHash && haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }

            if (i < haystackLength - needleLength) {
                haystackHash = rollingHash(haystackHash, haystack.charAt(i), haystack.charAt(i + needleLength));
            }
        }
        return -1;
    }

    private int computeHash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += s.charAt(i);
        }
        return hash;
    }

    private int rollingHash(int oldHash, char oldChar, char newChar) {
        return oldHash - oldChar + newChar;
    }
}

