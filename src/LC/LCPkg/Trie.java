package LC.LCPkg;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode('\0');
    }
    public void addWord(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.children[ch] == null) {
                cur.children[ch] = new TrieNode(ch);
            }
            cur = cur.children[ch];
        }
        cur.isLeaf = true;
    }
    public List<String > searchByPrefix(String prefix) {
        List<String> res = new ArrayList<>();
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            cur = cur.children[ch];
            if (cur == null) {
                return res;
            }
        }
        dfs(res, cur, new StringBuilder(prefix));
        return res;
    }
    private void dfs(List<String> res, TrieNode cur, StringBuilder path) {
        if (cur.isLeaf) {
            res.add(path.toString());
        }
        for (TrieNode next : cur.children) {
            if (next != null) {
                path.append(next.ch);
                dfs(res, next, path);
                path.setLength(path.length() - 1);
            }
        }
    }

}
