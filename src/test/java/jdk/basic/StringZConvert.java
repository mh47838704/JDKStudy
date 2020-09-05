// Project name:JDKStudy
// Creator:muhong
// Date time:2020/7/10,10:47 下午
// Name:StringZConvert

package jdk.basic;

import org.junit.Test;

public class StringZConvert {

    @Test
    public void testCase1() {
        String result = convert("PAYPALISHIRING", 3);
        System.out.println(result);
    }

    private String convert(String s, int numRows) {
        if (s == null || "".equals(s) || s.length() <= numRows) {
            return s;
        }
        // 初始化每一行的字符串
        String[] rowString = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            rowString[i] = "";
        }
        char[] charArray = s.toCharArray();
        int currentRowNum = 0;
        boolean isDown = true;
        for (char c : charArray) {
            // 优先处理两种边界
            if (currentRowNum + 1 == numRows) {
                isDown = false;
                rowString[currentRowNum] += c;
                if (currentRowNum - 1 >= 0) {
                    currentRowNum--;
                }
                continue;
            }
            if (currentRowNum == 0) {
                isDown = true;
                rowString[currentRowNum] += c;
                if (currentRowNum + 1 < numRows) {
                    currentRowNum++;
                }
                continue;
            }
            // 处理正常的上下移动
            if (isDown) {
                rowString[currentRowNum] += c;
                currentRowNum++;
                continue;
            }
            rowString[currentRowNum] += c;
            currentRowNum--;
        }
        // 整理结果
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(rowString[i]);
        }
        return result.toString();
    }
}
