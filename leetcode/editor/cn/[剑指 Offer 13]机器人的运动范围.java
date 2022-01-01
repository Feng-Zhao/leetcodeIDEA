//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 388 👎 0


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        if (k == 0){
            return 1;
        }
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        return 1 + bfs(1,0,visited,k) + bfs(0,1,visited,k);
    }
    // 广度优先 每个节点访问其下方和右侧的节点
    private int bfs(int x, int y, boolean[][]visited, int k){
        if(x >= visited.length || y >= visited[0].length){
            return 0;
        }
        else if(visited[x][y]){
            return 0;
        }
        else if(outOfK(x,y,k)){
            return 0;
        }
        else{
            return 1 + bfs(x+1,y,visited,k) + bfs(x,y+1,visited,k);
        }
    }

    private boolean outOfK(int x, int y, int k){
        int sum = 0;
        while(x != 0){
            sum += x % 10;
            x = x / 10;
        }
        while (y != 0){
            sum += y % 10;
            y = y / 10;
        }
        if(sum > k){
            return true;
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
