//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 👍 1579 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() < 2){
            return 0;
        }
        int[] dp = new int[s.length()];
        int max = 0;
        int curCount = 0;
        for (int i = 1; i < s.length(); i++) {
            curCount = 0;
            // 右括号匹配
            if(s.charAt(i) == ')' && (i - dp[i-1] - 1) >= 0 && s.charAt(i - dp[i-1] - 1) == '('){
                curCount += 2;// 基础长度为2
                curCount += dp[i-1]; // 括号内长度
                if(i-dp[i-1]-2 >= 0){
                    curCount += dp[i-dp[i-1]-2];
                }
                dp[i] = curCount;
                if(curCount > max){
                    max = curCount;
                }
            }
            // 右括号不匹配, 或者左括号直接赋值0
            else {
                dp[i] = 0;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
