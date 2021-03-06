package uni.stu.jdk;

public class Add {

    private Object[]  elementData;

    private int  size;

    private static final int DEFALT_CAPACITY = 10 ;

    /**
     * 无参构造函数，定义默认长度为10
     */
    public Add(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    /**
     * 定义有参构造函数
     *  @param capacity
     */
    public Add(int  capacity) {
        elementData  = new Object[capacity];
    }

    /**
     * add()方法
     *  @param element
     */
    public  void  add(Object  element){
        elementData[size++] = element;
    }

    /**
     * 重写toString()方法
     */
    public String toString() {

        StringBuilder  sb = new StringBuilder();

        sb.append("[");
        for(int i=0; i<size ;i++){
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1, ']');  //替换最后一个,为]

        return  sb.toString();
    }
//
    // 测试
    public static void main(String[] args) {
        Add  s1 = new Add(20);
        s1.add("aa");
        s1.add("bb");
        s1.add("cc");
        System.out.println(s1);

    }
}
