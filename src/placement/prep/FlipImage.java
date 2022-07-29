package placement.prep;

import java.util.Arrays;

public class FlipImage {

    // Time Complexity: O(N)
    // Space Complexity: O(1)

    private static int[][] flipImage(int[][] image) {
        int col = image[0].length;
        for (int[] row: image) {
            for (int i = 0; i < (col + 1) / 2; i++) {
                // swap
                int temp = row[i] ^ 1;
                row[i] = row[col - i - 1] ^ 1;
                row[col - i - 1] = temp;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        int[][] ans = flipImage(image);
        for (int[] edge: ans) {
            System.out.println(Arrays.toString(edge));
        }
    }
}
