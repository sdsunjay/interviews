public class FindFirstRepeatedCharacter{
    public static char findFirstRepeatedCharacter(String s){
        boolean[] list = new boolean[26];
        for(int i=0;i<s.length();i++)
        {
            int index = s.charAt(i)-'a';
            if(list[index])
                return s.charAt(i);
            list[index] = true;
        }
        return '0';
    }
}
