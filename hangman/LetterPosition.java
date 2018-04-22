public class LetterPosition{

    public char c;
    public int position;
    public int length;

    public LetterPosition(char c, int position, int length) {
        this.c = c;
        this.position = position;
        this.length = length;
    }

    public String toString() {
        return "for length " + length+" " + c + " at " + position;
    }

    /**
     * @override hashCode
     */
    public int hashCode() {
        int result = 197;
        Character temp = new Character(c);
        result = 31 * result + temp.hashCode();
        result = 31 * result + position + length;
        System.out.println("the hashcode for this letter is: " + result);
        return result;
    }

    public boolean equals(Object o) {
        if(o instanceof LetterPosition) {
            LetterPosition LP = (LetterPosition) o;
            if((LP.c == c) && (LP.position == position)  && (LP.length == length)) {
                return true;
            }
        }
        return false;
    }
}

