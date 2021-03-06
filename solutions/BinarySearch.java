public class BinarySearch {
    /*
     * right neighbor might be the ans
     * 
     * example: an array represents the good or bad of a bunch of product, each product quality
     * based on the previous verson, meaning if current version product is bad, then next one must
     * be bad, goal is to find the first bad version
     */
    public int badVersion(boolean[] nums) {
        int left = 0, right = nums.length - 1, mid = -1;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == false) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        Printer.print(String.format("(%s, %s)", left, right));
        // now left = right, in most cases, nums[right] would be the target, since right = mid when
        // nums[mid] = false,
        // however what if right pointer does not move at all? such as [true, true, true, true,
        // true]
        // lr
        // because left side are all true, the left pointer keeps moving to the right until left
        // meets right point,
        // at this momment we do not know if nums[right] is false or not
        if (nums[right]) {
            return -1;
        } else {
            return right;
        }

    }


    /*
     * find a number in array, if it does not exist, return the lower bound
     */

    public int[] rangeBinary(int[] nums, int target) {
        int[] window = new int[2];
        int left = 0, right = nums.length - 1, mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // if target is not found, then now left = right + 1;
        // all elements in nums[0, l] < target, all element in nums[r, len - 1] > target
        // the target is between r and l
        window[0] = right;
        window[1] = left;
        return window;
    }

    /*
     * find smallest letter greater than taget, LeetCode 744, char array is wrap around, For
     * example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
     */

    public char smallestGreater(char[] letters, char target) {
        int left = 0, right = letters.length - 1, mid = -1;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (letters[mid] > target) { // the ans could be mid itself
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        Printer.print(String.format("(%s, %s)", left, right));
        if (letters[right] > target) {
            return letters[right];
        } else {
            return letters[0];
        }
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        // boolean[] products = new boolean[] {true, true, true, true, true};
        // int badIndex = binarySearch.badVersion(products);

        // int[] nums = new int[] {1, 3, 5, 6, 8, 9};
        // int[] window = binarySearch.rangeBinary(nums, 4);

        char[] letters = new char[] {'b', 'c', 'd'};
        char smallestGreater = binarySearch.smallestGreater(letters, 'a');
        Printer.print(smallestGreater);
    }
}
