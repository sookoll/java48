package ee.itcollege.practicum1;

public class Table {
	
	public static void main(String[] args) {
		
		int size = 10;
		
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
//				if (col < row) {
//					System.out.print((size - 1 -row) + " ");
//				} else {
//					System.out.print((size - 1 -col) + " ");
//				}
//				System.out.print((size - 1 - (col < row ? row : col)) + " ");
//				System.out.print((size - 1 - Math.max(col, row)) + " ");
//				System.out.format("%d ", (size - 1 - Math.max(col, row)));
				System.out.print(String.format("%d ", (size - 1 - Math.max(col, row))));
			}
			System.out.println();
		}
	}
}