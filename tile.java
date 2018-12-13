
public class Room {

	private int[][] floor, wT, wR, wB, wL;
	private int fs1, fs2, wh;
	private int currentColor;
	private int colorAbove;
	private int w = 1, r = 2, b = 3;

	public Room(){
		fs1 = 4;
		fs2 = 4;
		wh = 3;
		currentColor = w;
		floor = new int[fs1][fs2];
		wT = new int[wh][fs2];
		wR = new int[fs1][wh];
		wB = new int[wh][fs2];
		wL = new int[fs1][wh];
	}

	public Room(int f1, int f2, int wH, int fc){
		fs1 = f1;
		fs2 = f2;
		wh = wH;
		currentColor = fc;
		wT = new int[wh][fs2];
		wR = new int[fs1][wh];
		wB = new int[wh][fs2];
		wL = new int[fs1][wh];
	}

}
