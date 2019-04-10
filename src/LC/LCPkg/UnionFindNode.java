package LC.LCPkg;

public class UnionFindNode {
    int id;
    int size;
    UnionFindNode parent;
    public UnionFindNode() {
        size = 1;
        parent = this;
    }
    public UnionFindNode(int id) {
        this();
        this.id = id;
    }
}
