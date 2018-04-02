public class Driver{


	public static void main(String[] args)
	{
		String[] strings = new String[3];
		strings[0] = new String("aghkafgklt");	
		strings[1] = new String("dfghako");
		strings[2] = new String("qwemnaarkf");
		CountCommonChars countCommonChars = new CountCommonChars(strings);
		System.out.println("Expected: 3");
		System.out.println(countCommonChars.countCommonChars());
	}
}
