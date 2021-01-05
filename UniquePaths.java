public class UniquePaths {
    static boolean isValidSquare(int row, int col, int m, int n) {
        return row < m && col < n;
    }

    static boolean isAtEnd(int row, int col, int m, int n) {
        return row == m - 1 && col == n - 1;
    }

    static int countPaths(int row, int col, int m, int n, int[][] paths) {
        if(!isValidSquare(row, col, m, n)) return 0;
        if(isAtEnd(row, col, m, n)) return 1;
        if(paths[row][col] == 0) {
            int right = countPaths(row + 1, col, m, n, paths);
            int down = countPaths(row, col + 1, m, n, paths);
            paths[row][col] = right + down;
        }
        return paths[row][col];
    }

    public static int uniquePaths(int m, int n) {
        return countPaths(0, 0, m, n, new int[m][n]);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(22, 16));
    }
}
