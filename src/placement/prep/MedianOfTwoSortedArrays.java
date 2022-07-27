package placement.prep;

public class MedianOfTwoSortedArrays {

    // Time Complexity: O(log(n))
    private static int medianOptimized (int[] a, int[] b, int startA, int startB, int endA, int endB) {
        if (endA - startA == 1) {
            return (Math.max(a[startA], b[startB] + Math.min(a[endA], b[endB])) / 2);
        }

        int m1 = calculateMedian(a, startA, endA);
        int m2 = calculateMedian(b, startB, endB);

        if (m1 == m2) {
            return m1; // return m2;
        } else if (m1 < m2) {
            return medianOptimized(a, b, (endA + startA + 1) / 2, startB, endA, (endB + startB + 1) / 2);
        } else {
            return medianOptimized(a, b, startA, (endB + startB + 1) / 2, (endA + startA + 1) / 2, endB);
        }
    }

    private static int calculateMedian (int[] a, int start, int end) {
        int n = end - start + 1;
        if (n % 2 == 0) {
            return (a[start + (n / 2)] + a[start + (n / 2 - 1)]) / 2;
        } else {
            return a[start + n / 2];
        }
    }

    // Time Complexity: O(n)
    private static int median (int[] arr1, int[] arr2, int n) {
        int i = 0, j = 0;
        int count;
        int m1 = -1, m2 = -1;
        for (count = 0; count <= n; count++) {
            if (i == n) {
                m1 = m2;
                m2 = arr2[0];
                break;
            } else if (j == n) {
                m1 = m2;
                m2 = arr1[0];
                break;
            }
            if (arr1[i] <= arr2[j]) {
                m1 = m2;
                m2 = arr1[i++];
            } else {
                m1 = m2;
                m2 = arr2[j++];
            }
        }
        return (m1 + m2) / 2;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 12, 15, 26, 38};
        int[] arr2 = {2, 13, 17, 30, 45};
        int n1 = arr1.length;
        int n2 = arr2.length;
        if (n1 == n2) {
            System.out.println("Median is: " + median(arr1, arr2, n1));
            System.out.println("Optimized: " + medianOptimized(arr1, arr2, 0, 0, n1-1, n2-1));
        } else {
            System.out.println("Unequal Size");
        }
    }
}
