public class ClimbingStairs {
    public static int fib(int n, int[] cache) {
        if(n <= 2) return n;
        if(cache[n-1] == 0 && cache[n-2] == 0) {
            cache[n-1] = fib(n-1, cache);
            cache[n-2] = fib(n-2, cache);
        }
        return cache[n-1] + cache[n-2];
    }

    public static int climbStairs(int n) {
        return fib(n, new int[n]);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }
}
