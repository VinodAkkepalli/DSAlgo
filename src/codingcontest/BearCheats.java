package codingcontest;

public class BearCheats {

	public static void main(String[] args) {
		
		BearCheats ob = new BearCheats();
		System.out.println(ob.eyesight(3294, 1234));
	}

	public String eyesight(int A, int B){
		int count = 0;	
		while(A>0){
			if( (A % 10) != (B % 10)){
				++count;
			}
			A /= 10;
			B /= 10;
		}
		
		if(count < 2){
			return "happy";
		}else{
			return "glasses";
		}
				
	}
}
