//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 👍 337 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 剪绳子, 最佳解为 3 最多的分割方式
    // m1+m2+m3+...mm=n
    // m1*m2*m3*...mm 求极值
    // 使用 算术几何均值不等式 推到
    public int cuttingRope(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int result = 0;
        switch (n % 3){
            case 0: result = (int)Math.pow(3,n/3);break;
            case 1: result = (int)Math.pow(3,n/3 - 1) * 4;break;
            case 2: result = (int)Math.pow(3,n/3) * 2;break;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
