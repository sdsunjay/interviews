public class Driver
{

	public static void main(String[] args)
	{

		FindNumber findNum = new FindNumber("this is a very long word without a number!?");
		System.out.println("Expected: False");
		System.out.println(findNum.findNumber());
		findNum.setText("this is a very long word with5 a number!?");
		System.out.println("Expected: True");
		System.out.println(findNum.findNumber());
	}

}
