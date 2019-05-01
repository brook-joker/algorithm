package leetcode;


//["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
//[[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
public class LeetMain {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("bad");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
    }


}
