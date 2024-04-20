package lab_05;

import java.util.Scanner;




public class Controler {
	boolean contin = true;
	View view = new View();
	Matrix matrix1= new Matrix(0,0);
	Matrix matrix2= new Matrix(0,0);
	 Matrix result = new Matrix(0,0);
	Model model = new Model();
	
public static void main(String ...args) {
	
	Controler controler = new Controler();
	
}






	Controler(){
		
		
		do {
		
		view.ViewStart();
		
		Scanner scaner = new Scanner(System.in);
		int number = scaner.nextInt();
		
		switch(number) {
		case 1: view.View1();
		this.insertArray();
			break;
		case 2: view.View2();
					Scanner scaner2 = new Scanner(System.in);
					int number2 = scaner.nextInt();
						switch(number2) {
					case 1: view.View2_1();
					 matrix1 = model.transpose(matrix1);
					//view.printMatrix(matrix1);
					break;
						
					case 2: view.View2_2();
					result = model.multiplication(matrix1,matrix2);
					//view.printMatrix(multiMatrix);
					break;
						
					case 3: view.View2_3(); 
					result = model.transpose(result);
					break;
					}
			
			break;
		
		
			
			
		case 3: view.View3();
				Scanner scaner3 = new Scanner(System.in);
				int number3 = scaner.nextInt();
				
		
				switch(number3) {
				case 1: view.View3_1();
				view.printMatrix(matrix1);
				view.printMatrix(matrix2);

				break;
					
				case 2: view.View3_2(); 
				view.printMatrix(result);
				 break;
				}
			
		break;
		
		}
		}while(contin);
		
	}
	
	
	
	public void insertArray(){
		
		
		
		view.Viev1_podajkolumnyiwiersze();
		Scanner scaner4 = new Scanner(System.in);
		int column = scaner4.nextInt();
		
		Scanner scaner5 = new Scanner(System.in);
		int rows = scaner5.nextInt();

	
		 matrix1= new Matrix(column,rows);
		

		for(int i=0;i<column;i++) {
			for(int j=0;j<rows;j++) {
				
				view.Viev1_podajelement_kolumny_wierszy(i+1, j+1);
				Scanner scaner10 = new Scanner(System.in);
				int e = scaner10.nextInt();
			
				matrix1.setElement(e,i ,j);
			}
				
	}
		
		
		
		
		
		view.Viev1_podajkolumnyiwiersze2();
		Scanner scaner7 = new Scanner(System.in);
		int column1 = scaner7.nextInt();
		
		Scanner scaner8 = new Scanner(System.in);
		int rows1 = scaner8.nextInt();

	
		 matrix2= new Matrix(column,rows);
		

		for(int i=0;i<column;i++) {
			for(int j=0;j<rows;j++) {
				
				view.Viev1_podajelement_kolumny_wierszy(i+1, j+1);
				Scanner scaner9 = new Scanner(System.in);
				int e = scaner9.nextInt();
			
				matrix2.setElement(e,i ,j);
			}
				
	}
	
	}
	

}
