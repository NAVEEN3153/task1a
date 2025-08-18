public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Compute the product of all elements to the left of each index
        result[0] = 1; // There is no element to the left of index 0, so it should be 1.
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Compute the product of all elements to the right of each index
        int rightProduct = 1; // There is no element to the right of the last index.
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i]; // Update the rightProduct for the next iteration
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);

        System.out.print("Product of array except self: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
