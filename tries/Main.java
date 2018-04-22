
// https://www.geeksforgeeks.org/trie-insert-and-search/

import java.util.Scanner;
public class Main {

    public static void handleLines(String[] words, String searchWord){
        Trie trie = new Trie(words);
        if(trie.search(searchWord)) {
                System.out.println("1");
        } else {
                System.out.println("0");
        }
    }
    // Driver
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String searchWord = null;
        if(scan.hasNextInt()){
            int num_test_cases = scan.nextInt();
            // System.out.println("Number of Test Cases: " + num_test_cases);
            for(int i = 0 ; i < num_test_cases ; i++){
                int num_words = scan.nextInt();
                String[] words = new String[num_words];
                for(int j = 0; j < num_words; j++){
                    if(scan.hasNext()){
                        words[j] = scan.next();
                        // System.out.println(words[j]);
                    }
                }
                if(scan.hasNext()){
                    searchWord = scan.next();
                }
                handleLines(words, searchWord);
            }
        }

    }
}
