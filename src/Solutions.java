/**
 * Problem: Image Smoother
 *
 * An image smoother is a filter of size 3x3 applied to each cell of an image.
 * The new value of a cell is calculated by taking the average of the cell
 * and its surrounding neighbors (if they exist), and rounding it down.
 *
 * The smoother is applied to all cells in the image, resulting in a new image matrix.
 *
 * Constraints:
 * - The input matrix has dimensions m x n.
 * - 1 <= m, n <= 200
 * - Each cell value in the matrix is between 0 and 255 inclusive.
 *
 * Example 1:
 * Input: img = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[0,0,0],[0,0,0],[0,0,0]]
 *
 * Example 2:
 * Input: img = [[100,200,100],[200,50,200],[100,200,100]]
 * Output: [[137,141,137],[141,138,141],[137,141,137]]
 */

class Solution {
    /**
     * Applies the image smoother to the input matrix and returns the resulting matrix.
     *
     * @param img The input grayscale image represented as a 2D integer matrix.
     * @return A new 2D integer matrix after applying the smoother to each cell.
     */
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length; // Number of rows in the image
        int cols = img[0].length; // Number of columns in the image

        // Resultant matrix after applying the smoother
        int[][] result = new int[rows][cols];

        // Apply the smoothing operation to each cell in the matrix
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Calculate the smoothed value for the current cell
                result[r][c] = calculateAverage(img, r, c, rows, cols);
            }
        }

        return result;
    }

    /**
     * Calculates the average value for a given cell considering its neighbors.
     *
     * @param img The input grayscale image matrix.
     * @param r The row index of the current cell.
     * @param c The column index of the current cell.
     * @param rows The total number of rows in the image.
     * @param cols The total number of columns in the image.
     * @return The average value for the current cell (rounded down).
     */
    private int calculateAverage(int[][] img, int r, int c, int rows, int cols) {
        int total = 0; // Sum of values in the neighborhood
        int count = 0; // Count of valid cells in the neighborhood

        // Define the boundaries for the neighboring cells
        int top = Math.max(0, r - 1); // Top boundary
        int bottom = Math.min(rows, r + 2); // Bottom boundary
        int left = Math.max(0, c - 1); // Left boundary
        int right = Math.min(cols, c + 2); // Right boundary

        // Iterate over all neighboring cells and the current cell
        for (int row = top; row < bottom; row++) {
            for (int col = left; col < right; col++) {
                total += img[row][col]; // Add the value of the cell to the total
                count++; // Increment the count of valid cells
            }
        }

        // Return the floor of the average value
        return total / count;
    }
}


