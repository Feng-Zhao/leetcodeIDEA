//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 👍 332 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int upLimit;
    int rightLimit;
    int downLimit;
    int leftLimit;
    int direction = 0;
    int posX = 0, posY = 0;

    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        upLimit = 0;
        rightLimit = matrix[0].length - 1;
        downLimit = matrix.length - 1;
        leftLimit = 0;

        int cur = 0;
        int[] newNums = new int[matrix.length * matrix[0].length];
//        while (inBound()){
        while (cur<newNums.length){
            newNums[cur] = matrix[posX][posY];
            cur++;
            nextPos();
        }
        return newNums;
    }

//    private boolean inBound(){
//        if(upLimit <= downLimit && leftLimit <= rightLimit){
//            return true;
//        }
//        return false;
//    }

    private void nextPos(){
        boolean turnFlag = false;
        // 优化,用enum
        switch (direction){
            // 向右
            case 0:
                if(posY < rightLimit) posY++;
                else {
                    posX++;
                    upLimit++;
                    turnFlag = true;
                }
                break;
            // 向下
            case 1:
                if(posX < downLimit) posX++;
                else{
                    posY--;
                    rightLimit--;
                    turnFlag = true;
                }
                break;
            // 向左
            case 2:
                if(posY > leftLimit) posY--;
                else{
                    posX--;
                    downLimit--;
                    turnFlag = true;
                }
                break;
            // 向上
            case 3:
                if(posX > upLimit) posX--;
                else{
                    posY++;
                    leftLimit++;
                    turnFlag = true;
                }
                break;
        }
        if(turnFlag){
            direction = (direction + 1) % 4;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
