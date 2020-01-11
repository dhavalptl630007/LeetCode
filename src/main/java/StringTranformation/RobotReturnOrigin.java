package StringTranformation;

public class RobotReturnOrigin {

	public static void main(String[] args) {
		
		String moves = "UD";
		System.out.println(judgeCircle(moves));
	}

	private static boolean judgeCircle(String moves) {
		
	 int x = 0, y = 0;
		
	 for (char move: moves.toCharArray()) {
		
		  if(move == 'U') y--;
		  if(move == 'D') y++;
		  if(move == 'L') x++;
		  if(move == 'R') x--;
	 }	
	return x==0&&y==0;
}

}
