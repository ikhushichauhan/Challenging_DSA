class Solution {
    public String removeDuplicates(String s) {
        StringBuilder a = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char b = s.charAt(i);
            int c = a.length();
    if(c>0 && a.charAt(c-1)==b){
                a.deleteCharAt(c-1);
            } else {
                a.append(b);
            }
        }
    return a.toString();
    }
}