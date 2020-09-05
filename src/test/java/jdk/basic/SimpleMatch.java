// Project name:JDKStudy
// Creator:muhong
// Date time:2020/7/18,12:21 上午
// Name:SimpleMatch

package jdk.basic;

import org.junit.Test;

public class SimpleMatch {

    @Test
    public void test() {
//        System.out.println(isMatch("aa", "aa"));
//        System.out.println(isMatch("aa", "a."));
//        System.out.println(isMatch("aa", "a*"));
//        System.out.println(isMatch("aaa", "a*"));
//        System.out.println(isMatch("abc", ".*"));
//        System.out.println(isMatch("abc", "b*abc"));
//        System.out.println(isMatch("aaa", "a*b"));
//        System.out.println(isMatch("abc", "a*bc"));
//        System.out.println(isMatch("abcd", "a.*"));
//        System.out.println(isMatch("abc", ".bc"));
//        System.out.println(isMatch("abc", "abc****"));
//        System.out.println(isMatch("abc", "a*"));
//        System.out.println(isMatch("aab", "c*a*b"));
        //"aaaaaaaaaaaaab"
        //"a*a*a*a*a*a*a*a*a*a*c"
        System.out.println(isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
//        System.out.println(isMatch("mississippi", "mis*is*p*."));
//        System.out.println(isMatch("sippi", "s*p*"));
//"mississippi"
//"mis*is*p*."
//        System.out.println(isMatch("aaa", "a*a"));
//        System.out.println(isMatch("aaa", "a*aa"));
//        System.out.println(isMatch("aaa", "a*a"));
//        System.out.println(isMatch("aaaab", "a*ab"));
//        System.out.println(isMatch("aaab", "a*ab"));
//        System.out.println(isMatch("aaa", "a*aaa"));
//        System.out.println(isMatch("aaa", "a*aaaa"));
//        System.out.println(isMatch("aaa", "a*aaaa"));
//        System.out.println(isMatch("aaa", "aaabc"));
//        System.out.println(isMatch("abb", "a*bb"));

    }

    public boolean isMatch(String s, String p) {
        String dot = ".";
        String star = "*";
        if (s == null) {
            return p == null;
        }
        if (p == null) {
            return false;
        }
        if (s.equals(p)) {
            return true;
        }
        if (!p.contains(dot) && !p.contains(star)) {
            return false;
        }
        int pi = 0;
        int si = 0;
        for (; si < s.length(); ) {
            // 长度已经不够
            if (pi >= p.length()) {
                return false;
            }
            // 字符相同
            char sc = s.charAt(si);
            char pc = p.charAt(pi);
            if (sc == pc || pc == '.') {
                // 无后续字符
                if (pi + 1 >= p.length()) {
                    si++;
                    pi++;
                    continue;
                }
                // 有后续字符
                char nextPChar = p.charAt(pi + 1);
                if (nextPChar != '*') {
                    si++;
                    pi++;
                    continue;
                }
                // 0/1
                if (pi + 2 < p.length()) {
                    if (si + 1 < s.length()) {
                        boolean result1 = isMatch(s.substring(si + 1), p.substring(pi + 2));
                        System.out.println("result1:" + s.substring(si + 1) + "," + p.substring(pi + 2) + "," + result1);
                        if (result1) {
                            return true;
                        }
                    }
                    boolean result0 = isMatch(s.substring(si), p.substring(pi + 2));
                    System.out.println("result0:" + s.substring(si) + "," + p.substring(pi + 2) + "," + result0);
                    if (result0) {
                        return true;
                    }
                }
                if (si + 1 >= s.length()) {
                    si++;
                    continue;
                }
                // n
                boolean resultN = isMatch(s.substring(si + 1), p.substring(pi));
                System.out.println("resultN:" + s.substring(si + 1) + "," + p.substring(pi) + "," + resultN);
                return resultN;
            }
            // ===========不相同
            // 无后续字符
            if (pi + 1 > p.length()) {
                si++;
                pi++;
                continue;
            }
            // 有后续字符
            char nextPChar = p.charAt(pi + 1);
            if (nextPChar != '*') {
                return false;
            }
            if (pi + 2 >= p.length()) {
                pi = pi + 2;
                continue;
            }
            boolean resultOnly = isMatch(s.substring(si), p.substring(pi + 2));
            System.out.println("resultOnly:" + s.substring(si) + "," + p.substring(pi + 2) + "," + resultOnly);
            return resultOnly;
        }
        System.out.println("result:" + si + "," + pi);
        // 判断后续的p的字符串是否为自匹配
        if (pi >= p.length()) {
            return true;
        }
        // 必须全部为*，或者是与*前面的一个字符完全一致
        for (; pi < p.length(); ) {
            char temp = p.charAt(pi);
            if (temp == '*') {
                pi++;
                continue;
            }
            if (pi + 1 >= p.length()) {
                return false;
            }
            if (p.charAt(pi + 1) != '*') {
                return false;
            }
            pi += 2;
        }
        return true;
    }

    @Test
    public void testSub() {
        System.out.println("aaa".substring(0));
        System.out.println(solution2("", ".*"));
    }


    public boolean solution2(String s, String p) {
        // 提前校验
        String dot = ".";
        String star = "*";
        if (s == null) {
            return p == null;
        }
        if (p == null) {
            return false;
        }
        if (s.equals(p)) {
            return true;
        }
        if (!p.contains(dot) && !p.contains(star)) {
            return false;
        }
        // 开始匹配
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] matchResult = new boolean[sLen + 1][pLen + 1];
        matchResult[0][0] = true;
        // 开始计算
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) { // 从1开始，是因为匹配串可以自解释，如a*，.*等
                if (p.charAt(j - 1) == '*') {
                    // 前面没有元素，那么不匹配
                    if (j - 2 < 0) {
                        continue;
                    }
                    // 匹配0次
                    matchResult[i][j] = matchResult[i][j - 2];
                    // 匹配n次，如果当前被匹配串没有元素，那么不匹配
                    if (i - 1 < 0) {
                        continue;
                    }
                    // 匹配n次，消减递归匹配
                    if (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) {
                        matchResult[i][j] = matchResult[i][j] || matchResult[i - 1][j];
                    }
                } else if (p.charAt(j - 1) == '.') {
                    // 被匹配串没有元素，无法匹配
                    if (i - 1 < 0) {
                        continue;
                    }
                    // 与前一个匹配相等
                    matchResult[i][j] = matchResult[i - 1][j - 1];
                } else {
                    // 被匹配串没有元素，无法匹配
                    if (i - 1 < 0) {
                        continue;
                    }
                    // 当前索引元素相等
                    if (p.charAt(j - 1) == s.charAt(i - 1)) {
                        matchResult[i][j] = matchResult[i - 1][j - 1];
                    }
                }
            }
        }
        return matchResult[sLen][pLen];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    @Test
    public void testSub2() {
        System.out.println("aaa".substring(0));
        System.out.println(solution3("aab", "c*a*b*"));
    }


    public boolean solution3(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        if (p.length() != 0) dp[0][1] = false;
        int i = 0, j = 0;
        //初始化dp数组行
        for (i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*') dp[0][i + 1] = dp[0][i - 1];
            else dp[0][i + 1] = false;
        }
        //初始化dp数组列
        for (i = 0; i < s.length(); i++) {
            dp[i + 1][0] = false;
        }
        //开始dp
        for (i = 0; i < s.length(); i++) {
            for (j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(j) == '*') {
                    // 只有一个*
                    if (j - 1 < 0) {
                        continue;
                    }
                    if (p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j - 1];
                    } else {
                        if (s.charAt(i) != p.charAt(j - 1)) {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        } else {
                            dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j - 1];
                        }
                    }
                } else {
                    if (p.charAt(j) == s.charAt(i)) dp[i + 1][j + 1] = dp[i][j];
                    else dp[i + 1][j + 1] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
