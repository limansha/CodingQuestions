import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        //testcases
        int t =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //size of array
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            long arr[] = new long[(int)n];
            
            //adding elements to the array
            for(int i = 0; i < n; i++)
                arr[(int)i]  =Integer.parseInt(st[(int)i]);
                
           //calling arrange() function
           new Solution().arrange(arr, n);
           
           //printing the elements 
           for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}

class Solution
{
 
    // arr: input array
    // n: size of array
    //Function to rearrange an array so that arr[i] becomes arr[arr[i]]
    //with O(1) extra space.
    static void arrange(long arr[], int n)
    {
        //Combinednumber = valueAtIndex + (ValueThatIsPresentAfterReArrange % n)*n (where n is size of Array if idx is zero based else it is n + 1 if idx is 1 based)
        for(int i=0;i<n;i++){
            arr[i] = arr[i] + ((arr[(int)arr[i]] % n) * n);
        }
        // for(int i=0;i<n;i++){
        //     System.out.print(arr[i] + " ");
        // }
        for(int i=0;i<n;i++){
            //do Division to get the ans values
            //do modules to get the original value present in the location
            //basically we are storing 2 values at ine location 
            arr[i] = arr[i] / n;
        }
        // System.out.println();
        // System.out.println("End result");
        // for(int i=0;i<n;i++){
        //     System.out.print(arr[i] + " ");
        // }
        
    }
}
