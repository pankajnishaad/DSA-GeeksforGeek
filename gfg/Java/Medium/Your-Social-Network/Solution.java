class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        // code here
        int n = arr.length + 1;

        // Store all reachable connections.
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();

        // Process users from 2 to n.
        for (int i = 2; i <= n; i++) {

            // Store the friend chain of user i.
            ArrayList<Integer> path = new ArrayList<>();

            int curr = i;

            // Follow the friend chain until user 1.
            while (curr != 1) {
                curr = arr[curr - 2];

                // Store the reachable user.
                path.add(curr);
            }

            // Process the path in reverse so that
            // users j are considered in increasing order.
            int distance = path.size();

            for (int j = path.size() - 1; j >= 0; j--) {

                // Distance from i to path[j].
                ArrayList<Integer> connection
                    = new ArrayList<>();

                connection.add(i);
                connection.add(path.get(j));
                connection.add(distance);

                ans.add(connection);

                distance--;
            }
        }

        return ans;        
    }
}