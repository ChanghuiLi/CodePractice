package list;

import java.util.Stack;

public class LargestArea {
    public int largestRectangleArea(int[] heights) {
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
            int tempvalue = s.peek();
            tempres =0;
        }
        return res;
    }

    private int findStackArea(Stack<Integer> s, int[] heights, int i) {
        return 0;
    }
}
