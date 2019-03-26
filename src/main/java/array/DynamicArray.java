package array;

/**
 * 动态数组
 * @author Franco_Q
 * @date 2019/3/26 10:33
 */
public class DynamicArray<T> {
    private T[] mArray;

    /**
     * 数组中元素个数
     */
    private int mSize;

    public DynamicArray(int length) {
        mArray = (T[]) new Object[length];
    }

    public DynamicArray() {
        //默认数组的长度为10
        this(10);
    }

    /**
     * 获取数组长度
     * @return
     */
    public int length() {
        return mArray.length;
    }

    /**
     * 获取数组中元素个数
     * @return
     */
    public int getSize() {
        return mSize;
    }

    /**
     * 判断数组中元素是否为空
     * @return
     */
    public boolean isEmpty() {
        return mSize == 0;
    }

    /**
     * 在指定位置添加元素
     * @param index 添加到数组中的位置
     * @param element 需要添加的元素
     */
    public void add(int index, T element) {
        //step 1 判断添加位置的合法性
        //因为数组的元素添加是连贯性的，所以不可能大于当前数组中的元素的个数
        if (index<0 || index>mSize) {
            throw new IllegalArgumentException("添加失败，添加位置不能负数以及不能大于当前数组元数个数");
        }
        // step 2 当数组无空间后，再添加元素时需要进行扩容
        if (mSize == mArray.length) {
            resize(2 * mArray.length);
        }
        //step 3 添加元素时，先把数组中从最后一个到index位置的元素向后移动
        for (int i = mSize -1 ; i >= index;i--) {
            mArray[i +1] = mArray[i];
        }
        //step 4 最后将index的位置赋值新插入的值
        mArray[index] = element;
        //step 5 数组元素个数加1
        mSize++;
    }

    /**
     * 对原数组进行扩容
     * @param newLength 扩容后的长度
     */
    private void resize(int newLength) {
        T[] newArray = (T[]) new Object[newLength];
        //将旧数组元素拷贝到扩容后的数组中
        for (int i = 0;i<mSize;i++) {
            newArray[i] = mArray[i];
        }
        mArray = newArray;
    }
    public void addFirst(T element) {
        add(0, element);
    }

    public void addLast(T element) {
        add(mSize, element);
    }

    /**
     * 删除指定位置的元素
     * @param index 被删除元素的索引
     * @return 被删除的元素
     */
    public T delete(int index) {
        //step 1 参数合法性判断
        if (index < 0 || index >mSize) {
            throw  new IllegalArgumentException("删除失败，删除的元素位置不能负数以及不能大于当前数组元数个数");
        }
        //step 2 根据索引记录被删除的元素并返回
        T ret = mArray[index];
        //step 3 将index之后的元素到最后一个元素向前移动
        for (int i = index +1;i<mSize;i++) {
            mArray[i-1] = mArray[i];
        }
        //step 4 数组元素减一
        mSize--;
        //step 5 将未删除元素的原数组最后一个位置置位null
        mArray[mSize] = null;
        // step 6 添加元素时，若是对数组进行了扩容，为了不浪费内存空间，
        // 当删除了一定量的元素后，需要对数组进行缩容
        // 缩容缩到什么时候为止了？当mArray.length为1时就没有必要继续缩容了
        if (mSize == mArray.length/4 && mArray.length /2 != 0) {
            resize(mArray.length / 2);
        }
        return ret;
    }
    public T deleteFirst() {
        return delete(0);
    }

    public T deleteLast() {
        return delete(mSize - 1);
    }
    /**
     * 修改指定位置的元素
     *
     * @param index
     * @param element
     */
    public void update(int index, T element) {

        // 参数合法性判断
        if (index < 0 || index > mSize) {

            throw new IllegalArgumentException("修改失败，修改的元素位置不能负数以及不能大于当前数组元数个数");
        }
        mArray[index] = element;
    }
    /**
     * 获取指定位置的元素
     *
     * @param index
     * @return
     */
    public T findElement(int index) {

        // 参数合法性判断
        if (index < 0 || index > mSize) {

            throw new IllegalArgumentException("查找失败，查找的元素位置不能为负数以及不能大于当前数组元数个数");
        }
        return mArray[index];

    }

    /**
     * 获取指定元素的位置
     *
     * @param element
     * @return -1 表示不存在
     */
    public int findIndex(T element) {

        for (int i = 0; i < mSize; i++) {

            if (mArray[i].equals(element)) {

                return i;
            }
        }
        return -1;
    }

    /**
     * 查看数组中是否包含指定元素
     *
     * @param element
     * @return
     */
    public boolean contains(T element) {

        for (int i = 0; i < mSize; i++) {

            if (mArray[i].equals(element)) {

                return true;
            }
        }
        return false;
    }
    /**
     * 删除指定元素
     *
     * @param element
     */
    public void deleteElement(T element) {

        int index = findIndex(element);
        if (index != -1) {

            delete(index);
        }
    }
    /**
     * addLast(e)          不需要移动任何元素，时间复杂度为O(1)；
     addFirst(e)         需向后移动n个元素，时间复杂度为O(n)；
     add(index,e)        当index越小时，向后移动的元素越多，反之，则越少。所以平均来说是n/2，去掉常数，也就是时间复杂度为O(n)
     deleteLast(e)               O(1)
     deleteFirst(e)              O(n)
     deleteElement(e)            O(n)
     delete(index,e)             O(n/2) = O(n)
     最坏情况下的时间复杂度为：      O(n)
     update(index,e)             O(1)
     findElement(index)          O(1)
     findIndex(e)                O(n)
     contains(e)                 0(n)
     最坏情况下的时间复杂度为：      O(n)
     */
}
