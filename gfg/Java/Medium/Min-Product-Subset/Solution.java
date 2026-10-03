class Solution {
    public int minProd(int[] arr) {
        // code here
        int neg = 0; // count of negative numbers
        int zero = 0; // count of zeros
        int prod = 1; // product of all non-zero elements
        int mnNegAbs = Integer.MAX_VALUE;
        int mnPos = Integer.MAX_VALUE;

        for (int x : arr) {
            if (x == 0) {
                zero++;
                continue;
            }

            prod *= x;

            if (x < 0) {
                neg++;
                mnNegAbs = Math.min(mnNegAbs, Math.abs(x));
            }
            else {
                mnPos = Math.min(mnPos, x);
            }
        }

        // All elements are zero
        if (neg == 0 && mnPos == Integer.MAX_VALUE) {
            return 0;
        }

        // If there is at least one negative number
        if (neg > 0) {
            // Odd number of negatives
            if (neg % 2 == 1) {
                return prod;
            }

            // Even number of negatives
            return prod / (-mnNegAbs);
        }

        // No negative numbers
        if (zero > 0) {
            return 0;
        }

        // Only positive numbers
        return mnPos;        
    }
}