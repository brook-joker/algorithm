package leetcode;

public class WordDictionary {
    class Node {
        Node[] nodes;
        boolean isEnd;

        public Node() {
            this.nodes = new Node[26];
            this.isEnd = false;
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node node = root;
        //每一个字符进行循环判断向root中插入
        for (char c : word.toCharArray()) {
            //计算索引[0-26)
            int index = c - 'a';
            //如果不存在 则在对应的位置中进行插入
            if (node.nodes[index] == null) {
                node.nodes[index] = new Node();
            }
            //存在则跳到下一个字符进行判断
            node = node.nodes[index];
        }
        //循环完成现在node是最后一个字符 将标记位设置为true表示是一个词而不是前缀
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }


    public boolean searchHelper(String word, int len, Node node) {
        if (len == word.length() && node.isEnd) return true;
        if (len == word.length()) return false;
        char c = word.charAt(len);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.nodes[i] != null) {
                    if (searchHelper(word, len + 1, node.nodes[i])) {
                        return true;
                    }
                }
            }
        } else {
            int index = c - 'a';
            node = node.nodes[index];
            if (node == null) {
                return false;
            }
            return searchHelper(word, len + 1, node);
        }
        return false;
    }
}
