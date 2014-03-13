
public class StringApplication
{
	public static String stringChange (String base,String sub ,String before ,String after)
	{
		String retval = null;
		if(findString(base, sub))
		{
			if(!findBeforString(base, sub, before))
			{
				if(!findAfterString(base, sub, after))
					retval=before+sub+after;
				else
				{
					base=base.replace(base.substring(0,base.indexOf(sub)), before);
					retval = base;
				}
			}
			else 
			{
				if(!findAfterString(base, sub, after))
				{
					base=base.replace(base.substring(base.indexOf(sub)+sub.length()), after);
					retval = base;
				}
				else
					retval=base;
			}	
		}
		else
			throw new IllegalArgumentException("stringChange...the subString does not exist");
		return retval;
	}
	public static boolean findString (String base,String sub)
	{
		boolean retval=true;
		if(base.indexOf(sub)==-1)
			retval=false;
		return retval;
	}
	public static boolean findBeforString (String base ,String sub,String beforString)
	{
		boolean retval=false;
		if(findString(base, sub)&& findString(base, beforString))
			if(base.indexOf(beforString)==(base.indexOf(sub)-(beforString.length())))
				retval =true;
		return retval;
	}
	public static boolean findAfterString (String base ,String sub,String afterString)
	{
		boolean retval=false;
		if(findString(base, sub)&& findString(base, afterString))
			if(base.indexOf(afterString)==base.indexOf(sub)+sub.length())
				retval =true;
		return retval;
	}
	
}
