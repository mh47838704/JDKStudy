// Project name:JDKStudy
// Creator:muhong
// Date time:2020/7/10,11:32 下午
// Name:IntReverse

package jdk.basic;

import org.junit.Test;

public class IntReverse {

    @Test
    public void testCase1() {
        int result = reverse(-123);
        System.out.println(result);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    private int reverse(int x) {
        // 如果是个位数，那么不需要反转
        if (x < 10 && x > -10) {
            return x;
        }
        // 定义一个30的整型数组，获取整型的每一个数字
        int ARRAY_COUNT = 30;
        int[] numArray = new int[ARRAY_COUNT];
        int index = ARRAY_COUNT - 1;
        while (x >= 10 || x <= -10) { // 直到个位数的时候停止
            numArray[index] = x % 10;
            x = x / 10;
            index--;
        }
        int result = 0;
        numArray[index] = x;
        // 计算值，需要考虑溢出的情况，溢出了返回0
        int j = ARRAY_COUNT - 1;
        while (j >= index) {
            // 判断10的倍数是否溢出
            if (isTimesOutOfRange(numArray[j], j - index)){
                return 0;
            }
            int temp = numArray[j] * getTime(j - index);
            // 判断两个数字之和是否溢出
            if (isSumOutRange(temp, result)){
                return 0;
            }
            result += temp;
            j--;
        }

        return result;
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

    private boolean isSumOutRange(int a, int b){
        if (a < 0 && b < 0){
            int temp = a + b;
            if (temp > a || temp > b){
                return true;
            }
            return false;
        }
        if (a > 0 && b > 0){
            int temp = a + b;
            if (temp < a || temp < b){
                return true;
            }
        }
        return false;
    }

    private boolean isTimesOutOfRange(int num, int times) {

        if (times <= 0) {
            return false;
        }
        int result = 10;
        while (times > 1) {
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
        if (num > 0) {
            return Integer.MAX_VALUE / result < num;
        }
        return false;
    }
}


