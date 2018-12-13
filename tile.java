
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
		floor = new int[fs1][fs2];
		wT = new int[wh][fs2];
		wR = new int[fs1][wh];
		wB = new int[wh][fs2];
		wL = new int[fs1][wh];
	}

	public Room fillRoom(Room r){
		Room q = r;
		q.floor = fillFloor(q.floor);
		q.wT = q.floor;
		return q;
	}

	public int[][] fillFloor(int[][] f){
		for (int i = 0; i < 1; i++){
			for (int j = 0; j < f.length; j++){
				f[i][j] = currentColor;
				changeColor();
			}
		}
		for (int i = 1; i < f[0].length; i++){
			for (int j = 0; j < f.length; j++){
				colorAbove = f[i-1][j];
				f[i][j] = compareColor();
			}
		}
		return f;
	}



	public void changeColor(){
		if (currentColor == w){
			currentColor = r;
		}
		else if (currentColor == r){
			currentColor = b;
		}
		else {
			currentColor = w;
		}
	}

	public int compareColor(){
		int color;
		if (colorAbove == w){
			color = b;
		}
		else if (colorAbove == r){
			color = w;
		}
		else {
			color = r;
		}
		return color;
	}

	public void printFloor(Room r){
		System.out.println("---------TOP---------");
		System.out.println();
		for (int i = 0; i < r.wh; i++){
			for (int j = 0; j < r.fs2; j++){
				System.out.print(r.wT[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------FLOOR---------");
		System.out.println();
		for (int i = 0; i < r.fs1; i++){
			for (int j = 0; j < r.fs2; j++){
				System.out.print(r.floor[i][j] + " ");
			}
			System.out.println();
		}


	}
}
