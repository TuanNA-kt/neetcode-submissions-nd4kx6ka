# Definition for a pair.
# class Pair:
#     def __init__(self, key: int, value: str):
#         self.key = key
#         self.value = value
class Solution:
    def merge(self, pairs: List[Pair], s, m, e):
        L = pairs[s : m + 1]
        R = pairs[m + 1 : e + 1]
        i, j, k = 0, 0, s
        l = len(L)
        r = len(R)
        while(i < l and j < r):
            if(L[i].key <= R[j].key):
                pairs[k] = L[i]
                i += 1
                k += 1
            else:
                pairs[k] = R[j]
                j += 1
                k += 1
        while(i < l):
            pairs[k] = L[i]
            i += 1
            k += 1
        while(j < r):
            pairs[k] = R[j]
            j += 1
            k += 1

    def mergeSortHelper(self, pairs: List[Pair], s, e) -> List[Pair]:
        if(e - s + 1) <= 1:
            return pairs
    
        m = (e + s) // 2
      
        self.mergeSortHelper(pairs, s, m)
        self.mergeSortHelper(pairs, m + 1, e)
        self.merge(pairs, s, m, e)

        return pairs

    def mergeSort(self, pairs: List[Pair]) -> List[Pair]:
        return self.mergeSortHelper(pairs, 0, len(pairs) - 1)
