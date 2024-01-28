/*

Terms:
    Known as Kadane's Algorithm or Sliding Window Problem

Given:
    nums = [ -8 , 4 , 0 , -2 , 9]

Problem:
    Find the subarray whose sum is maxmium and return the sum

Edge Case:
    Includes negative numbers
    Whole array could be of negative integers

Edge Case Solution: Use the max values as Integer.MIN_VALUE

Solution 1:
    Calculate max sum till current index
    If current sum is greater than overall sum, update the overall sum to current sum.
    
    To calculate the sum till current index:
        Option 1 : Start fresh from current index value
        Option 2 : Add the current index value

    Option 1 Scenario: 
        When the current sum is negative, better to start fresh using current value.

*/

class Solution_1 {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;                     // [ -1 ]
        int maxSumTillCurrentIndex = Integer.MIN_VALUE;

        for ( int i = 0; i < nums.length; i++ ) {
            if ( maxSumTillCurrentIndex < 0 ) {             // [ -1 ] , [ 1 , 2 ]
                maxSumTillCurrentIndex = nums[i];
            } else {
                maxSumTillCurrentIndex += nums[i];
            }

            if ( maxSumTillCurrentIndex > maxSum ) {
                maxSum = maxSumTillCurrentIndex;
            }
        }

        return maxSum;
    }
}