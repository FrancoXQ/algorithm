package array;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 输入: [1,2,3,4,5,6,7] 和 k = 3
 输出: [5,6,7,1,2,3,4]
 解释:
 向右旋转 1 步: [7,1,2,3,4,5,6]
 向右旋转 2 步: [6,7,1,2,3,4,5]
 向右旋转 3 步: [5,6,7,1,2,3,4]

 * @author Franco_Q
 * @date 2019/3/27 11:27
 */
public class RotateArray {
    public void rotate(int[] nums ,int k) {
        if (nums == null || nums.length == 0 || k%nums.length == 0) {
            return;
        }
        int truns = k%nums.length;
        int middle = nums.length - truns;
        reverse(nums, 0, middle-1); // reverse left part
        reverse(nums, middle, nums.length-1); // reverse right part
        reverse(nums, 0, nums.length-1); // reverse whole part
    }
    public void reverse(int[] arr, int s, int e){
        while(s < e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}
