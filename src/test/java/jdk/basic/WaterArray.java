// Project name:JDKStudy
// Creator:muhong
// Date time:2020/7/28,11:15 下午
// Name:WaterArray

package jdk.basic;

import org.junit.Test;

import java.util.Stack;

public class WaterArray {

    @Test
    public void test() {
        int[] height = {2,0,2};
        int water = trap(height);
        System.out.println(water);
    }

    public int trap(int[] height) {

        if (height == null || height.length <= 2) {
            return 0;
        }
        int water = 0;
        Stack<Integer> indexStack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            // 为空
            if (indexStack.isEmpty()) {
                indexStack.push(i);
                continue;
            }
            int stackTop = indexStack.peek();
            if (height[i] <= height[stackTop]) {
                // 小于等于push
                    indexStack.push(i);
                continue;
            }
            // 大于计算
            while (!indexStack.isEmpty() && height[indexStack.peek()] < height[i]) {
                int currentMaxIndex = indexStack.pop();
                while (!indexStack.isEmpty() && height[indexStack.peek()] == height[currentMaxIndex]) {
                    // 移除相同的元素
                    indexStack.pop();
                }
                if (indexStack.isEmpty()) {
                    // 当前只有一个元素
                    break;
                }
                int leftIndex = indexStack.peek();
                // 左右的高度的最小值-中间的柱子*（柱子之间的距离）
                water += (Math.min(height[i], height[leftIndex]) - height[currentMaxIndex]) * (i - leftIndex -1);
            }
            indexStack.push(i);
        }
        return water;
    }


}
