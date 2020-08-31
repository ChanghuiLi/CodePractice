package stack;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  栈里面存的不一定要是数组的元素，也可以是数组的下标。
 *  LinkedList的使用方法；
 * */
public class AReviewGetMaxWindow {
    public int[] getmax(int[] nums,int w) {
        if(nums == null||w > nums.length) return null;
        int[] res = new int[nums.length-w+1];
        LinkedList<Integer> q = new LinkedList<Integer>();
        // 初始化状态
        for (int i = 0;i < nums.length; i++) {
            while(!q.isEmpty() && nums[q.getLast()] <= nums[i]){
                q.pollLast();
            }
            q.add(i);
            if (q.peekFirst() == i-w) {
                q.pollFirst();
            }
            if (i >= w-1) {
                res[i-w+1] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}
