/*

Given:
    nums = [ ]

Problem:
    Find the element with max occurrence

Solution 1:
    Store count of each element in Map
    Return key with with max count
    Space Complexity:
    Time Complexity: O ( n ) 

Solution 2:
    Based on Moores' Voting Algorithm
    Store the collective count of ocurrences

*/

class Solution_2 {
    public int majorityElement(int[] nums) {

        int count = 1;
        int result = nums[0];

        for ( int i = 1 ; i < nums.length ; i++ ) {
            if ( count == 0 ) {
                result = nums[i];
                count = 1;
            } else if ( nums[i] == result ) {
                count++;
            } else {
                count --;
            }
        }

        return result;
    }
}

// SOLUTION 1 ---- STARTS HERE

import java.util.*;

class Solution_1 {
    public int majorityElement(int[] nums) {

        Map<Integer,Integer> count = new HashMap<Integer,Integer>();

        for ( int i = 0; i < nums.length; i++ ) {
            if(count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i])+1);
            } else {
                count.put(nums[i], 1);
            }
        }

        int maxValue = Integer.MIN_VALUE;
        int result = nums[0];

        for ( Map.Entry<Integer, Integer> entry : count.entrySet() ) {
            if ( entry.getValue() > maxValue ) {
                maxValue = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
        
    }
}