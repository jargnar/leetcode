import java.util.Stack;

public class MaximalRectangle {
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

    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        int[][] intmatrix = new int[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                intmatrix[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }

        int[] mem = new int[n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                mem[j] = intmatrix[i][j] == 0 ? 0 : mem[j] + intmatrix[i][j];
            }
            maxArea = Math.max(maxArea, largestRectangleArea(mem));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
}
