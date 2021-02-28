// Project name:JDKStudy
// Creator:muhong
// Date time:2021/2/28,9:37 下午
// Name:FrogStepTest

package jdk.basic;

import org.junit.Test;

/**
 * 青蛙跳台阶
 */
public class FrogStepTest {

    @Test
    public void test() {
        int result = numWays(46);
        System.out.println(result);
    }

    public int numWays(int n) {
        return step(n);
    }

    private int step(int n) {

        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int stepOne = 1;
        int stepTwo = 2;
        int stepResult = 0;
        for (int i = 3; i <= n; i++) {
            stepResult = stepOne + stepTwo;
            stepResult = stepResult % 1000000007;
            stepOne = stepTwo;
            stepTwo = stepResult;
        }
        return stepResult;
    }

}
