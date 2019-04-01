package array;

import java.util.Arrays;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 给定 nums = [2, 7, 11, 15], target = 9
 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 * @author Franco_Q
 * @date 2019/4/1 11:48
 */
public class twoSum {
    public int[] two(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] original = new int[nums.length];
        for (int i = 0; i<nums.length; i++) {
            original[i] = nums[i];
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length -1;
        int num1 = -1;
        int num2 = -1;
        while(start != end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                num1 = nums[start];
                num2 = nums[end];
                break;
            }else if (sum < target) {
                start++;
            }else {
                end--;
            }
        }

        int[] rst = new  int[2];
        rst[0] = -1;
        rst[1] = -1;
        for (int i =0; i< original.length;i++) {
            if (original[i] == num1 || original[i] == num2) {
                if (rst[0] == -1) {
                    rst[0] = i;
                }else {
                    rst[1] = i;
                    break;
                }
            }
        }
        return rst;
    }
}
