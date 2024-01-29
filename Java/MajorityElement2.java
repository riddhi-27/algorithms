/*

Given:
    nums = []

Problem:
    Find all array elements which occur more than n / 3 times

Solution 1:
    Get count of each element in HashMap
    Return List of elements whose count are more than required

Solution 2:
    Version of Boyer-Moore Voting Algorithm
*/


// SOLUTION 2 --- STARTS HERE

import java.util.*;

class Solution_2 {
    public List<Integer> majorityElement(int[] nums) {

        int count1 = 1;
        int count2 = 0;
        int maxValue1 = nums[0];
        int maxValue2 = nums[0];

        for ( int i = 1 ; i < nums.length ; i++ ) {

            if ( nums[i] == maxValue1 ) {
                count1++;
            } else if ( nums[i] == maxValue2 ) {
                count2++;
            } else if ( count1 == 0 ) {
                maxValue1 = nums[i];
                count1 = 1;
            } else if ( count2 == 0 ) {
                maxValue2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int val : nums) {          // [ 2 , 2, 1, 3 ]
            if (val == maxValue1) {
                count1++;
            } else if ( val == maxValue2 ) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<Integer>();

        if (count1 > nums.length / 3 ) {  // [ 3 , 2 , 3 ]
            result.add(maxValue1);
        }
        
        if (count2 > nums.length / 3 ) {
            result.add(maxValue2);
        }

        return result;
    }
}


// SOLUTION 1 --- STARTS HERE

import java.util.*;

class Solution_1 {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> count = new HashMap<Integer,Integer>();

        for ( int i = 0; i < nums.length; i++ ) {
            if(count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i])+1);
            } else {
                count.put(nums[i], 1);
            }
        }

        List<Integer> result = new ArrayList<Integer>();

        for ( Map.Entry<Integer, Integer> entry : count.entrySet() ) {
            if ( entry.getValue() > nums.length / 3 ) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}