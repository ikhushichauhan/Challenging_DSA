class Solution {
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else{

            int firstnum = 0;
            int secondnum = 1;

            for(int i=1; i<=n; i++){
                int thirdnum = firstnum + secondnum;
                firstnum = secondnum;
                secondnum = thirdnum;
            }
            return firstnum;
        }
        
    }
}