package placement.prep;


public class XPowN {
    // Optimized in terms of stack height
    public static int XpowN2(int x, int n) { // here stack height is: log(n)
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 1;
        }

        // if n == even
        if (n % 2 == 0) {
            return XpowN2(x, n/2) * XpowN2(x, n/2);
        } else {
            return XpowN2(x, n/2) * XpowN2(x, n/2) * x;
        }
    }
    public static int XpowN(int x, int n) { // here stack height is: n
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int xPownm1 = XpowN(x,n-1);
        int xPown = x * xPownm1;
        return xPown;
    }
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        int ans1 = XpowN(x, n);
        System.out.println(ans1);
        int ans = XpowN2(x, n);
        System.out.println(ans);
    }
}
