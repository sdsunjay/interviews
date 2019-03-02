public class Solution{
    // write a method to replace all spaces in a string with '%20'
    // you may assume the string has sufficient space at the end to hold additional characters
    // you are given the true length of the string, not the length of the char array
    public static void replaceSpaces(char[] str, int trueLength) {
    // first count the number of spaces in the string
    int spaceCount = 0;
    int index = 0;
    int i = 0;
    for(i = 0; i < trueLength; i++){
      if(str[i] == ' '){
        spaceCount++;
      }
    }
    // each space needs triple the amount of original space
    // however since the spaces were included in 'trueLength'
    // we need to only add double
    index = trueLength + (spaceCount * 2);
    if(trueLength < str.length){
      str[trueLength] = '\0'; // add the null character to end of the array

    }
    // edit the string in reverse
    for(i = trueLength - 1; i >= 0; i--) {
      if(str[i] == ' '){
       str[index - 1 ] = '0';
       str[index - 2] = '2';
       str[index - 3] = '%';
       index = index - 3;
      }
      else {
        str[index - 1] = str[i];
        index--;
      }
    }
  }
}
