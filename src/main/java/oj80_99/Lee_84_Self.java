package oj80_99;

import util.Stack;

/**
 * 最大面积
 */
public class Lee_84_Self {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++){
            int cur = (i == heights.length)? -1: heights[i];
            while (!stack.empty() && cur <= heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = stack.empty()? i: i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
