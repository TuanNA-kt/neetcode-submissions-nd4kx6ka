// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSortHelper(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    private void quickSortHelper(List<Pair> pairs, int s, int e) {
        if(s >= e) {
            return;
        }

        int pivot = e;
        int i = s;
        Pair temp = null;

        for(int j = s; j < e; j++) {
            if(pairs.get(j).key < pairs.get(pivot).key) {
                // temp = pairs[i];
                // pairs[i] = pairs[j];
                // pairs[j] = temp;
            
                swap(pairs, i, j);
                i++;
            }
        }

        // temp = pairs.get(i);
        // pairs.set(i, pairs.get(pivot));
        // pairs.set(pivot, temp);
        swap(pairs, i, pivot);

        quickSortHelper(pairs, s, i - 1);
        quickSortHelper(pairs, i + 1, e);
    }

    private void swap(List<Pair> pairs, int index1, int index2) {
        Pair temp = null;
        temp = pairs.get(index1);
        pairs.set(index1, pairs.get(index2));
        pairs.set(index2, temp);
    }
}
