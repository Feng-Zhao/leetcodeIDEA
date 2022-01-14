//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 475 👎 0




//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Solution {
    List<String> result = new ArrayList<>();
    char[] path = null;

    public String[] permutation(String s) {
        path = s.toCharArray();
        recur(0);
        String[] res = new String[result.size()];
        return result.toArray(res);
    }

    private void recur(int pos){
        if(pos == path.length-1){
            result.add(String.valueOf(path));
            return;
        }
        Set<Character> added = new HashSet<>();
        for (int i = pos; i < path.length; i++) {
            if(added.contains(path[i])){
                continue;
            }
            added.add(path[i]);
            swap(path,pos,i);
            recur(pos+1);
            swap(path,pos,i);
        }
    }
    private void swap(char[] str,int fixPos,int swapPos){
        char temp = str[fixPos];
        str[fixPos] = str[swapPos];
        str[swapPos] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
