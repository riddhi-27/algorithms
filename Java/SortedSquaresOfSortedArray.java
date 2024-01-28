/* 
Given:
    nums = [-4 , -2 , 1 , 3 ]

Problem:
    Given a sorted array, return a sorted array of squares

Edge Case: 
    Includes negative numbers: Square of negative number is positive.

Solution 1: 
    Calculate squares and sort the array.

Solution 2:
    Max square that is possible could be of either first element or last element
    Get the max square and forward the corresponding pointer

*/

/* 

Time Complexity: O ( n )
Space complexity: O ( n )

*/
class Solution_2 {

    public int[] sortedSquares(int[] nums) {

        int length = nums.length;
        int start = 0;
        int end = length - 1;

        int[] result = new int[]

        for( int i = 0; i < length; i++) {

        }
    }
}

/*

Time complexity: O ( n log n )
Space complexity: O ( n)

*/
class Solution_1 {

    public int[] sortedSquares(int[] nums) {

        int length = nums.length;

        for ( int i = 0 ; i < length ; i++) {
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);

        return nums;
    }
}