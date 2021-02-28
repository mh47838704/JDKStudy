// Project name:JDKStudy
// Creator:muhong
// Date time:2021/1/24,9:54 下午
// Name:StringArrayExist

package math.simple;

import com.sun.tools.javac.util.ArrayUtils;
import org.junit.Test;
import sun.security.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringArrayExistTest {

    @Test
    public void test() {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = {{'a','b'}};
        String word = "ba";
        System.out.println(exist(board, word));

    }

    public boolean exist(char[][] board, String word) {
        if (word == null || "".equals(word)) {
            return true;
        }
        // 检查数组中元素个数是否足够(如果是自己的函数还需要对数组进行更加详细的检查)
        int wordLen = word.length();
        int rows = board.length;
        int columns = board[0].length;
        if ((rows * columns) < wordLen) {
            return false;
        }
//        int[][] elementExist = new int[rows][columns];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                for (int k = 0; k < wordLen; k++) {
//                    if (board[i][j] == word.charAt(k)) {
//                        elementExist[i][j] = 1;
//                        break;
//                    }
//                }
//            }
//        }
        //
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int[][] stepArray = new int[rows][columns];
                boolean result = isContain(board, word, i, j, 0, stepArray);
                if (result) {
                    return true;
                }
            }
        }
        System.out.println("no");
        return false;
    }

    private boolean isContain(char[][] board, String word,
                              int currentRow, int currentColumn, int wordIndex,
                              int[][] stepArray) {
        // 待匹配的字符
        char wordChar = word.charAt(wordIndex);
        char boardChar = board[currentRow][currentColumn];
        if (boardChar != wordChar) {
            return false;
        }
        // 标记
        stepArray[currentRow][currentColumn] = 1;
        if (wordIndex + 1 == word.length()) {
            return true;
        }
        // 四个方向匹配
        if (currentRow - 1 >= 0 && stepArray[currentRow - 1][currentColumn] == 0
                && (wordIndex + 1) < word.length()) {
            // 上
            int[][] nextStepArray = Arrays.copyOf(stepArray, stepArray.length);
            boolean result = isContain(board, word,
                    currentRow - 1, currentColumn, wordIndex + 1, nextStepArray);
            if (result) {
                return true;
            }
        }
        if (currentColumn + 1 < board[0].length && stepArray[currentRow][currentColumn + 1] == 0
                && (wordIndex + 1) < word.length()) {
            // 右
            int[][] nextStepArray = Arrays.copyOf(stepArray, stepArray.length);
            boolean result =  isContain(board, word,
                    currentRow, currentColumn + 1, wordIndex + 1, nextStepArray);
            if (result) {
                return true;
            }
        }
        if (currentRow + 1 < board.length && stepArray[currentRow + 1][currentColumn] == 0
                && (wordIndex + 1) < word.length()) {
            // 下
            int[][] nextStepArray = Arrays.copyOf(stepArray, stepArray.length);
            boolean result = isContain(board, word,
                    currentRow + 1, currentColumn, wordIndex + 1, nextStepArray);
            if (result) {
                return true;
            }
        }
        if (currentColumn - 1 >= 0 && stepArray[currentRow][currentColumn - 1] == 0
                && (wordIndex + 1) < word.length()) {
            // 左
            int[][] nextStepArray = Arrays.copyOf(stepArray, stepArray.length);
            return isContain(board, word,
                    currentRow, currentColumn - 1, wordIndex + 1, nextStepArray);
        }

        return false;
    }

}
