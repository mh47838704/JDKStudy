package jdk.basic;

import org.junit.Test;

public class DataSwapTest {

    @Test
    public void swapTest(){
        int[] intArray = {10,20};
        changeValue(intArray[0]);
        swapBasicType(intArray);
        System.out.println("a="+intArray[0]+",b="+intArray[1]);
    }

    private void swapBasicType(int[] intArray){
        int temp = intArray[0];
        intArray[0] = intArray[1];
        intArray[1] = temp;
    }

    private void changeValue(int value){
        value = 1000;
    }
}
