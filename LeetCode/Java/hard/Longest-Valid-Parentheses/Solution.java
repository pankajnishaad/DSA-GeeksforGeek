class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int maxLength=0;
        for (int i=0; i<s.length(); i++) {

            char ch = s.charAt(i);

            // Opening bracket hai
            if (ch == '(') 
            {
                // Uska index stack me store karo
                stack.push(i);
            }

            // Closing bracket hai
            else 
            {
                // Opening bracket ko match karo
                stack.pop();

                // Agar stack empty ho gaya
                if (stack.isEmpty()) {
                    // Current index ko new base bana do
                    stack.push(i);

                } 
                else {

                    // Current valid substring ki length
                    int currentLength = i - stack.peek();

                    // Maximum length update karo
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }

        return maxLength;
    }
}