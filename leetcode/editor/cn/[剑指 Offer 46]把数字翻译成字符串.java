//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 348 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        char[] numStrArr = String.valueOf(num).toCharArray();
        if(numStrArr.length <= 1) {return 1;}
        int[] dp = new int[numStrArr.length];
        Arrays.fill(dp,1);

        int prePos = 0;
        int curPos = 1;
        while (curPos < dp.length) {
            if(check(numStrArr[prePos],numStrArr[curPos])){
                dp[curPos] = (prePos-1 < 0 ? 1 : dp[prePos-1]) + dp[prePos];
            }
            else{
                dp[curPos] = dp[curPos-1];
            }
            prePos++;
            curPos++;
        }
        return dp[dp.length-1];
    }

    private boolean check(char preC, char curC){
        if(preC == '1'){
            return true;
        }
        if(preC == '2' && curC < '6'){
            return true;
        }
        return false;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
