package interviews;

public class AssertTest {

	Integer i;
	
	public static void main(String[] args) {
		Integer n = 10;

		assert false:(n.equals(21));
		System.out.println("What the hell");
	}

}
