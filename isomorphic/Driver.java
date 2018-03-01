public class Driver
{

	public static void main(String args[])
	{
		Iso iso = new Iso();
		System.out.println("These two strings are isomorphic, 'app', 'mee'");
		System.out.println("Expected output: True");
		System.out.println(iso.iso("app","mee"));	
	}

}
