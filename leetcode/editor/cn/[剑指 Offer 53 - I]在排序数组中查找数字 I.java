//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 👍 250 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int leftPos = find(nums,target,true);
        int rightPos = find(nums,target,false)-1;
        if( leftPos <= rightPos &&
            rightPos < nums.length && leftPos >= 0 &&
            nums[leftPos] == target && nums[rightPos] == target){
            return rightPos - leftPos + 1;
        }
        return 0;
    }

    private int find(int[] nums, int target, boolean flag){
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target || (flag && nums[mid] >= target)){
                right = mid - 1;
                ans = mid;
            }
            else{// num[mid] < target
                left = mid + 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
