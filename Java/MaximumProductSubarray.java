/*

Given:
    nums = [ -2 , 0 , -5 , 60 , 0 ]

Problem:
    Find the the subarray whose product is maximum

Edge Case:
    Includes negative numbers and zero

Edge Case Solution:
    If the current product is zero, start fresh from current value

*/


class Solution_2 {
    public int maxProduct(int[] nums) {

        // Kadanes version

        int maxValue = nums[0];
        int minValue = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++ ) {

            if ( nums[i] < 0 ) {        // [ -2 , 3 , -4 ]
                int temp = maxValue;
                maxValue = minValue;
                minValue = temp;
            }

            maxValue = Math.max( nums[i] , maxValue * nums[i] );
            minValue = Math.min( nums[i] , minValue * nums[i] );

            result = Math.max( result , maxValue );
        }

        return result;
    }
}

class Solution_1 {
    public int maxProduct(int[] nums) {
        int maxValue_1 = Integer.MIN_VALUE;
        int currentMaxValue_1 = 1;

        for( int i = 0;  i < nums.length; i++ ) {
            if ( currentMaxValue_1 == 0 ) {
                currentMaxValue_1 = nums[i];
            } else {
                currentMaxValue_1 *= nums[i];
            }

            if ( currentMaxValue_1 > maxValue_1 ) {
                maxValue_1 = currentMaxValue_1;
            }
        }

        int maxValue_2 = Integer.MIN_VALUE;                 // [ 3 ,  -1 , 4 ]
        int currentMaxValue_2 = 1;

        for( int i = nums.length - 1;  i >= 0; i-- ) {
            if ( currentMaxValue_2 == 0 ) {
                currentMaxValue_2 = nums[i];
            } else {
                currentMaxValue_2 *= nums[i];
            }

            if ( currentMaxValue_2 > maxValue_2 ) {
                maxValue_2 = currentMaxValue_2;
            }
        }

        return Math.max(maxValue_1,maxValue_2);
    }
}