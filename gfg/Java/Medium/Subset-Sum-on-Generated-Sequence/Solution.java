class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        // code here
        // Generate the sequence written on the paper.
        ArrayList<Long> seq = new ArrayList<>();
        seq.add((long) s);

        long prefSum = s;

        for (int val : arr) {
            long cur = prefSum + val;
            seq.add(cur);
            prefSum += cur;
        }

        // Greedily subtract the largest possible values.
        long target = x;

        for (int i = seq.size() - 1; i >= 0; i--) {
            if (seq.get(i) <= target)
                target -= seq.get(i);
        }

        return target == 0;        
    }
}