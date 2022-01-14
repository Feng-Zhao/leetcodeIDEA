//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 348 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.equals("")) return 0;

        int[] dp = new int[s.length()];
        int max = 1;
        dp[0] = 1;
        Map<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        for (int i = 1; i < s.length(); i++) {
//            System.out.println("j-i="+(i - map.getOrDefault(s.charAt(i),-1)));
//            System.out.println("dp[i-1]="+dp[i-1]);
            if(i - map.getOrDefault(s.charAt(i),-1) <= dp[i-1] ){
                dp[i] = i - map.getOrDefault(s.charAt(i),-1);
            }
            else{
                dp[i] = dp[i-1]+1;
            }
//            System.out.println("put("+s.charAt(i)+","+i+")");
            map.put(s.charAt(i),i);
            if(dp[i] > max){
                max = dp[i];
            }
        }
//        System.out.println("===========");
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(dp[i]);
//        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
