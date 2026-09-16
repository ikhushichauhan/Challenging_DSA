class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

        void backtrack(List<String> ans, StringBuilder curr, int open, int close, int n){
            if(curr.length() == 2*n || open == n && close == n){
                ans.add(curr.toString());
                return;
            }
            if(open<n){
                curr.append('(');
                backtrack(ans, curr, open+1, close, n);
                curr.deleteCharAt(curr.length()-1);
            }
            if(close<open){
                curr.append(')');
                backtrack(ans, curr, open, close+1, n);
                curr.deleteCharAt(curr.length() - 1);
            }
    }
        
}
