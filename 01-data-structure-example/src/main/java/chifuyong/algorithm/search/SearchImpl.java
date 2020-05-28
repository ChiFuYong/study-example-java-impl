package chifuyong.algorithm.search;

import chifuyong.algorithm.sort.SortImpl;

/**
 * 查找算法实现
 *
 * @date： 2020/5/28
 * @author: chify
 */
public class SearchImpl {

    public static void main(String[] args) {
        int [] array = {3,1,9,4,2222,231,212123,16,44,50,34,23};
        SortImpl.bubbleSort(array);
        SortImpl.printArray(array);
        //二分查找
        int result = binarySearch(array,0);
        System.out.println("二分查找 result = " + result);
    }

    /**
     * 二分查找
     * @param array 需要已经拍好序的数组
     * @param condition 需要查找的数据
     * @return 返回相应数据的数据坐标，返回 -1 表示无此数据
     */
    public static int binarySearch(int[] array,int condition){
        int low = 0;
        int high = array.length-1;
        int mid = (low + high)/2;
        int temp;
        while (low <= high){
            if (condition == array[mid]){
                return mid;
            }
            if (condition > array[mid]){
                low = mid + 1;
                mid = (low + high)/2;
            }else {
                high = mid -1;
                mid = (low + high)/2;
            }
        }
        //查无此数据
        return -1;
    }


}
