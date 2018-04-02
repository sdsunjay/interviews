// LinkedIn Interview
public class FindNumber
{
	String text;
	
	public FindNumber(String text)
	{
		this.text = text;
	}
	public boolean findNumber()
	{
		int value;
		for(int i =0; i < text.length();i++)
		{ 
			value = text.charAt(i)-'0';
			if(value >=0 && value <= 9)
			{
			//	System.out.println("Debug");
			//	System.out.println(text.charAt(i)-'0');
				return true;
			}
		}
		return false;
	}
	public void setText(String text)
	{
		this.text = text;
	}




}
