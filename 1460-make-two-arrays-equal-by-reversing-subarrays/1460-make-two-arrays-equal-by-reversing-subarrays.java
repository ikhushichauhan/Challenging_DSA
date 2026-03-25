import java.util.Arrays;

public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
       
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] target1 = {1,2,3,4};
        int[] arr1 = {2,4,1,3};
        System.out.println(sol.canBeEqual(target1, arr1));

        int[] target2 = {7};
        int[] arr2 = {7};
        System.out.println(sol.canBeEqual(target2, arr2)); 

        int[] target3 = {1,12};
        int[] arr3 = {12,1};
        System.out.println(sol.canBeEqual(target3, arr3)); 

        int[] target4 = {1,2,3,4};
        int[] arr4 = {1,2,3,5};
        System.out.println(sol.canBeEqual(target4, arr4)); 
    }
}