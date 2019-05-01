package leetcode;

/**
 * 字典树
 */
class Trie {

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
    public Trie() {
        this.root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
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
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.nodes[index] == null) {
                return false;
            }
            node = node.nodes[index];
        }
        //最后需要根据标记位来判断是否后面还有字母
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.nodes[index] == null) {
                return false;
            }
            node = node.nodes[index];
        }
        //循环走完就说明字典中是存在这个字符的
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */