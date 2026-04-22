class Solution {
    public String decodeString(String s) {
   Stack<Integer> countStack=new Stack<Integer>();
   Stack<String> stringStack=new Stack<String>();
        String current="";
        int num=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
    else if(c=='['){
                countStack.push(num);
                stringStack.push(current);
                num=0;
                current="";
            }
    else if(c==']'){
                int repeat=countStack.pop();
                String prev=stringStack.pop();
                StringBuilder sb=new StringBuilder(prev);
        for(int j=0;j<repeat;j++){
                    sb.append(current);
                }
                current=sb.toString();
            }
            else{
                current=current+c;
            }
        }
        return current;
    }
}