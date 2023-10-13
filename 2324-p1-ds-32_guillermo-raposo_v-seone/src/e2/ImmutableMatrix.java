package e2;

import java.util.Arrays;

public class ImmutableMatrix {
    private final int[][] matriz;

    public ImmutableMatrix(int[][] arr) {
        if (!isRegular(arr)) {
            throw new IllegalArgumentException("La matriz es irregular");
        }

        int rows = arr.length;
        int columns = arr[0].length;
        matriz = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            System.arraycopy(arr[i], 0, matriz[i], 0, columns);
        }
    }

    public ImmutableMatrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Valores de filas y columnas irregulares");
        }

        matriz = new int[rows][columns];
        int num = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                matriz[r][c] = num;
                num = num + 1;
            }
        }
    }

    private ImmutableMatrix(int[][] matrix, boolean copy) {
        if (copy) {
            this.matriz = copyArray2D(matrix);
        } else {
            this.matriz = matrix;
        }
    }

    public int at(int row, int col) {
        if (row < 0 || row >= matriz.length || col < 0 || col >= matriz[0].length) {
            throw new IllegalArgumentException("Coordenadas no válidas.");
        }
        return matriz[row][col];
    }

    public int rowCount() {
        return matriz.length;
    }

    public int columnCount() {
        return matriz[0].length;
    }

    public int[][] toArray2D() {
        return copyArray2D(matriz);
    }

    public int[][] copyArray2D(int[][] source) {
        int rows = source.length;
        int columns = source[0].length;
        int[][] array2D = new int[rows][columns];

        for (int r = 0; r < rows; r++) {
            System.arraycopy(source[r], 0, array2D[r], 0, columns);
        }
        return array2D;
    }

    private boolean isRegular(int[][] arr) {
        if (arr.length == 0) {
            return true;
        }
        int expectedColumns = arr[0].length;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length != expectedColumns) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : matriz) {
            sb.append(Arrays.toString(ints)).append('\n');
        }
        return sb.toString();
    }

    public ImmutableMatrix reverse() {
        int rows = matriz.length;
        int columns = matriz[0].length;
        int[][] matrizReverse = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matriz[rows - 1 - i], 0, matrizReverse[i], 0, columns);
        }
        return new ImmutableMatrix(matrizReverse, true);
    }

    public ImmutableMatrix transpose() {
        int rows = matriz.length;
        int columns = matriz[0].length;
        int[][] matrizTranspose = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrizTranspose[j][i] = matriz[i][j];
            }
        }
        return new ImmutableMatrix(matrizTranspose, true);
    }

    public ImmutableMatrix reshape(int newColumns) {
        int rows = matriz.length;
        int columns = matriz[0].length;
        if (columns * rows % newColumns != 0) {
            throw new IllegalArgumentException("No se puede llevar a cabo el reshape para la matriz");
        }
        int newRows = columns * rows / newColumns;
        int[][] matrizReshape = new int[newRows][newColumns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int aux = i * columns + j;
                int newRow = aux / newColumns;
                int newCol = aux % newColumns;
                matrizReshape[newRow][newCol] = matriz[i][j];
            }
        }
        return new ImmutableMatrix(matrizReshape, true);
    }

}
