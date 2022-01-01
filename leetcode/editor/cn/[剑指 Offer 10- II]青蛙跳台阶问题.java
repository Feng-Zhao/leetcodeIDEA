//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 216 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
// 类似于 斐波那契数列问题 F(n) = F(n-1) + F(n-2)
class Solution {
    private static final int MOD = 1000000007;
    public int numWays(int n) {
        // 递归 Time Limit Exceeded
//        switch (n){
//            case 0:
//            case 1: return 1;
//            case 2: return 2;
//            default: return ( numWays(n-1) % MOD + numWays(n-2) % MOD) % MOD;
//        }
        switch (n) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            default:
            {
                int sum = 0;
                int a = 1;
                int b = 2;
                for (int i = 2; i < n; i++) {
                    sum = (a % MOD + b % MOD) % MOD;
                    a = b;
                    b = sum;
                }
                return sum;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
