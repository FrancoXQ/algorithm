package array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 eg:
 给定数组 nums = [1,1,2],
 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 你不需要考虑数组中超出新长度后面的元素。
 * @author Franco_Q
 * @date 2019/3/26 11:33
 */
public class removeDuplicates {
    public int removeDuplicats (int[] nums) {
        int currIndex = 0;
        int moveIndex = 1;
        while(moveIndex<nums.length) {
            while(moveIndex < nums.length && nums[currIndex] == nums[moveIndex]) {
                moveIndex++;
            }
            if (moveIndex < nums.length) {
                nums[currIndex+1] = nums[moveIndex];
                currIndex++;
                moveIndex++;
            }
        }
        return currIndex+1;
    }
}
