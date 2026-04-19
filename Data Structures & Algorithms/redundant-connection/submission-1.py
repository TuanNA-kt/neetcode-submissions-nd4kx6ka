class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        union = UnionFind(len(edges))
        for u, v in edges:
            if not union.union(u, v):
                return [u,v]
        
class UnionFind:
    def __init__(self, n):
        self.rank = {}
        self.parent = {}

        for i in range(1, n + 1):
            self.rank[i] = 1
            self.parent[i] = i

    def find(self, i):
        if(self.parent[i] != i):
            self.parent[i] = self.find(self.parent[i])
        
        return self.parent[i]

    def union(self, n1, n2):
        p1, p2 = self.find(n1), self.find(n2)

        if p1 == p2:
            return False
        
        if self.rank[p1] > self.rank[p2]:
            self.parent[p2] = p1
        elif self.rank[p1] < self.rank[p2]:
            self.parent[p1] = p2
        else:
            self.parent[p2] = p1
            self.rank[p1] += 1
        return True