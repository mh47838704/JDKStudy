package uni.stu.jdk;

public class MyArrayList<E> {


    //定义数组
    private Object[] elementData;
    //定义容量
    private int size;
    //定义常量
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 无参构造函数，定义默认长度为10
     */
    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 定义有参构造函数
     *
     * @param capacity//容量大小
     */
    public MyArrayList(int capacity) {
        elementData = new Object[capacity];
    }

    /**
     * add()方法
     *
     * @param element
     */
    public void add(E element) {
        if (elementData.length > size) {
            return;
        }
        elementData[size++] = element;

    }

    /**
     * 重写toString()方法
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length() - 1, ']');  //替换最后一个,为]

        return sb.toString();
    }


    // 测试
    public static void main(String[] args) {
        MyArrayList s1 = new MyArrayList(10);
        s1.add("aa");
        s1.add("bb");
        s1.add("cc");
        s1.add("aa");
        s1.add("bb");
        s1.add("cc");
        s1.add("aa");
        s1.add("bb");
        s1.add("cc");
        s1.add("aa");
        s1.add("bb");
        s1.add("cc");
        System.out.println(s1);

    }
}

