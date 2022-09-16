package Brilley.BinaryResearchRelated;

import java.util.Arrays;

/**
 * @author Brilley
 * @date 2022/9/16
 */
public class SearchRotationArr {
    public static void test1(){
        int [] nums = new int[] {4, 5, 6, 7, 0, 1, 2};
        int result = searchMin(nums, 0, nums.length - 1, 0);
        System.out.println(result);
        result = searchMinWithHigh(nums, 0, nums.length - 1, 0);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
        int target = 12;
        System.out.println("target " + target + " in arr?");
        System.out.println(searchTarget(nums,0, nums.length - 1, target));
        target = 67;
        System.out.println("target " + target + " in arr?");
        System.out.println(searchTargetWithRecurrence(nums,0, nums.length - 1, target));
    }
    private static int searchMin(int[] nums, int low, int high, int target) {
        while(low <= high) {
            if ( nums[low] <= nums[high]) {
                return low;
            }
            int mid = low + ((high - low) >> 1);
            if(nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
            System.out.println("mid: " + mid );
        }
        return low;
    }

    private static int searchMinWithHigh(int[] nums, int low, int high, int target) {
        while(low < high) {
            int mid = low + ((high - low) >> 1);
            if(nums[high] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static boolean searchTarget(int[] nums, int low, int high, int target) {
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] >= nums[low]) {
                // left sorted
                if (nums[mid] > target && nums[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;  // can recurrence
                }
            } else {
                    // right sorted
                    if (nums[mid] < target && nums[high] >= target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
        }
        return false;
    }

    private static boolean searchTargetWithRecurrence(int[] nums, int low, int high, int target) {
        if (low > high) {
            return false;
        }
        int mid = low + ((high - low) >> 1);
        if (nums[mid] == target) {
                return true;
        }
        if (nums[mid] >= nums[low]) {
            // left sorted
            if (nums[mid] > target && nums[low] <= target) {
                return binarySearch(nums, low, mid - 1, target);
            } else {
                return searchTargetWithRecurrence(nums, mid + 1, high, target);
            }
        } else {
                // right sorted
            if (nums[mid] < target && nums[high] >= target) {
                return binarySearch(nums, mid + 1, high, target);
            } else {
                return searchTargetWithRecurrence(nums, low, mid - 1, target);
            }
        }
    }

    private static boolean binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) {
            return false;
        }
        int mid = low + ((high - low) >> 1);
        if (nums[mid] == target) {
            return true;
        }
        if (nums[mid] > target) {
            return  binarySearch(nums, low, mid - 1, target);
        }
        return  binarySearch(nums, mid + 1, high, target);
    }
}
