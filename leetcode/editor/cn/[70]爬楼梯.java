//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2034 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // private static final int MOD = 1000000007;

    public int climbStairs(int n) {
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
                    // sum = (a % MOD + b % MOD) % MOD;
                    sum = a + b;
                    a = b;
                    b = sum;
                }
                return sum;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
