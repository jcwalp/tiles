import java.util.Scanner;


public class Runner extends Room {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		//System.out.println("1: ");
		//int fs1 = kb.nextInt();
		//System.out.println("2: ");
		//int fs2 = kb.nextInt();
		//System.out.println("3: ");
		//int wh = kb.nextInt();
		//System.out.println("4: ");
		//int fc = kb.nextInt();
		Room r = new Room();
		r.fillRoom(r);
		r.printFloor(r);

	}

}
