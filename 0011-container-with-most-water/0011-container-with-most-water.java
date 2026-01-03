class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length -1;
        int maxCap = 0;

        while(start<end){
            int h = Math.min(height[start],height[end]);
            int w = end - start;

            int currCap = h*w;
            maxCap = Math.max(currCap,maxCap);

            if(height[start]<height[end]){
                start++;
            }
            else{
                end--;
            }
        }
        return maxCap;


    }
}