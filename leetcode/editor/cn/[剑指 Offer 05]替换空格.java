//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 177 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        if(s == null || s == ""){
            return s;
        }
        // String行为调用
        // 实际为模式匹配方式的一种实例, 其他模式匹配算法也能做到
        // 大致有 KMP(根据模式串计算滑动位置), BM(右对齐,右->左扫描,遇坏字符向右滑动)
        // 其他基于 BM 的改进算法 BMH,BMHS
        return s.replace(" ","%20");
        // 其他方式: Regexp 匹配替换
    }
}
//leetcode submit region end(Prohibit modification and deletion)
