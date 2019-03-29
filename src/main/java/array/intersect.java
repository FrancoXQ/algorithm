package array;

import java.util.Arrays;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 示例 1:
 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 输出: [2,2]
 * @author Franco_Q
 * @date 2019/3/29 10:26
 */
public class intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length < nums2.length ? nums1.length : nums2.length];
        int i = 0,j = 0, k=0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res[k] = nums1[i];
                i++;
                j++;
                k++;
            }else if (nums1[i] < nums2[j]) {
                i++;
            }else {
                j++;
            }
        }
        return Arrays.copyOfRange(res,0,k);
    }
}
