class Solution:
    def __init__(self):
        self.cache = {}

    def paths(self, i: int, j: int, m: int, n: int) -> int:
        if (i + 1 == n) and (j + 1 == m):
            self.cache[(i, j)] = 1
            return 1
        elif i == n or j == m:
            self.cache[(i, j)] = 1
            return 0

        left = self.cache.get((i, j + 1), None)
        if not left:
            left = self.paths(i, j + 1, m, n)
            self.cache[(i, j + 1)] = left

        right = self.cache.get((i + 1, j), None)
        if not right:
            right = self.paths(i + 1, j, m, n)
            self.cache[(i + 1, j)] = right

        return left + right

    def uniquePaths(self, m: int, n: int) -> int:
        return self.paths(0, 0, m, n)
