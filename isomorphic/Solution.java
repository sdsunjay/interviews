import java.util.Arrays;
class Solution {
    final static int size = 256;
    public static boolean solution(String s, String t) {
        if(s == null && t == null){
            return true;
        }
        if(s == null){
            return false;
        }
        if(t == null){
            return false;
        }
        int m = s.length();
        int n = t.length();

        if( m != n){
            return false;
        }
        boolean[] array = new boolean[size];
        int[] map = new int[size];
        Arrays.fill(map, -1);
        for(int i = 0; i < n; i++){
            if(map[s.charAt(i)] == -1){
                if(array[t.charAt(i)] == true){
                    return false;
                }
                array[t.charAt(i)] = true;
                map[s.charAt(i)] = t.charAt(i);
            }
            else if(map[s.charAt(i)] != t.charAt(i)){
                return false;
            }

        }
        return true;
    }
}
