package uni.stu.jdk;

/*
 **简单的ArrayList，实现add()方法
 */
public class MyArrayList<E> {

    private static final Object[] EMPTY_ELEMENTDATA = {};//定义空的数组
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
     * @param capacity 容量大小
     */
    public MyArrayList(int capacity) {
        if (capacity > 0) {
            elementData = new Object[capacity];
        } else if (capacity == 0) {
            elementData = EMPTY_ELEMENTDATA;
        } else throw new IllegalArgumentException("Illegal Capacity: " +
                capacity);
    }

    /**
     * add()方法
     *
     * @param element 定义元素
     */
    public void add(E element) {
        if (size >= elementData.length) {
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

    // 测试用例
    public static void main(String[] args) {
        MyArrayList s1 = new MyArrayList(10);
        s1.add("aa");
        s1.add("aa");
        s1.add("aa");
        s1.add("aa");
        s1.add("aa");
        s1.add("aa");
        s1.add("aa");
        s1.add("aa");
        s1.add("aa");
        s1.add("aa");
        s1.add("aa");
        s1.add("aa");
        System.out.println(s1);
    }
}

