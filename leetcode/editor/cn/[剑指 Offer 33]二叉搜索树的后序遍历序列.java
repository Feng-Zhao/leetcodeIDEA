//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 401 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null || postorder.length < 3) return true;
        return check(postorder,postorder.length - 1,0,postorder.length - 1);
    }

    /**
     * 递归检查树是否符合二叉搜索树后序遍历
     * @param nums 树 数组
     * @param rootPos 根 位置
     * @param startPos 树开始位置
     * @param endPos 树结束位置
     * @return boolean
     */
    private boolean check(int[] nums, int rootPos, int startPos, int endPos){
        if(startPos >= endPos){
            return true;
        }
        int pivotPos = startPos;
        // 找到左右子树分界点 pivotPos 为右子树开始
        while (pivotPos < endPos && nums[pivotPos] < nums[rootPos]){
            pivotPos++;
        }
        // 若右子树有比根节点小的节点, 则不符合后序遍历, 返回 false;
        for (int i = pivotPos + 1; i < endPos; i++) {
            if(nums[i] < nums[rootPos]){
                return false;
            }
        }
        return check(nums,pivotPos-1,startPos,pivotPos-1)
                &&
                check(nums,endPos-1,pivotPos,endPos-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
