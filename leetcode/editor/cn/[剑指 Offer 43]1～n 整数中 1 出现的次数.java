//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
//
//
//
// 示例 1：
//
//
//输入：n = 12
//输出：5
//
//
// 示例 2：
//
//
//输入：n = 13
//输出：6
//
//
//
// 限制：
//
//
// 1 <= n < 2^31
//
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/
// Related Topics 递归 数学 动态规划 👍 260 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        int base = 0;
        int count = 0;
        while (n != 0){
            count += n % 10 * base + 1;
            n /= 10;
            base = base * 10 + 1;
        }
        return count;

        Map<Integer,Integer> map = new HashMap<>();
        // todo

    }
}
//leetcode submit region end(Prohibit modification and deletion)
