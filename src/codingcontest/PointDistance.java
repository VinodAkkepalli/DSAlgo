package codingcontest;


public class PointDistance
{
	public int[] findPoint(int x1, int y1, int x2, int y2)
	{
		if(y1 == y2){
			return new int[]{x2,y2+1};
		}else if(x1 == x2){
			return new int[]{x2+1,y2};
		}else{
			return new int[]{2 * x2-x1, 2 * y2-y1};
		}
	}
	
	public static void main(String[] args)
	{
		long time;
		int[] answer;
		boolean errors = false;
		int[] desiredAnswer;
		
		boolean same;
		
		time = System.currentTimeMillis();
		answer = new PointDistance().findPoint(-1, 0, 1, 0);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{8, 48 };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new PointDistance().findPoint(1, 1, -1, -1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{25, -63 };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new PointDistance().findPoint(0, 1, 2, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{41, 65 };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new PointDistance().findPoint(5, -4, -2, 5);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{68, 70 };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new PointDistance().findPoint(-50, -50, 50, -50);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{67, 4 };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new PointDistance().findPoint(-50, 50, -49, 49);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new int[]{73, -25 };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ " + answer[0]);
			for (int i=1; i<answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
