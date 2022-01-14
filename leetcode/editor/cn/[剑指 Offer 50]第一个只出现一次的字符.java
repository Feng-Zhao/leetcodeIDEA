//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 👍 171 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),Integer.MAX_VALUE);
            }
            else{
                map.put(s.charAt(i),i);
            }
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character,Integer> e: map.entrySet()) {
            if(e.getValue() < min){
                min = e.getValue();
            }
        }
        return min == Integer.MAX_VALUE ? ' ' : s.charAt(min);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
