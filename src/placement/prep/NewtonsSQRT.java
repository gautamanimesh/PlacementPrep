package placement.prep;

public class NewtonsSQRT {

    // Newton-Raphson Method
    private static double sqrt (int n) {
        double root;
        double x = n;

        while (true) {
            root = 0.5 * (x + (n/x));

            if (Math.abs(root - x) < 0.01) {
                break;
            }

            x = root;
        }

        return root;
    }

    public static void main(String[] args) {
        int num = 40;
        System.out.println(sqrt(num));
    }
}
