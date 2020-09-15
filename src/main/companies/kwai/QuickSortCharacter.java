package kwai;

import java.util.List;

import static java.util.Collections.swap;

public class QuickSortCharacter {
    public static void main(String[] args) {
        String[] str = {"bas","csd","asd"};
        String[] res = Solution(str);
        for (int i = 0; i < res.length; i++){
            System.out.println(res[i] +" ");
        }
    }
    public static String[] Solution(String[] str) {
        quickSort(str,0, str.length-1);
        return str;
    }

    private static void quickSort(String[] str, int start2, int end2) {
        if (start2 >= end2) {
            return;
        }
        int start = start2;
        int end = end2;
        int pivot = start;
        // 交换位置到pivot
        while (start < end) {
            while(start < end && str[start].compareTo(str[pivot]) <= 0) {
                start++;
            }
            while(start < end && str[pivot].compareTo(str[end]) <= 0) {
                end --;
            }
            if (start < end){
                swap2(str, start, end);
                start++;
                end--;
            }
        }
        // 下一次递归迭代
        swap2(str,pivot,end);
        quickSort(str,start2,end-1);
        quickSort(str,end+1,end2);
    }

    private static void swap2(String[] str, int start, int end) {
        String temp = str[start];
        str[start] = str[end];
        str[end] = temp;
    }
}
