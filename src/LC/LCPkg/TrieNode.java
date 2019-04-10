package LC.LCPkg;

public class TrieNode {
    public char ch;
    public boolean isLeaf;
    public TrieNode[] children;

    public TrieNode(char ch) {
        this.ch = ch;
        this.isLeaf = false;
        children = new TrieNode[256];
    }
}
