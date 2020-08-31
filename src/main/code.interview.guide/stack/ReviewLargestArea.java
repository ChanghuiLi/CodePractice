package stack;

import java.util.Stack;
/**
 * 矩形最大面积。---重要的题。
 * 需要注意的点：Stack==null的时候特殊情况处理。
 * 计算的时候需要找到左右两边两个端点。
 * */
public class ReviewLargestArea {
    public static void main(String[] args) {
        int[] nums = {5,4,2,1};
        System.out.println(largestRectangleArea(nums));
    }
    public static int largestRectangleArea(int[] heights) {
        if (heights==null) return 0;
        if (heights.length==1) return heights[0];
        Stack<Integer> s = new Stack<Integer>();
        int res = heights[0];
        int tempres = heights[0];
        s.push(0);
        for(int i = 1;i < heights.length; i++){
            if (s.isEmpty()) {
                s.push(i);
            } else {
                if (heights[s.peek()] <= heights[i]) {
                    s.push(i);
                } else {
                    tempres = findStackArea(s,heights,i);
                    res = Math.max(res,tempres);
                }
            }
        }
        if (!s.isEmpty()) {
            while(!s.isEmpty()){
                int tempvalue = s.pop();
//                res = Math.max(res,heights[tempvalue]);
                if(s.isEmpty()){
                    res = Math.max(res,heights[tempvalue]*(heights.length));
                }else{
                    res = Math.max(res,heights[tempvalue]*(heights.length-s.peek()-1));
                }

            }
        }
        return res;
    }

    private static int findStackArea(Stack<Integer> s, int[] heights, int i) {
        int temp = s.pop();
        int tempres = heights[temp];
        if(s.isEmpty()){
            tempres = Math.max(tempres,heights[temp]*(temp+1));
        }
        while(!s.isEmpty()&&heights[s.peek()] > heights[i]){
            int temp2 = s.pop();
            if(s.isEmpty()){
                tempres = Math.max(tempres,heights[temp2]*(temp+1));
            }else{
                tempres = Math.max(tempres,heights[temp2]*(i-(s.peek()+1)));
            }
        }
        s.push(i);
        return tempres;
    }
}
