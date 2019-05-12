public class Solution{
  public String a;
  public String b;

  public Solution(String a, String b){
    this.a = a;
    this.b = b;
  }

  public String longestCommonSubsequenceWithDynamic(){
    recursive(a.toCharArray(), b.toCharArray())
  }
  private StringBuilder recursive(char[] one, char[] two){
    if(one[0] == two[0]){

    }
  }

  public String longestCommonSubsequence(){
    char[] one = a.toCharArray();
    char[] two = b.toCharArray();
    int j;
    StringBuilder result = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    int length = 0;
    int index = 0;
    for(int i = 0; i < one.length; i++){

      System.out.println("Character: " + one[i]);
      do{
        index = checkThisChar(one[i], two);
        if(index != -1){
          j = i;
          while(j < one.length && two[index] == one[j]){

            temp.append(one[j]);
            index++;
            j++;
            System.out.println("temp: " + temp);
          }
        }
        if(temp.length() > length){
          result = temp;
          length = temp.length();
        }
      } while(index != -1);
    }

    return result.toString();

  }

  public int checkThisChar(char c, char[] two){


    for(int i = 0; i < two.length; i++){
      if(c == two[i]){
        return i;
      }
    }
    return -1;
  }

}
