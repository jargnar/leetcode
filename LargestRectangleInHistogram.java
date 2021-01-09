import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < heights.length; ++i) {
            int start = i;
            while (!stack.empty() && stack.peek()[1] > heights[i]) {
                int[] ih = stack.pop();
                maxArea = Math.max(maxArea, ih[1] * (i - ih[0]));
                start = ih[0];
            }
            stack.push(new int[]{start, heights[i]});
        }
        while(!stack.empty()) {
            int[] ih = stack.pop();
            maxArea = Math.max(maxArea, ih[1] * (heights.length - ih[0]));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,4}));
    }
}
