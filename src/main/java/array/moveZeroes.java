package array;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 示例:
 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 * @author Franco_Q
 * @date 2019/3/29 11:25
 */
public class moveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        int nonZeroIndex = 0;
        int size = nums.length;
        while(zeroIndex<size && nonZeroIndex<size) {
            while(zeroIndex<size && nums[zeroIndex] != 0) {
                zeroIndex++;
            }
            while (nonZeroIndex < size && (nums[nonZeroIndex] ==0 || nonZeroIndex<zeroIndex)) {
                nonZeroIndex++;
            }
            if (zeroIndex<size && nonZeroIndex<size) {
                nums[zeroIndex++] = nums[nonZeroIndex];
                nums[nonZeroIndex] = 0;
            }
        }
    }
}
