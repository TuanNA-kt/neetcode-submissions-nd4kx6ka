class UnionFind:
    def __init__(self, n):
        self.par = [i for i in range(n)]
        self.rank = [1] * n

    def find(self, i):
        if self.par[i] != i:
            self.par[i] = self.find(self.par[i])
        return self.par[i]

    def union(self, a, b):
        pa = self.find(a)
        pb = self.find(b)

        if pa == pb:
            return False

        if self.rank[pa] > self.rank[pb]:
            self.par[pb] = pa
        elif self.rank[pa] < self.rank[pb]:
            self.par[pa] = pb
        else:
            self.par[pb] = pa
            self.rank[pa] += 1

        return True

class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        components = n
        uf = UnionFind(n)

        for (u, v) in edges:
            if uf.union(u, v):
                components -= 1

        return components