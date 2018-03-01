// LinkedIn Interview
public double pow(double base, int exponent)
{

	double result;
	boolean neg;

	result = 1;
	neg = false;

	if (exponent == 0)
		return result;
	if ( exponent < 0)
	{
		exponent*=-1;
		neg = true;
	}	
	while (exponent > 0)
	{
		if(exponent > 0)
			result*=base;
		base*=base;
	}

}
