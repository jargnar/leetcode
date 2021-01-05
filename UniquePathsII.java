public class UniquePathsII {
    static boolean isValidSquare(int row, int col, int m, int n, int[][] obstacleGrid) {
        return row < m && col < n && obstacleGrid[row][col] == 0;
    }

    static boolean isAtEnd(int row, int col, int m, int n) {
        return row == m - 1 && col == n - 1;
    }

    static int countPaths(int row, int col, int m, int n, int[][] paths, int[][] obstacleGrid) {
        if(!isValidSquare(row, col, m, n, obstacleGrid)) return 0;
        if(isAtEnd(row, col, m, n)) return 1;
        if(paths[row][col] == 0) {
            int right = countPaths(row + 1, col, m, n, paths, obstacleGrid);
            int down = countPaths(row, col + 1, m, n, paths, obstacleGrid);
            paths[row][col] = right + down;
        }
        return paths[row][col];
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        return countPaths(0, 0, m, n, new int[m][n], obstacleGrid);
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 1}, {0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
