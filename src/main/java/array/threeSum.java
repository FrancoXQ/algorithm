package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  三数之和
 *  给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 注意：答案中不可以包含重复的三元组。
 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 * @author Franco_Q
 * @date 2019/4/2 10:17
 */
public class threeSum {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3){
            return ret;
        }
        Arrays.sort(num);
        int len = num.length;
        for (int i = 0;i<len;i++) {
            if (i >0 &&num[i] == num[i-1]) {
                continue;
            }
            //寻找两个数与num[i]的和为0
            find(num,i+1,len-1,num[i]);
        }
        return ret;
    }

    private void find(int[] num, int begin, int end, int target) {
        int l = begin,r = end;
        while (l < r) {
            if (num[l] + num[r] +target == 0) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(target);
                ans.add(num[l]);
                ans.add(num[r]);
                ret.add(ans);
                while(l<r && num[l] == num[l+1]){l++;}
                while(l<r && num[r] == num[r-1]){r++;}
                l++;
                r--;
            }else if (num[l] + num[r] +target<0) {
                l++;
            }else {
                r--;
            }
        }
    }
}
