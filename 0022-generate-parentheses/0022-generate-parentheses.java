class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        build(ans,"",0,0,n);
        return ans;
    }
    private void build(List<String> ans,String current,int open,int close,int n){
        
        if(current.length()==2*n){
            ans.add(current);
            return;
        }
    if(open<n){
            build(ans,current+"(",open+1,close,n);
        }
 if(close<open){
            build(ans,current+")",open,close+1,n);
        }
    }
}