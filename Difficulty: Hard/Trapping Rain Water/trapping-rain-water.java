//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
        int l = 0;
        int r = arr.length - 1;
        int lMax = 0;
        int rMax = 0;
        int totalWater = 0;
        
        while (l < r){
            if (arr[l] <= arr[r]){
                if (lMax > arr[l]){
                    totalWater += lMax - arr[l];
                }else {
                    lMax = arr[l];
                }
                   l += 1;
            }else {
                if (rMax > arr[r]){
                    totalWater += rMax - arr[r];
                }else {
                    rMax = arr[r];
                }
                    r -= 1;
            }
        }
        
        return totalWater;
    }
}
