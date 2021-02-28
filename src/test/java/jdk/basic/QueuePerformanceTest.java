// Project name:JDKStudy
// Creator:muhong
// Date time:2021/2/28,10:05 下午
// Name:QueuePerformaceTest

package jdk.basic;

import org.junit.Test;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 */
public class QueuePerformanceTest {
    @Test
    public void test() {
        MaxQueue q = new MaxQueue();
        int v = q.pop_front();
        System.out.println(v);
        q.push_back(1);
        q.push_back(3);
        q.push_back(2);
        v = q.max_value();
        System.out.println(v);
        v = q.pop_front();
        v = q.pop_front();
        System.out.println(v);
        v = q.max_value();
        System.out.println(v);
    }
}

class MaxQueue {

    int DEFAULT_SIZE = 10001;

    int queueSize;
    int[] queueArray;
    int head = 0;
    int tail = 0;
    // 最大值优化
    int maxValue;
    int maxValueCount = 0;

    public MaxQueue() {
        this.queueSize = DEFAULT_SIZE;
        this.initQueue();
    }

    private void initQueue() {
        this.queueArray = new int[this.queueSize];
    }

    public int max_value() {
        if (isEmpty()) {
            return -1;
        }
        if (this.maxValueCount > 0) {
            return this.maxValue;
        }
        // 最大值未知，需要重新计算
        this.reCountMaxValue();
        return this.maxValue;
    }

    public void push_back(int value) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("queue is full");
        }
        this.queueArray[this.tail] = value;
        this.tail = (this.tail + 1) % this.queueSize;
        // 最大值优化(如果pop出去的值等于最大值，那么需要将数量-1)
        if (value > this.maxValue) {
            this.maxValue = value;
            this.maxValueCount = 1;
        } else if (value == this.maxValue) {
            this.maxValueCount += 1;
        }
    }

    public int pop_front() {
        if (isEmpty()) {
            return -1;
        }
        int result = this.queueArray[this.head];
        this.head = (this.head + 1) % this.queueSize;
        // 最大值缓存刷新
        if (result == this.maxValue) {
            this.maxValueCount -= 1;
        }
        return result;
    }

    private boolean isFull() {
        return (this.tail + 1) % this.queueSize == this.head;
    }

    private boolean isEmpty() {
        return this.tail == this.head;
    }

    private void reCountMaxValue() {
        int tempHead = head;
        //
        this.maxValue = this.queueArray[tempHead];
        this.maxValueCount = 1;
        while ((tempHead + 1) % this.queueSize != this.tail) {
            tempHead = (tempHead + 1) % this.queueSize;
            int nextValue = this.queueArray[tempHead];
            if (nextValue == this.maxValue) {
                this.maxValueCount += 1;
            } else if (nextValue > this.maxValue) {
                this.maxValue = nextValue;
                this.maxValueCount = 1;
            }
        }
    }
}


