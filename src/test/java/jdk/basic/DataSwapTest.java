package jdk.basic;

import org.junit.Test;

public class DataSwapTest {

    @Test
    public void swapTest(){
        // int swap
        int[] intArray = {10,20};
        swapBasicTypeByValue(intArray[0], intArray[1]);
        System.out.println("a="+intArray[0]+",b="+intArray[1]);
        swapBasicTypeByArray(intArray);
        System.out.println("a="+intArray[0]+",b="+intArray[1]);
        // object swap
        MObject a = new MObject(10);
        MObject b = new MObject(20);
        swapObjectType(a, b);
        System.out.println("Object-a="+a.value+",Object-b="+b.value);

    }

    private void swapBasicTypeByArray(int[] intArray){
        int temp = intArray[0];
        intArray[0] = intArray[1];
        intArray[1] = temp;
    }

    private void swapBasicTypeByValue(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    private void swapObjectType(MObject a, MObject b){
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    private void changeValue(int value){
        value = 1000;
    }

    private void changeObjectValue(MObject object){
        object.value = 10000;
    }

    @Test
    public void changeValueTest(){
        // init
        int intValue = 10;
        MObject object = new MObject(10);
        // change
        changeValue(intValue);
        changeObjectValue(object);
        // print
        System.out.println("intValue="+intValue+",objectValue="+object.value);
    }

    static class MObject{
        int value;
        MObject(int value){
            this.value = value;
        }
    }
}
