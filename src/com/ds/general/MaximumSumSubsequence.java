package com.ds.general;
import java.util.ArrayList;
import java.util.List;

public class MaximumSumSubsequence {

    public static int maxSumSubsequence(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        List<Integer> subsequence = new ArrayList<>();

        // Calculate dp[]
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == i - j) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        // Find maximum sum satisfying the condition
        int maxSum = Integer.MIN_VALUE;
        int endIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxSum) {
                maxSum = dp[i];
                endIndex = i;
            }
        }

        // Construct the subsequence
        for (int i = endIndex; i >= 0; i--) {
            if (dp[i] == maxSum) {
                subsequence.add(arr[i]);
                maxSum -= arr[i];
            }
        }

        // Print subsequence
        System.out.println("Maximum sum subsequence:");
        for (int i = subsequence.size() - 1; i >= 0; i--) {
            System.out.print(subsequence.get(i) + " ");
        }
        System.out.println();

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 8};
        System.out.println("Maximum sum of subsequence: " + maxSumSubsequence(arr));
    }
}
