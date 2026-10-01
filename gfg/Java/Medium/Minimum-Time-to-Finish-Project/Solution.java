class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;

        // Build the dependency graph.
        ArrayList<ArrayList<Integer> > adj= new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        int[] indegree = new int[n];

        for (int[] edge : dependencies) {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // Store the earliest completion time for every
        // module.
        int[] finishTime = duration.clone();

        Queue<Integer> q = new LinkedList<>();

        // Start with all modules having no dependencies.
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.add(i);

        int visited = 0;
        int res = 0;

        // Perform topological traversal.
        while (!q.isEmpty()) {
            int node = q.poll();

            visited++;
            res = Math.max(res, finishTime[node]);

            // Update completion time of dependent modules.
            for (int next : adj.get(node)) {
                finishTime[next] = Math.max(
                    finishTime[next],
                    finishTime[node] + duration[next]);

                if (--indegree[next] == 0)
                    q.add(next);
            }
        }

        // Cycle detected.
        if (visited != n)
            return -1;

        return res;        // code here
        
    }
}