package lab_05;

public class Model {
	
	Model(){}
	
	public Matrix transpose(Matrix matrix) {
        Matrix transposedMatrix = new Matrix(matrix.getColumns(),matrix.getRows());

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                transposedMatrix.setElement(matrix.getElement( i,j), j, i);
            }
        }

        return transposedMatrix;
    }
	
	public Matrix multiplication(Matrix m1, Matrix m2) {
		if((m1.getColumns()!=m2.getColumns())||(m1.getRows()!=m2.getRows())) {
			throw new IllegalArgumentException("nie mozna mnozyc macierzy o roznych wymiarach");
		}
		
		Matrix result = new Matrix(m1.getColumns(),m1.getRows());
		
		   for (int i = 0; i < m1.getRows() ; i++) {
	            for (int j = 0; j < m2.getColumns(); j++) {
	                for (int k = 0; k < m1.getColumns(); k++) {
	                   
	                    int temp = m1.getElement(i, k) * m2.getElement(k, j);
	                    result.setElement((temp+  result.getElement(j, i))  , j, i);
	                    
	                    
	                }
	            }
	        }

	        return result;
	}
	

}
