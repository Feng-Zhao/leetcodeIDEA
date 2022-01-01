//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-
//sorted-array-ii/ 
// Related Topics 数组 二分查找 👍 450 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid = 0;
        // 实际为要找右半边的第一个元素
        while(left < right){
            mid = left + (right - left) / 2;
            // mid < right 说明 mid 在右半边, 令 right = mid
            if(numbers[mid] < numbers[right]){
                right = mid;
            }
            // mid > right 说明mid处于左半边 令 left = mid + 1
            else if(numbers[mid] > numbers[right]){
                left = mid+1;
            }
            // 相等时, 不能断定mid处于左半边还是右半边, 把 right 向左慢慢推进
            else{
                right--;
            }
        }
        return  numbers[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
