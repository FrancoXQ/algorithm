package array;

/**
 * 有序数组
 * @author Franco_Q
 * @date 2019/3/27 10:31
 */
public class OrderArray {
    private int[] intArray;
    //元素个数
    private int mSize = 0;

    public OrderArray(int length) {
        intArray = new int[length];
    }

    /**
     * 用二分查找定位某个元素，存在返回下标，不存在返回-1
     * @param target
     * @return
     */
    public  int find(int target) {
        int lowerBound = 0;
        int upperBound = intArray.length -1;
        int cruIndex;

        if (upperBound < 0) {
            return -1;
        }

        while (true) {
            cruIndex = (lowerBound + upperBound) / 2;
            if (target == intArray[cruIndex]) {
                return cruIndex;
            }else if (cruIndex == lowerBound) {
                //在当前下标与搜索段的最小下标重合时，代表搜索段中只包含1个或2个元素，
                //如果低位元素和高位元素都不等于目标元素，证明数组中没有该元素，搜索结束
                if (target != intArray[upperBound]) {
                    return -1;
                }
            }else {//搜索段中的元素至少有三个，且当前元素不等于目标元素
                if (target>intArray[cruIndex]) {
                    upperBound = cruIndex;
                }else {
                    lowerBound = cruIndex;
                }
            }
        }
    }

    /**
     * 插入
     */
    public void insert(int element) {
        int location = 0;
        //判断应插入位置的下标
        for (;location<mSize;location++) {
            if (intArray[location] > element) {
                break;
            }
        }
        //将插入下标之后的所有元素后移一位
        for (int i = mSize;i > location ;i--) {
            intArray[i] = intArray[i-1];
        }
        intArray[location] = element;
        mSize++;
    }
    /**
     * 删除
     */
    public boolean delete(int target) {
        int index = -1;
        if ((index = find(target)) != -1) {
            for (int i = index; i<mSize ;i++) {
                intArray[index] = intArray[i+1];
            }
            mSize--;
            return true;
        }else {
            return false;
        }
    }

}
