//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 342 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 堆排序
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            heapfy(arr,i,arr.length);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[0];
            swap(arr,0,arr.length-1-i);
            heapfy(arr,0, arr.length-1-i);
        }
        return res;
    }

    void heapfy(int[] arr, int pos, int len){
        int min = pos;
        if(pos*2+1 < len && arr[min] > arr[pos*2+1]){
            min = pos*2+1;
        }
        if(pos*2+2 < len && arr[min] > arr[pos*2+2]){
            min = pos*2+2;
        }
        if(min != pos){
            swap(arr,min,pos);
            heapfy(arr,min,len);
        }
    }
    void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
