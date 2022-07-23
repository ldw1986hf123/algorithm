package com.ldw.algorithm;

/**
 * 二分查法，
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int rightIndex = nums.length - 1;
        int leftIndex = 0;
        int middleIndex = 0;

        while (leftIndex <= rightIndex) {
//            middleIndex = (rightIndex - leftIndex) / 2;   这样是不对的，如果没有+leftIndex  ，会写入死循环
            middleIndex = (rightIndex - leftIndex) / 2 + leftIndex;   //todo  这样才是对的，原因待考察
            int num = nums[middleIndex];
            if (num == target) {
                return middleIndex;
            } else if (num > target) {
                rightIndex = middleIndex - 1;
            } else {

                leftIndex = middleIndex + 1;
            }

        }
        return -1;
    }

    public static int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 0;
        System.out.print(search(nums, target));
    }


}
