// Project name:JDKStudy
// Creator:muhong
// Date time:2020/7/17,11:45 下午
// Name:Palindrome

package jdk.basic;

import org.junit.Test;

public class Palindrome {


    @Test
    public void testMethod1() {
//        System.out.println(longestPalindrome("abadcba"));
        System.out.println(isPalindrome(8));
    }

    // 最长回文字符串方法1
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String result = s.charAt(0) + "";
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                String temp = s.substring(i, j + 1);
                if (isHuiWen(temp)) {
                    if (temp.length() > result.length()) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }

    private boolean isHuiWen(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }


    // 最长回文字符串方法2
    public String longestPalindromeMethod2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] p = new boolean[len][len];
        // 单个字符是回文
        for (int i = 0; i < len; i++) {
            p[i][i] = true;
        }
        // 紧邻的两个是回文
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                p[i][i + 1] = true;
                p[i + 1][i] = true;
            }
        }
        // 依次寻找长度为2、3...n的回文
        int step = 1;
        int start = 0, end = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len; j++) {
                if (j + step > len - 1) {
                    break;
                }
                // 回文是对称的，所以 p[j][j+step]=p[j+step][j]
                p[j][j + step] = p[j + 1][j + step - 1] & s.charAt(j) == s.charAt(j + step);
                if (p[j][j + step]) {
                    if (step > start - end) {
                        start = j;
                        end = j + step;
                    }
                }
            }
            // 长度依次增加
            step++;
        }
        return s.substring(start, end + 1);
    }


    // 判断整数是否为回文
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int[] numArray = new int[32];
        int numLen = 0;
        while (x >= 10) {
            numArray[numLen++] = x % 10;
            x = x / 10;
        }
        numArray[numLen++] = x;
        for (int i = 0; i < numLen / 2; i++) {
            if (numArray[i] != numArray[numLen - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
