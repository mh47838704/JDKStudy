// Project name:JDKStudy
// Creator:muhong
// Date time:2021/1/24,9:42 下午
// Name:MinArrayTest

package math.simple;

import org.junit.Test;

public class MinArrayTest {

    @Test
    public void test() {

    }

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int minValue = numbers[0];
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            if (minValue > numbers[i]){
                minValue = numbers[i];
            }
        }
        return minValue;
    }
}
