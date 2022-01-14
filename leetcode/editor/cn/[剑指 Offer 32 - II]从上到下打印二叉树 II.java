//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-
//traversal/ 
// Related Topics 树 广度优先搜索 二叉树 👍 167 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        boolean q1flag = true;
        TreeNode cur = null;
        while(!queue1.isEmpty() || !queue2.isEmpty()){
            List<Integer> line = new ArrayList<>();
            if(q1flag){
                while (!queue1.isEmpty()){
                    cur = queue1.poll();
                    line.add(cur.val);
                    if(cur.left != null) queue2.offer(cur.left);
                    if(cur.right != null) queue2.offer(cur.right);
                }
                q1flag = false;
            }
            else{
                while (!queue2.isEmpty()){
                    cur = queue2.poll();
                    line.add(cur.val);
                    if(cur.left != null) queue1.offer(cur.left);
                    if(cur.right != null) queue1.offer(cur.right);
                }
                q1flag = true;
            }
            result.add(line);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
