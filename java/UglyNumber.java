public class UglyNumber {

    public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0; // pointers for multiples of 2, 3, 5
        int next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(next2, Math.min(next3, next5));
            ugly[i] = nextUgly;

            if (nextUgly == next2) {
                i2++;
                next2 = ugly[i2] * 2;
            }
            if (nextUgly == next3) {
                i3++;
                next3 = ugly[i3] * 3;
            }
            if (nextUgly == next5) {
                i5++;
                next5 = ugly[i5] * 5;
            }
        }

        return ugly[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("The " + n + "th ugly number is: " + nthUglyNumber(n));

        // Test with other values
        System.out.println("The 1st ugly number is: " + nthUglyNumber(1));   // 1
        System.out.println("The 15th ugly number is: " + nthUglyNumber(15)); // 24
    }
}
