# Definition for a pair.
# class Pair:
#     def __init__(self, key: int, value: str):
#         self.key = key
#         self.value = value
import copy
class Solution:
    def insertionSort(self, pairs: List[Pair]) -> List[List[Pair]]:
        res_pairs: List[List[Pair]] = []

        if pairs:
            res_pairs.append(pairs[:])

        if(len(pairs) <= 1):
            return res_pairs

        for i in range(1, len(pairs)):
            j = i - 1
            if(pairs[i].key < pairs[j].key):
                temp = pairs[i]
                pairs[i] = pairs[j]
                pairs[j] = temp
                ##res_pairs.append(pairs[:])
                while(j > 0):
                    if(pairs[j].key < pairs[j-1].key):
                        temp = pairs[j]
                        pairs[j] = pairs[j-1]
                        pairs[j-1] = temp
                    j -= 1
            res_pairs.append(pairs[:])

        return res_pairs