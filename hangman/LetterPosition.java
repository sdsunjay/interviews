   public class LetterPosition{
   
      char c;
      int position;
      int length;
      public LetterPosition(char c, int position, int length)
      {
	 this.c=c;
	 this.position = position;
	 this.length = length;
      }
      public String toString()
      {
	 return "for length "+length+" "+c+" at "+ position;
      }

	/**
 *
 * Eriq wrote this and we need to fix it.
 */
      public int hashCode() {
         return ((int)c * 10000) + (position * 1000) + length;
      }

      public boolean equals(Object o)
      {
	 if(o instanceof LetterPosition)
	 {
	    LetterPosition LP = (LetterPosition) o;
	    if((LP.c == c) && (LP.position == position)  && (LP.length == length))
	    {
	       return true;
	    }
	 }
      return false;
      }
   }

