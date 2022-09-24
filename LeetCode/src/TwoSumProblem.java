// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumProblem {
    static public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int temp;
        HashMap<Integer, Integer> s = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            temp = target - nums[i];
            if (s.containsKey(nums[i])) {
                arr[0] = s.get(nums[i]);
                arr[1] = i;
                break;
            }

            s.put(temp, i);
        }

        return arr;
    }

    public static void main(String[] args) {
        int []nums = new int[]{3, 3};
        int []arr = twoSum(nums, 6);
        for (int i =0 ; i < arr.length; i++ )
            System.out.println(arr[i]);
    }
}
