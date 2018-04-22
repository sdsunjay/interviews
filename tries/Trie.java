public class Trie {

	// Alphabet size (# of symbols)
	static final int ALPHABET_SIZE = 26;

	// trie node
	private static class Node {
		Node[] children = new Node[ALPHABET_SIZE];

		// isEndOfWord is true if the node represents
		// end of a word
		boolean isEndOfWord;

		Node(){
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++){
				children[i] = null;
			}
		}
		private void setIsEndOfWord(boolean isEndOfWord){
			this.isEndOfWord = isEndOfWord;
		}
		private boolean getIsEndOfWord(){
			return isEndOfWord;
		}
	};

	static Node root;

	public Trie(String[] words){
		root = new Node();
        buildTrie(words);
	}

	private void buildTrie(String[] words){

		for(int i = 0; i<words.length; i++){
			insertWord(words[i]);
		}
	}

	private void insertWord(String word){
		Node n = root;
		for(int j = 0; j<word.length(); j++){

			int value = (int)(word.charAt(j)-'a');
			// System.out.println("Value: " + value);
            if(n.children[value] == null){
				n.children[value] = new Node();
			}
			n = n.children[value];
		}
		n.setIsEndOfWord(true);
	}

    /**
     * Removes a letter
     */
    private void removeLetter(char c){
		Node n = root;
        int value = (int)(c-'a');
		n.children[value] == null;
	}

	public boolean search(String word){
		Node n = root;
		for(int j = 0; j<word.length(); j++){

			int value = (int)(word.charAt(j) - 'a');
			if(n.children[value] == null){
				return false;
			}
			n = n.children[value];
		}
		return (n != null && n.getIsEndOfWord());
	}
}
