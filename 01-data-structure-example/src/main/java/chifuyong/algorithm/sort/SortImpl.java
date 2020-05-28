package chifuyong.algorithm.sort;

/**
 * 排序算法实现
 *
 * @date： 2020/5/28
 * @author: chify
 */
public class SortImpl {

    public static void main(String[] args) {
        int [] array = {3,1,9,4,2222,231,212123,16,44,50,34,23};

        System.out.println("排序前：");
        printArray(array);
        System.out.println();
        System.out.println("排序后");
        //冒泡排序
//        array = bubbleSort(array);
        //选择排序
        array = selectSort(array);
        printArray(array);

    }

    /**
     * 选择排序
     * 简单直观的排序算法，无论什么数据进去都是 O(n²) 的时间复杂度。所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
     * @param array 未排序数组（int 类型）
     * @return 排好序数组
     */
    public static int[] selectSort(int[] array){
        int minIndex,temp;
        for(int i = 0; i < array.length - 1 ; i++ ){
            //先假定第一个为最小
            minIndex = i;
            for (int j = i + 1; j < array.length; j++ ){
                if (array[j] < array[minIndex]){
                    //从头开始遍历，遇到更小的，则记录其数组
                    minIndex = j;
                }
            }
            //交换最小值得位置
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }


    /**
     * 冒泡排序
     * 从第一位开始，相邻两个数两两比较，大的放后面，每循环一次，会筛选出一个最大值。
     * @param array 未排序数组（int类型）
     * @return 排序后数组
     */
    public static int[] bubbleSort(int [] array){
        int temp;
        //需要比较 array.length -1 次
        for (int i = 0; i < array.length -1 ; i ++){
            // j 的范围要求，array.length - i 之后再 -1 ，否则 array[j+1] 会发生越界异常
            for (int j = 0; j < array.length - i -1 ; j++){
                if(array[j] > array[j+1]){
                    //相邻两个数做比较，大的放后面
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 打印数组
     * @param array
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

}
