public class Node {
    public Node next;
    public Point position;
    public Node(Point position, Node next) {
        this.position = position;
        this.next = next;
    }
}
