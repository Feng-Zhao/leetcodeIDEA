//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 458 👎 0


import sun.font.DelegatingShape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
// 回溯算法 1.做选择 2.递归 3.恢复现场
//boolean 递归(){
//    if(成功){
//        return true;
//    }
//    for(选择:所有选择){
//    实施选择;
//    if(递归){
//        return true;
//    }
//    恢复现场
//    }
//    return false;
//}
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
//                    List<Tuple> checked = new ArrayList<>();
//                    checked.add(new Tuple(i, j, board[0].length));
                    char temp = board[i][j];
                    board[i][j] = '0';
                    if (
                            search(
                                    board,
                                    Arrays.copyOfRange(word.toCharArray(), 1, word.length()),
                                    i,
                                    j
                            )
                    ) {
                        Object o = new Object();
                        return true;
                    }
                    board[i][j] = temp;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, char[] word, int lastX, int lastY) {
        if (word == null || word.length == 0) {
            return true;
        }

        int row = board.length - 1;
        int col = board[0].length - 1;

        // right
        if (lastY < col && board[lastX][lastY + 1] == word[0]) {
            char temp = board[lastX][lastY + 1];
            board[lastX][lastY + 1] = '0';

            if (search(
                    board,
                    Arrays.copyOfRange(word, 1, word.length),
                    lastX,
                    lastY + 1
            )
            ) {
                return true;
            }
            board[lastX][lastY + 1] = temp;
        }

        // down
        if (lastX < row && board[lastX + 1][lastY] == word[0]) {
            char temp = board[lastX + 1][lastY];
            board[lastX + 1][lastY] = '0';

            if (search(
                    board,
                    Arrays.copyOfRange(word, 1, word.length),
                    lastX + 1,
                    lastY
            )
            ) {
                return true;
            }
            board[lastX + 1][lastY] = temp;
        }

        // left
        if (lastY > 0 && board[lastX][lastY - 1] == word[0]) {
            char temp = board[lastX][lastY - 1];
            board[lastX][lastY - 1] = '0';

            if (search(
                    board,
                    Arrays.copyOfRange(word, 1, word.length),
                    lastX,
                    lastY - 1
            )
            ) {
                return true;
            }
            board[lastX][lastY - 1] = temp;
        }

        // up
        if (lastX > 0 && board[lastX - 1][lastY] == word[0]) {
            char temp = board[lastX - 1][lastY];
            board[lastX - 1][lastY] = '0';

            if (search(
                    board,
                    Arrays.copyOfRange(word, 1, word.length),
                    lastX - 1,
                    lastY
            )
            ) {
                return true;
            }
            board[lastX - 1][lastY] = temp;
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
