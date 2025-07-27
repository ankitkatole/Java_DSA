public class FloodFillAlgorithm {
    public void floodHelper(int[][] image, int sr, int sc, int color, boolean vis[][], int oldColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != oldColor) {
            return;
        }
        // left
        floodHelper(image, sr, sc - 1, color, vis, oldColor);
        // right
        floodHelper(image, sr, sc + 1, color, vis, oldColor);
        // up
        floodHelper(image, sr - 1, sc, color, vis, oldColor);
        // down
        floodHelper(image, sr + 1, sc, color, vis, oldColor);

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        floodHelper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }
}
