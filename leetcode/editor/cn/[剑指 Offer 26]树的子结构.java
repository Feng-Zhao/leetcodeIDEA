//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 深度优先搜索 二叉树 👍 424 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 遍历A所有节点 先序遍历, 广度优先
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null)
                && (checkEquals(A, B) ||
                isSubStructure(A.left, B) ||
                isSubStructure(A.right, B));
    }

    // 比对树结构 先序遍历 深度优先
    boolean checkEquals(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if(A.val != B.val){
            return false;
        }
        return checkEquals(A.left, B.left) && checkEquals(A.right, B.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
