public class Node {
    int x;
    int y;
    int val;
    int dist;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.val = x * 8 + y;
    }

    public int getVal() {
        return this.val;
    }

    public String toString() {
        return "(" + x + ", " + y + ")" + "\n" + this.dist;
    }
}
