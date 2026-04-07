class Solution:
    def climbStairs(self, n: int) -> int:
        res = 0
        for i in range (n+1):
            a = i
            b =  (n - a) % 2

            if(a == 0 or a == n):
                if(b == 0):
                    res += 1
            else:
                if(b == 0):
                    res += self.count_arrangements(a, int((n-a)/2))

        return res

    def count_arrangements(self, a, b):
        return math.comb(a + b, a)