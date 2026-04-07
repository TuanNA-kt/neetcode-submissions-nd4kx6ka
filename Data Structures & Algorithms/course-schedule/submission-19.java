class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            map.computeIfAbsent(course, k -> new ArrayList<Integer>()).add(prerequisite[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();

        for(int i = 0; i < numCourses; i++) {
            if(map.containsKey(i)) {
                if(learn(i, map, visited, visiting) == false) return false;
            }
        }

        return true;
    }

    private boolean learn(int course, Map<Integer, List<Integer>> map, 
        Set<Integer> visited, Set<Integer> visiting) {
            if(visiting.contains(course)) return false;

            if(visited.contains(course)) return true;
            List<Integer> mustLearn = new ArrayList<>(map.get(course));
            visiting.add(course);
            for(int c : mustLearn) {
                if(!map.containsKey(c)) {
                    visited.add(c);
                } else {
                    if(learn(c, map, visited, visiting) == false) return false;
                }
            }
            visiting.remove(course);
            visited.add(course);
            return true;
    }
}