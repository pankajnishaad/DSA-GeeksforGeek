class Solution {
    int transform(String s1, String s2) {
        // code here
        if (s1.length() != s2.length()) {
             return -1;
         }

         // Step 1: Character Frequency Check (Anagram Check)
         // We use a HashMap to ensure both strings contain the exact same characters.
         HashMap<Character, Integer> m = new HashMap<Character, Integer>();
         int n = s1.length();

         // Count characters in string s1
         for (int i = 0; i < n; i++) {
             m.put(s1.charAt(i), m.getOrDefault(s1.charAt(i), 0) + 1);
         }

         // Subtract character counts based on string s2
         for (int i = 0; i < n; i++) {
             if (m.containsKey(s2.charAt(i)))
                 m.put(s2.charAt(i), m.get(s2.charAt(i)) - 1);
         }

         // If any count is non-zero, strings aren't anagrams; return -1
         for (Map.Entry<Character, Integer> entry : m.entrySet()) {
             if (entry.getValue() != 0)
                 return -1;
         }

         // Step 2: Greedy Two-Pointer Approach
         // Since we can only move to the FRONT, we match characters starting from the BACK (right to left).
         int i = n - 1, j = n - 1;
         int res = 0;

         while (i >= 0 && j >= 0) {
             // If characters at current pointers don't match, s1.charAt(i) 
             // is a character that must be moved to the front eventually.
             while (i >= 0 && s1.charAt(i) != s2.charAt(j)) {
                 res++; // This character 'i' will be moved, increment operations
                 i--;   // Move 'i' left to find the next potential match for s2[j]
             }

             // If we found a match (s1[i] == s2[j]), move both pointers left to check the next set
             if (i >= 0) {
                 i--;
                 j--;
             }
         }
         return res;       
    }
}