import java.util.Scanner;
public class Tiles {
	public static int w = 1, r = 2, b = 3;
	public static int currentColor = w;
	public static int colorAbove;

	public static void main(String[] args) {
		int[][] floor =  new int[4][4];

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 4; j++) {
				floor[i][j] = currentColor;
				changeColor();
			}
		}

		for (int i = 1; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				colorAbove = floor[i-1][j];
				floor[i][j] = compareColor();

			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(floor[i][j] + " ");
			}
			System.out.println();
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





}
