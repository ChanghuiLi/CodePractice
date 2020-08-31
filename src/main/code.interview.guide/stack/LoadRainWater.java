package stack;

public class LoadRainWater {
    // 双指针方法
    public int trap(int[] height) {
        if(height.length < 3) return 0;
        int left = 0,right = height.length-1;
        int leftmax = height[left],rightmax = height[right];
        int res = 0;
        while (left < right) {
            if (leftmax < rightmax){
                res += leftmax - height[left++];
                leftmax = Math.max(leftmax,height[left]);
            } else {
                res += rightmax - height[right++];
                rightmax = Math.max(rightmax,height[right]);
            }
        }
        return res;
    }

    // 构建左边和右边最大数组
    public int trap2(int[] height) {
        if (height.length < 3) return 0;
        int[] rightmax = new int[height.length];
        int righttempmax = 0;
        int lefttempMax = height[0];
        int res = 0;
        for(int i = height.length-1;i >= 0; i--){
            righttempmax = Math.max(height[i],righttempmax);
            rightmax[i] = righttempmax;
        }
        for(int i = 1; i <height.length-1; i++){
            lefttempMax = Math.max(height[i],lefttempMax);
            if(height[i] < Math.min(lefttempMax,rightmax[i])){
                res += (Math.min(lefttempMax,rightmax[i])-height[i]);
            }
        }
        return res;

    }
}
