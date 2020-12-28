package mathPart;

public class Calc {

	public static int execute(int num){
		num += (int)(Math.random()*13+1);
		return num;
	}

	public static int parentExecute(int parentNum){
		parentNum += (int)(Math.random()*8+15);
		return parentNum;
	}
}
