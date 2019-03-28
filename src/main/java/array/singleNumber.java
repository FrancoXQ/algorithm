package array;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @author Franco_Q
 * @date 2019/3/28 10:37
 */
public class singleNumber {
    //相同的数字经过异或运算后结果为0
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int num = 0;
        for (int i=0;i<nums.length;i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
