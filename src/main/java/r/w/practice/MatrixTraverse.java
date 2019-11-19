package r.w.practice;

public class MatrixTraverse {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {0, 1, 2, 3},
                {11, 12, 13, 4},
                {10, 15, 14, 5},
                {9, 8, 7, 6}
        };
        traverse(matrix);
    }

    private static void traverse(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("matrix is not valid");
        }
        final int length = matrix.length;
        Point leftUp = new Point(0, 0);
        Point rightUp = new Point(0, length - 1);
        Point rightBottom = new Point(length - 1, length - 1);
        Point leftBottom = new Point(length - 1, 0);
        _traverse(matrix, leftUp, rightUp, rightBottom, leftBottom);
    }

    private static void _traverse(int[][] matrix, Point leftUp, Point rightUp, Point rightBottom, Point leftBottom) {

        if (leftUp.col == rightUp.col) {
            System.out.println(matrix[leftUp.row][leftUp.col]);
            return;
        }
        if (rightUp.col - leftUp.col == 1) {
            System.out.println(matrix[leftUp.row][leftUp.col]);
            System.out.println(matrix[rightUp.row][rightUp.col]);
            System.out.println(matrix[rightBottom.row][rightBottom.col]);
            System.out.println(matrix[leftBottom.row][leftBottom.col]);
            return;
        }
        for (int col = leftUp.col; col <= rightUp.col; col++) {
            System.out.println(matrix[leftUp.row][col]);
        }
        for (int row = rightUp.row + 1; row <= rightBottom.row; row++) {
            System.out.println(matrix[row][rightUp.col]);
        }
        for (int col = rightBottom.col - 1; col >= leftBottom.col; col--) {
            System.out.println(matrix[rightBottom.row][col]);
        }
        for (int row = leftBottom.row - 1; row > leftUp.row; row--) {
            System.out.println(matrix[row][leftBottom.col]);
        }
        _traverse(matrix,
                new Point(leftUp.row + 1, leftUp.col + 1),
                new Point(rightUp.row + 1, rightUp.col - 1),
                new Point(rightBottom.row - 1, rightBottom.col - 1),
                new Point(leftBottom.row - 1, leftBottom.col + 1)
        );
    }

    static class Point {

        private int row;

        private int col;

        Point(int row, int col) {

            this.row = row;
            this.col = col;
        }
    }
}
