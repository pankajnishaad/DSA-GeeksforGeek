class Solution {
    public static boolean
        isSubsequence(String word, List<List<Integer> > pos)
        {

            int prevIndex = -1;

            for (char ch : word.toCharArray()) {

                // All positions where character 'ch' occurs in
                // s
                List<Integer> indices = pos.get(ch - 'a');

                // Find first occurrence of ch after prevIndex
                int it = -1;
                for (int i = 0; i < indices.size(); i++) {
                    if (indices.get(i) > prevIndex) {
                        it = indices.get(i);
                        break;
                    }
                }

                // No valid next position found
                if (it == -1) {
                    return false;
                }

                // Update previously matched index
                prevIndex = it;
            }

            return true;
        }
    public String findLongestWord(String s, List<String> d) {
        // code here
        List<List<Integer> > pos = new ArrayList<>();
                for (int i = 0; i < 26; i++) {
                    pos.add(new ArrayList<>());
                }

                for (int i = 0; i < s.length(); i++) {
                    pos.get(s.charAt(i) - 'a').add(i);
                }

                String res = "";

                for (String word : d) {

                    // Skip smaller words directly
                    if (word.length() < res.length()) {
                        continue;
                    }

                    // Check whether word is subsequence of s
                    if (isSubsequence(word, pos)) {

                        // Prefer longer word
                        // If same length, prefer lexicographically
                        // smaller word
                        if (word.length() > res.length()
                            || (word.length() == res.length()
                                && word.compareTo(res) < 0)) {

                            res = word;
                        }
                    }
                }

                return res;
    }
}