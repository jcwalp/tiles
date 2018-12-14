import java.util.Scanner;
public class Tiles {
	public static int w = 1, r = 2, b = 3;
	public static int currentColor;
	public static int colorAbove;
	public static int[][] floor, wT, wR, wB, wL;
	public static int fs1, fs2, wh;
	public static final Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Floor Side 1: ");
		fs1 = kb.nextInt();
		System.out.println("Floor Side 2: ");
		fs2 = kb.nextInt();
		System.out.println("Wall Height: ");
		wh = kb.nextInt();
		System.out.println("First Color (W = 1, R = 2, B = 3): ");
		currentColor = kb.nextInt();

		floor = new int[fs1][fs2];
		wT = new int[wh][fs2];
		wR = new int[fs1][wh];
		wB = new int[wh][fs2];
		wL = new int[fs1][wh];

		fillFloor();
		fillTop();
		fillRight();
		fillBottom();
		fillLeft();

		int[] count = tileCount();
		System.out.println("White: " + count[0] + " Red: " + count[1] + " Blue: " + count[2]);


	}

	public static void fillFloor() {
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < fs2; j++) {
				floor[i][j] = currentColor;
				changeColor();
			}
		}

		for (int i = 1; i < 4; i++) {
			for (int j = 0; j < fs2; j++) {
				colorAbove = floor[i-1][j];
				floor[i][j] = compareColor();

			}
		}
	}

	public static void fillTop() {
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < fs2; j++) {
				wT[i][j] = currentColor;
				changeColor();
			}
		}

		for (int i = 1; i < wh; i++) {
			for (int j = 0; j < fs2; j++) {
				colorAbove = wT[i-1][j];
				wT[i][j] = compareColor();
			}
		}
	}

	public static void fillRight() {
		currentColor = floor[0][fs2-1];
		changeColor();
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < wh; j++) {
				wR[i][j] = currentColor;
				changeColor();
			}
		}

		for (int i = 1; i < fs1; i++) {
			for (int j = 0; j < wh; j++) {
				colorAbove = wR[i-1][j];
				wR[i][j] = compareColor();
			}
		}
	}

	public static void fillBottom() {
		colorAbove = floor[fs1-1][0];
		currentColor = compareColor();
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < fs2; j++) {
				wB[i][j] = currentColor;
				changeColor();
			}
		}

		for (int i = 1; i < wh; i++) {
			for (int j = 0; j < fs2; j++) {
				colorAbove = wB[i - 1][j];
				wB[i][j] = compareColor();
			}
		}
	}

	public static void fillLeft() {
		currentColor = floor[0][0];
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < wh; j++) {
				wL[i][j] = currentColor;
				changeColor();
			}
		}

		for (int i = 1; i < fs1; i++) {
			for (int j = 0; j < wh; j++) {
				colorAbove = wL[i-1][j];
				wL[i][j] = compareColor();
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

	public static int[] tileCount() {
		int[] count = new int[3];
		for (int i = 0; i < floor[0].length; i++) {
			for (int j = 0; j < floor.length; j++) {
				if (floor[i][j] == w) {
					count[0]++;
				}
				if (floor[i][j] == r) {
					count[1]++;
				}
				if (floor[i][j] == b) {
					count[2]++;
				}
			}
		}

		for (int i = 0; i < wh; i++) {
			for (int j = 0; j < fs2; j++) {
				if (wT[i][j] == w || wB[i][j] == w) {
					count[0]++;
				}
				if (wT[i][j] == r || wB[i][j] == r) {
					count[1]++;
				}
				if (wT[i][j] == b || wB[i][j] == b) {
					count[2]++;
				}
			}
		}

		for (int i = 0; i < fs1; i++) {
			for (int j = 0; j < wh; j++) {
				if (wR[i][j] == w || wL[i][j] == w) {
					count[0]++;
				}
				if (wR[i][j] == w || wL[i][j] == w) {
					count[1]++;
				}
				if (wR[i][j] == w || wL[i][j] == w) {
					count[2]++;
				}
			}
		}
		return count;
	}


}
