package lab_05;

public class Matrix {

    int columns;
    int rows;
    int[][] matrix;

    Matrix(int columns, int rows) {
        this.matrix = new int[columns][rows];
        this.columns = columns;
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public void setElement(int element, int columnIndex, int rowIndex) {
        matrix[columnIndex][rowIndex] = element;
    }

    public int getElement(int columnIndex, int rowIndex) {
        return matrix[columnIndex][rowIndex];
    }
}

	

