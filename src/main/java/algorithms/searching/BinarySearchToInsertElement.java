package algorithms.searching;

/**
 * Find right index to insert an element in a sorted array
 */
public class BinarySearchToInsertElement {

    public static int findIndexToInsert(int[] nums, int element) {
        if (nums == null || nums.length == 0) return 0;

        return binarySearch(nums, 0, nums.length - 1, element);
    }

    private static int binarySearch(int[] nums, int left, int right, int element) {
        if (right - left <= 1) {
            if (element < nums[left]) {
                return left;
            } else if (nums[left] <= element && element <= nums[right]){
                return right;
            } else if (nums[right] < element) {
                return right + 1;
            }
        }
        int middle = (left + right) / 2;
        if (element == nums[middle]) {
            return middle;
        }
        if (element > nums[middle]) {
            return binarySearch(nums, middle, right, element);
        }
        if (element < nums[middle]) {
            return binarySearch(nums, left, middle, element);
        }
        return nums.length;
    }
}