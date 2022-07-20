package placement.prep;

import java.util.Base64;

public class BitwiseOperators {
    /*
     * AND with 1: The number remains the same.
     */

    /*
     * Left Shift: [ << ]
     * Left shift doubles the number.
     * a << 1 = 2 * a
     * a << b = (2^b) * a
     */

    /*
     * Right Shift: [ >> ]
     * Right shift halves the number.
     * a >> 1 = a / 2
     * a >> b = a  /(2^b)
     */

    /*
    * XOR:
    * a ^ 1 = ~a
    * a ^ 0 = a
    */

    // Ques1: Odd-Even
    private static boolean isOdd (int n) {
        return (n & 1) == 1;
    }

    // Ques2: Find unique number in array
    private static int uniqueNumber (int[] arr) {
        int ans = 0;
        for (int j: arr) {
            ans ^= j;
        }
        return ans;
    }

    // Ques3: Find i-th bit of a number.
    private static int iThBit(int num, int i) {
        //  num = 10110110, i = 5
        // mask = 00010000
        int mask = 1 << (i-1);
        int ans = num & mask; // returns decimal
        return ans >> (i-1);  // right shift i-1 times to get binary!

        // return (num >> (i-1)) & 1;
    }

    // Ques4:
    private static int setBit(int num, int i) {
        //  num = 1010110
        // mask = 0001000
        // set bit: set bit to 1!
        // to set bit: OR with 1
        int mask = 1 << (i-1);
        return num | mask;
    }

    // Ques5:
    private static int resetBit(int num, int i) {
        //  num = 1010110
        // mask = 1101111
        // reset bit: set bit to 0!
        // to reset bit: AND i-th bit with 0 and all the other bits with 1.
        int mask = ~(1 << (i-1));
        return num & mask;
    }

    // Ques6:
    private static int magicNumber (int n) {
        int ans = 0;
        int base = 5;

        while (n > 0) {
            int last = n & 1;
            n = n >> 1;
            ans += last * base;
            base *= 5;
        }

        return ans;
    }

    // Ques7:
    private static int noOfDigitsInBaseB(int num, int base) {
        return (int)(Math.log(num) / Math.log(base)) + 1;
    }

    private static boolean powOfTwo(int num) {
        if (num == 0) return false;
        return (num & (num-1)) == 0;
    }

    private static int power(int power, int base) {
        int ans = 1;
        while (power > 0) {
            if ((power & 1) == 1) {
                ans *= base;
            }

            base *= base;
            power = power >> 1;
        }
        return ans;
    }

    private static int countSetBits (int n) {
        int ans = 0;
        while (n > 0) {
            n = n & (n-1);
            // n -= (n & -n);
            ans++;
        }
        return ans;
    }

    private static int xorTillA (int a) {
        if (a % 4 == 0) return a;
        else if (a % 4 == 1) {
            return 1;
        } else if (a % 4 == 2) {
            return a+1;
        } else {
            return 0;
        }
    }

    private static int rangeXOR(int a, int b) {
        // rangeXOR for a, b = xor(b) ^ xor(a-1)
        return xorTillA(b) ^ xorTillA(a-1);
    }

    public static void main(String[] args) {
        int num = 13;
        System.out.println(isOdd(num));

        int[] arr = {2, 3, 3, 4, 2, 6, 4};
        System.out.println(uniqueNumber(arr));

        int n = 20, i = 4;
        System.out.println(iThBit(n, i));

        int a = 10, j = 2;
        System.out.println(setBit(a, j));

        int b = 10, z = 2;
        System.out.println(resetBit(b, z));

        int c = 6;
        System.out.println(magicNumber(c));

        int d = 34567, base = 10;
        System.out.println(noOfDigitsInBaseB(d, base));

        System.out.println(powOfTwo(32));

        System.out.println(power(3,4));

        System.out.println(countSetBits(10));
    }
}
