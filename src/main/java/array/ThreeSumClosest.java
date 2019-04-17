package array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * @author Franco_Q
 * @date 2019/4/17 12:07
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int left,right,comp,result = 0;
        if (length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i=0;i<length-2;i++) {
            left = i+1;
            right = length -1;
            while (left < right) {
                comp = nums[i] + nums[left] + nums[right];
                if (Math.abs(comp - target)<min) {
                    min = Math.abs(comp - target);
                    result = comp;
                }
                if (comp > target) {
                    right--;
                }else if (comp < target) {
                    left++;
                }else {
                    return target;
                }
            }
        }
        return result;
    }
}
