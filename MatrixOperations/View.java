package lab_05;

public class View {
	
	
	
	public void ViewStart(){
		
		System.out.println(" (1) Wprowadź macierze wejściowe");
		System.out.println("(2) Operacje arytmetyczne");
		System.out.println("(3) Wyświetl macierze");
		System.out.println("wprowadz numer: ");
		
		
	}
	
	public void View1() {
		System.out.println(" (1) Wprowadź macierze wejściowe");

	}
	public void View2() {
		System.out.println("(2) Operacje arytmetyczne");
		System.out.print("(2.1) Transponuj macierze wejściowe\r\n"
				+ "(2.2) Pomnóż macierze wejściowe\r\n"
				+ "(2.3) Transponuj macierz wynikową");
		

	}
	public void View3() {
		System.out.println(" Wyświetl macierze\r\n"
				+ "(3.1) Wyświetl macierze wejściowe\r\n"
				+ "(3.2) Wyświetl macierz wynikową\r\n"
				);

	}
	
	
	public void View2_1() {
		System.out.println("macierz A zostala transponowana\r\n"
				);

	}
	
	public void View2_2() {
		System.out.println("macierze zostaly pomnozone");

	}
	public void View2_3() {
		System.out.println( "macierz wynikowa zostala transponowana");

	}
	public void View3_1() {
		System.out.println(
				 " macierze wejściowe: \r\n"
				);

	}
	public void View3_2() {
		System.out.println(
				" macierz wynikowa: \r\n"
				);

	}
	
	
	public void Viev1_podajkolumnyiwiersze() {
		System.out.println( "podaj liczbe kolumn i wierszy:");
	}
	
	public void Viev1_podajkolumnyiwiersze2() {
		System.out.println( "podaj liczbe kolumn i wierszy 2 macierzy:");
	}
	
	public void Viev1_podajelement_kolumny_wierszy(int c, int r) {
		System.out.println( "podaj element w kolumnie "+c+" w wierszu "+ r);
	}

	
	
	
	public void printMatrix(Matrix m) {
		
	System.out.println("macierz: ");
	
	
		for(int i=0;i<m.getColumns();i++) {
			for(int j=0;j<m.getRows();j++) {
				System.out.print(m.getElement(i, j)+" ");
			}
			System.out.println();	
	}
	}
	
	
	

}
