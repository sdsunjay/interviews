import java.math.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.InputStreamReader;

public class Solution {

    // Complete the getMin function below.
    static int getMin(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        int n = s.length();
        int index = 0;
        while(s.charAt(index) == '0'){
            index++;
        }
        if(index == n){
            return 1;
        }
        return minPerfectSquares(s, index, n);
    }
    static int minPerfectSquares(String s, int index, int n){
        if(index == n){
            return 0;
        }
        double temp = 0;
        int result = -1;
        int numBreaks = 0;


        for(int i = index; i < n; i++){

            temp = temp * 16 + Integer.parseInt(s.substring(i, i+1), 16);
            if(temp == 0 || isPerfectSquare(temp) ){

                numBreaks = minPerfectSquares(s, i + 1, n);
                if(numBreaks != -1 && (result == -1 || 1 + numBreaks < result)){
                    result = numBreaks +1;
                    // System.out.println("Result: " + result);
                }
            }
        }
        return result;
    }
    static boolean isPerfectSquare(double temp){
        double temp1 = Math.sqrt(temp);
        return ((temp1 - Math.floor(temp1)) == 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int res = getMin(s);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

