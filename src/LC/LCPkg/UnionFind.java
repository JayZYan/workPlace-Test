package LC.LCPkg;

public class UnionFind {
    public boolean find(UnionFindNode p, UnionFindNode q) {
        return findRoot(p) == findRoot(q);
    }
    public void union(UnionFindNode p, UnionFindNode q) {
        UnionFindNode rootP = findRoot(p);
        UnionFindNode rootQ = findRoot(q);

        if (rootP.size <= rootQ.size) {
            rootP.parent = rootQ;
            rootQ.size += rootP.size;
        } else {
            rootQ.parent = rootP;
            rootP.size += rootQ.size;
        }
    }
    private UnionFindNode findRoot(UnionFindNode node) {
        UnionFindNode cur = node;
        while (cur.parent != cur) {
            cur.parent = cur.parent.parent;
            cur = cur.parent;
        }
        node.parent = cur;
        return cur;
    }
}
