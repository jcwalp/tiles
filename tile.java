import java.util.Scanner;
public class TileCount {
	public static final Scanner kb = new Scanner(System.in);
	public static int w = 1, r = 2, b = 3;
	public static int currentColor;
	public static int colorAbove;
	public static int fs1, fs2, wh;


	public static void main(String[] args) {
		System.out.println("1: ");
		fs1 = kb.nextInt();
		System.out.println("2: ");
		fs2 = kb.nextInt();
		System.out.println("3: ");
		wh = kb.nextInt();
		System.out.println("C: ");
		currentColor = kb.nextInt();
		int[][] floor =  new int[fs1][fs2];
		int[][] wT = new int[wh][fs2];
		int[][] wR = new int[fs1][wh];
		int[][] wB = new int[wh][fs2];
		int[][] wL = new int[fs1][wh];

		fillFloor(floor);



		for (int i = 0; i < floor[0].length; i++) {
			for (int j = 0; j < floor.length; j++) {
				System.out.print(floor[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < wh; i++) {
			wT[i] = floor[i];
		}

		for (int i = 0; i < fs1; i++) {
			wR[i] = floor[i];
		}

		for (int i = 0; i < wR.length; i++) {
			for (int j = 0; j < wR[0].length; j++) {
				System.out.print(wR[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void fillFloor(int[][] floor) {
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < floor.length; j++) {
				floor[i][j] = currentColor;
				changeColor();
			}
		}

		for (int i = 1; i < floor[0].length; i++) {
			for (int j = 0; j < floor.length; j++) {
				colorAbove = floor[i-1][j];
				floor[i][j] = compareColor();

			}
		}
	}

	public static void changeColor() {
		if (currentColor == w) {
			currentColor = r;
		}
		else if (currentColor == r) {
			currentColor = b;
		}
		else {
			currentColor = w;
		}
	}

	public static int compareColor() {
		int currentColor2;
		if (colorAbove == w) {
			currentColor2 = b;
		}
		else if (colorAbove == r) {
			currentColor2 = w;
		}
		else {
			currentColor2 = r;
		}
		return currentColor2;
	}

	public static void printFloor(int[][] f) {

	}





}
