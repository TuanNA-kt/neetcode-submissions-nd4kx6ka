class UnionFind:
    def __init__(self, n):
        self.par = {}
        self.rank = {}

        for i in range(0, n):
            self.par[i] = i
            self.rank[i] = 1;
    
    def find(self, i):
        if self.par[i] != i:
            self.par[i] = self.find(self.par[i])
        return self.par[i]
    
    def union(self, p1, p2):
        p1, p2 = self.find(p1), self.find(p2)
        if p1 == p2:
            return False
        if self.rank[p1] < self.rank[p2]:
            self.par[p1] = p2
        elif self.rank[p1] > self.rank[p2]:
            self.par[p2] = p1
        else:
            self.par[p2] = p1
            self.rank[p1] += 1
        return True

class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        emailToAccIndex = {}
        uf = UnionFind(len(accounts))

        for i, a in enumerate(accounts):
            for e in a[1:]:
                if e in emailToAccIndex:
                    uf.union(i, emailToAccIndex[e])
                else:
                    emailToAccIndex[e] = i

        indexToEmailGroup = defaultdict(list)
        for e, i in emailToAccIndex.items():
            leader = uf.find(i)
            indexToEmailGroup[leader].append(e)
        
        res = []

        for i, emails in indexToEmailGroup.items():
            res.append([accounts[i][0]] + sorted(emails))
        
        return res
        
        