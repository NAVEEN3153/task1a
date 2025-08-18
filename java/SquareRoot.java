public class SquareRoot {

    public static int mySqrt(int x) {
        if (x < 2) {
            return x; // 0 and 1 return themselves
        }

        int left = 1, right = x / 2, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Use long to avoid integer overflow when doing mid*mid
            long square = (long) mid * mid;

            if (square == x) {
                return mid;  // perfect square found
            } else if (square < x) {
                ans = mid;   // mid is a potential answer
                left = mid + 1;
            } else {
                right = mid - 1; // mid*mid too big, decrease right
            }
        }

        return ans; // return floor of sqrt(x)
    }

    public static void main(String[] args) {
        int x = 10;
        System.out.println("Square root of " + x + " rounded down is: " + mySqrt(x));

        // Test more cases
        System.out.println("Square root of 16: " + mySqrt(16)); // should be 4
        System.out.println("Square root of 1: " + mySqrt(1));   // should be 1
        System.out.println("Square root of 0: " + mySqrt(0));   // should be 0
        System.out.println("Square root of 26: " + mySqrt(26)); // should be 5
    }
}
