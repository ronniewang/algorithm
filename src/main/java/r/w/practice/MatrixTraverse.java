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
        int[] leftUp = new int[]{0, 0};
        int[] rightUp = new int[]{0, length - 1};
        int[] rightBottom = new int[]{length - 1, length - 1};
        int[] leftBottom = new int[]{length - 1, 0};
        _traverse(matrix, leftUp, rightUp, rightBottom, leftBottom);
    }

    private static void _traverse(int[][] matrix, int[] leftUp, int[] rightUp, int[] rightBottom, int[] leftBottom) {

        if (leftUp[1] == rightUp[1]) {
            System.out.println(matrix[leftUp[0]][leftUp[1]]);
            return;
        }
        if (rightUp[1] - leftUp[1] == 1) {
            System.out.println(matrix[leftUp[0]][leftUp[1]]);
            System.out.println(matrix[rightUp[0]][rightUp[1]]);
            System.out.println(matrix[rightBottom[0]][rightBottom[1]]);
            System.out.println(matrix[leftBottom[0]][leftBottom[1]]);
            return;
        }
        for (int col = leftUp[1]; col <= rightUp[1]; col++) {
            System.out.println(matrix[leftUp[0]][col]);
        }
        for (int row = rightUp[0] + 1; row <= rightBottom[0]; row++) {
            System.out.println(matrix[row][rightUp[1]]);
        }
        for (int col = rightBottom[1] - 1; col >= leftBottom[1]; col--) {
            System.out.println(matrix[rightBottom[0]][col]);
        }
        for (int row = leftBottom[0] - 1; row > leftUp[0]; row--) {
            System.out.println(matrix[row][leftBottom[1]]);
        }
        _traverse(matrix,
                new int[]{leftUp[0] + 1, leftUp[1] + 1},
                new int[]{rightUp[0] + 1, rightUp[1] - 1},
                new int[]{rightBottom[0] - 1, rightBottom[1] - 1},
                new int[]{leftBottom[0] - 1, leftBottom[1] + 1}
        );
    }
}
