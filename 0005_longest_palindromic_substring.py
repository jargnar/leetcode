class Solution:
    def expand(self, s: str, l: int, r: int) -> (int, int, int):
        if not s or l > r: return (0, 0)
        while (l >= 0 and r < len(s) and s[l] == s[r]):
            l, r = l - 1, r + 1
        return l, r, r - l

    def longestPalindrome(self, s: str) -> str:
        if not s: return ""
        start, end = 0, 0
        for i, _ in enumerate(s):
            l1, r1, d1 = self.expand(s, i, i)
            l2, r2, d2 = self.expand(s, i, i+1)
            l, r = (l1, r1) if d1 > d2 else (l2, r2)
            if (r - l) > (end - start):
                start, end = l, r
        
        return s[start+1:end]
