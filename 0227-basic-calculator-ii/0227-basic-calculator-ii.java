class Solution {
    public int calculate(String s) {
        int n=s.length();
        int currentNumber=0;
        char operation='+';
        int result=0;
        int lastNumber=0;
    for(int i=0;i<n;i++){
            char c=s.charAt(i);
    if(Character.isDigit(c)){
                currentNumber=currentNumber*10+(c-'0');
            }
    if((!Character.isDigit(c) && c!=' ') || i==n-1){
        if(operation=='+'){
                    result=result+lastNumber;
                    lastNumber=currentNumber;
                }
        else if(operation=='-'){
                    result=result+lastNumber;
                    lastNumber=-currentNumber;
                }
    else if(operation=='*'){
                    lastNumber=lastNumber*currentNumber;
                }
        else if(operation=='/'){
                    lastNumber=lastNumber/currentNumber;
                }
                operation=c;
                currentNumber=0;
            }
        }
        result=result+lastNumber;
        return result;
    }
}