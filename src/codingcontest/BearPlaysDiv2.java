package codingcontest;

public class BearPlaysDiv2 {

	public static void main(String[] args) {
		
	}

	public String equalPiles(int A, int B, int C){
		
		
		
		if( (A+B+C)%3 == 0){
			
			return "possible";
		}else{
			return "impossible";
		}
	}
}
