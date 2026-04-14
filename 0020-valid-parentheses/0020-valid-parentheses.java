class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                top=top+1;
                stack[top]=ch;
            } else {
                if(top==-1){
                    return false;
                }
                char last=stack[top];
                if(ch==')'){
                    if(last!='('){
                        return false;
                    }
                } else if(ch=='}'){
                    if(last!='{'){
                        return false;
                    }
     } else if(ch==']'){
                    if(last!='['){
                        return false;
                    }
                }
                top=top-1;
            }
        }
        if(top==-1){
            return true;
        } else {
            return false;
        }
    }
}