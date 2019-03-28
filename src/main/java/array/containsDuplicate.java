package array;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * @author Franco_Q
 * @date 2019/3/28 10:10
 */
public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length ==0) {
            return false;
        }
        final HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
