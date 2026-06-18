
public class PascalTriangle {
	public static final int LINES = 10;
	public static final String SYMBOL = " ";
	
	public static void printEmptyCell(int maxDigits) {
		for(int i = 0; i < maxDigits; i++) {
			System.out.print(SYMBOL);
		}
	}
	
	public static void printNumberInCell(int maxDigits, int number) {
		int currentDigits = String.valueOf(number).length();
		int leftField = (maxDigits - currentDigits)/2;
		int rightField = maxDigits - currentDigits - leftField;
		
		for(int i = 0; i < leftField; i++) {
			System.out.print(SYMBOL);
		}
		
		System.out.print(number);
		
		for(int i = 0; i < rightField; i++) {
			System.out.print(SYMBOL);
		}
	}
	
	public static void main(String[] args) {
		// old part
		int p[][] = new int[LINES][];
		
		p[0] = new int[1];
		System.out.println(p[0][0] = 1);
		
		p[1] = new int[2];
		p[1][0] = p[1][1] = 1;
		System.out.println(p[1][0] + " " + p[1][1]);
		
		for(int i = 2; i < LINES; i++) {
			p[i] = new int[i+1];
			System.out.print((p[i][0] = 1) + " ");
			for(int j = 1; j < i; j++) {
				System.out.print((p[i][j] = p[i-1][j-1] + p[i-1][j]) + " ");
			}
			System.out.println(p[i][i] = 1);
		}
		//----------------------------------
		
		int digits = (LINES == 0) ? 1 : (int) (LINES * Math.log10(2) - 0.5 * Math.log10(Math.PI * LINES / 2.0)) + 1;
		int number[][] = new int[LINES][];
		int field = LINES%2 == 0 ? LINES - 1 : LINES;
		
		for(int i = 0; i < LINES; i++) {
			number[i] = new int[i+1];
			int charactersPerLine = 2*i + 1;
			int newField = field - i;
			
			// Printing left field
			for(int j = 0; j < newField; j++) {
				printEmptyCell(digits);
			}
			
			// Printing numbers
			int m = 0;
			for(int j = 0; j < charactersPerLine; j++) {
				if(j%2 > 0) {
					printEmptyCell(digits);
				} else {
					if(m == 0 || m == number[i].length-1) {
						number[i][m] = 1;
						printNumberInCell(digits, number[i][m]);
					} else {
						number[i][m] = number[i-1][m-1] + number[i-1][m];
						printNumberInCell(digits, number[i][m]);
					}
					m++;
				}
			}
			
			// Printing right field
			for(int j = 0; j < newField; j++) {
				printEmptyCell(digits);
			}
			
			System.out.print("\n");
		}
	}
}
