/* 

Given:
    nums = [1,2,3,4,5,6,7]
    k = 3

Problem:
    Rotate nums array by k positions towards right

Expected Output:
    nums = [5,6,7,1,2,3,4]

Edge Case: 
    k > n

Edge Case Solution:
    k = k % n;

Solution 1:
    Reverse the array in parts
        Part one: whole array from 0 to n - 1
        Part two: first part of array from 0 to k - 1
        Part three: last part of array from k to n - 1

    After part one: whole array would be reversed
        : nums = [7 ,6 ,5, 4, 3 , 2, 1]

    After part two: the first part of array till k - 1 while again be reversed making it back in original order
        : nums = [5, 6, 7, ...]

    After part three: the last part of array from k while again be rversed making it back in the original order
        : nums = [..., 1, 2, 3]
*/

class Solution_1 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;

        k = k % length;

        reversePart(nums, 0, length-1);
        reversePart(nums, 0, k-1);
        reversePart(nums, k, length-1);
    }

    public void reversePart(int[] nums, int start, int end) {
        while ( start < end ) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}