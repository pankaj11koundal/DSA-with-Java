// Given an array nums of size n, return the majority element.
//
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

import java.util.HashMap;


public class MajorityElement {

    static int findMajorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int majorityElement = 0, majorityValue = Integer.MIN_VALUE;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (HashMap.Entry element : map.entrySet()) {
            if ((int)element.getValue() > majorityValue) {
                majorityElement = (int) element.getKey();
                majorityValue = (int) element.getValue();
            }
        }
        return majorityElement;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 4};

        System.out.println(findMajorityElement(nums));
    }
}
