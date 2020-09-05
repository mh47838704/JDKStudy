// Project name:JDKStudy
// Creator:muhong
// Date time:2020/7/15,11:40 下午
// Name:StringToInt

package jdk.basic;

import org.junit.Test;

public class StringToInt {

    @Test
    public void test() {
        System.out.println(myAtoi("   10522545459"));
//        System.out.println(myAtoi(" -123"));
//        System.out.println(myAtoi("   -42"));
//        System.out.println(myAtoi("4193 with words"));
//        System.out.println(myAtoi("words and 987"));
//        System.out.println(myAtoi("-91283472332"));
    }

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        String trimStr = str.trim();
        System.out.println(trimStr);
        if (trimStr.length() <= 0) {
            return 0;
        }
        // 变量准备
        char[] inputArray = trimStr.toCharArray();
        int[] outputArray = new int[inputArray.length];
        int index = 0;
        int numCount = 0;
        boolean isPlus = true;
        // 判断首字符
        if (!isSign(inputArray[index]) && !isNum(inputArray[index])) {
            return 0;
        }
        if (isMinusSign(inputArray[index])) {
            isPlus = false;
        }
        if (isSign(inputArray[index])) {
            index++;
        }

        // 过滤数字
        int charBasic = 48;
        while (index < inputArray.length) {
            if (!isNum(inputArray[index])) {
                break;
            }
            outputArray[numCount] = inputArray[index] - charBasic;
            numCount++;
            index++;
        }
        // 计算结果
        return countResult(outputArray, numCount, isPlus);
    }

    private int countResult(int[] resultArray, int numCount, boolean isPlus) {
        if (numCount <= 0) {
            return 0;
        }
        int minusSign = -1;
        if (isPlus) {
            minusSign = 1;
        }
        int index = 0;
        int result = 0;
        while (index < numCount) {
            // 判断10的倍数是否溢出，通过最大数字/当前数<10
            int times = numCount - index - 1;
            int signNum = minusSign * resultArray[index];
            if (isTimesOutOfRange(signNum, times)) {
                if (isPlus) {
                    return Integer.MAX_VALUE;
                }
                return Integer.MIN_VALUE;
            }
            int temp = signNum * getTime(times);
            // 判断两个数字之和是否溢出
            if (isSumOutRange(temp, result)) {
                if (isPlus) {
                    return Integer.MAX_VALUE;
                }
                return Integer.MIN_VALUE;
            }
            result += temp;
            index++;
        }
        return result;
    }

    private boolean isSign(char c) {
        return c == '-' || c == '+';
    }

    private boolean isMinusSign(char c) {
        return c == '-';
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isTimesOutOfRange(int num, int times) {

        if (times <= 0 || num == 0) {
            return false;
        }
        int result = 10;
        while (times > 1) {
            // 判断正负的情况下，相乘是否溢出
            if (num < 0) {
                if (Integer.MIN_VALUE / result > -10) {
                    return true;
                }
            } else {
                if (Integer.MAX_VALUE / result < 10) {
                    return true;
                }
            }
            int temp = result * 10;
            // 如果temp < result 说明倍数溢出
            if (temp < result) {
                return true;
            }
            times--;
            result *= 10;
        }
        // 判断正负的情况下，相乘是否溢出
        if (num < 0) {
            return Integer.MIN_VALUE / result > num;
        }
        return Integer.MAX_VALUE / result < num;
    }

    private int getTime(int n) {
        if (n <= 0) {
            return 1;
        }
        int result = 10;
        while (n > 1) {
            result *= 10;
            n--;
        }
        return result;
    }

    private boolean isSumOutRange(int a, int b) {
        if (a < 0 && b < 0) {
            int temp = a + b;
            if (temp > a || temp > b) {
                return true;
            }
            return false;
        }
        if (a > 0 && b > 0) {
            int temp = a + b;
            if (temp < a || temp < b) {
                return true;
            }
        }
        return false;
    }
}

