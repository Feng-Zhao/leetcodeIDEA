//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 150 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        queue.add(root);
        TreeNode cur = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            result.add(cur.val);
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
//        int[] resultArray = new int[result.size()];
//        for (int i = 0; i < result.size(); i++) {
//            resultArray[i] = result.get(i);
//        }
//        return resultArray;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
