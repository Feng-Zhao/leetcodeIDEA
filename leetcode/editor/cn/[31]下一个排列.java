//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 👍 1459 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int cur = nums.length - 1;
        int pivot = 0;
        boolean findExchangePos = false;
        // 从右向左扫描 找到一个降序,该位置即为应该交换的位置
        while (!findExchangePos && cur > 0){
            if(nums[cur-1] >= nums[cur]){
                cur--;
            }
            else{
                pivot = cur - 1;
                findExchangePos = true;
            }
        }
        // 当可以实施交换时
        if(findExchangePos){
            // 从右向左找到 比交换位置大的那个数, 这个数就是与交换位置交换的数
            cur = nums.length - 1;
            while (cur > pivot){
                if(nums[cur] > nums[pivot]){
                    int temp = nums[cur];
                    nums[cur] = nums[pivot];
                    nums[pivot] = temp;
                    break;
                }
                cur--;
            }
        }
        // 确定升序排列的范围
        int left = 0;
        int right = nums.length - 1;
        // 如果交换过位置则从交换位置后一个位置开始排升序
        if(findExchangePos){
            left = pivot + 1;
        }
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }


    }

    // 标准编码
//    public void nextPermutation(int[] nums) {
//        int i = nums.length - 2;
//        while (i >= 0 && nums[i] >= nums[i + 1]) {
//            i--;
//        }
//        if (i >= 0) {
//            int j = nums.length - 1;
//            while (j >= 0 && nums[i] >= nums[j]) {
//                j--;
//            }
//            swap(nums, i, j);
//        }
//        reverse(nums, i + 1);
//    }
//
//    public void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//
//    public void reverse(int[] nums, int start) {
//        int left = start, right = nums.length - 1;
//        while (left < right) {
//            swap(nums, left, right);
//            left++;
//            right--;
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
