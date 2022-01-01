//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 0 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 👍 181 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        boolean oddFind = false;
        boolean evenFind = false;
        while (left < right){
            if(nums[left] % 2 == 0){
                evenFind = true;
            }
            else{
                left++;
            }
            if(nums[right] % 2 != 0){
                oddFind = true;
            }
            else{
                right--;
            }
            if(oddFind && evenFind){
                swap(nums, left, right);
                left++;
                right--;
                oddFind = false;
                evenFind = false;
            }
        }
        return nums;
    }
    void swap(int[] nums, int from, int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
