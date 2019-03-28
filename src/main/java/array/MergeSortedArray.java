package array;

/**
 * 合并两个有序数组
 * @author Franco_Q
 * @date 2019/3/28 9:40
 */
public class MergeSortedArray {
    public int[] mergeSortedArray(int[] array1, int m, int[] array2,int n) {
        int[] newArray = new int[m + n];
        int i =0,j=0,count=0;
        while (i<m && j<n) {
            if (array1[i]<array2[j]) {
                newArray[count++] = array1[i++];
            }else {
                newArray[count++] = array2[j++];
            }
        }
        if (i >=m) {
            while (j<n) {
                newArray[count++] = array2[j++];
            }
        }
        if (j >=n) {
            while (i<m) {
                newArray[count++] = array1[i++];
            }
        }
        return newArray;
    }
}
