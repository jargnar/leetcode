public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        if ( grid == null || grid.length == 0 ) return 0;

        int[][] paths = new int[grid.length][grid[0].length];

        for(int i = 0; i < paths.length; ++i) {
            for(int j = 0; j < paths[i].length; ++j) {
                paths[i][j] += grid[i][j];
                if (i > 0 && j > 0) {
                    paths[i][j] += Math.min(paths[i - 1][j], paths[i][j - 1]);
                } else if (i > 0) {
                    paths[i][j] += paths[i - 1][j];
                } else if (j > 0) {
                    paths[i][j] += paths[i][j - 1];
                }
            }
        }

        return paths[paths.length - 1][paths[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
