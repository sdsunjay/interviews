class Solution {
    public static long solution(long[][] meals) {
        long max = 0;
        long enjoyment = 0;

        for(int i = 0; i < meals.length; i++){
            max = meals[i][0];
            for(int j = 0; j < meals[i].length; j++){
                if(meals[i][j] > max){
                    max = meals[i][j];
                }
            }
            enjoyment += max;
        }
        return enjoyment;
    }
}
