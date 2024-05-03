public class Node implements Comparable<Node> {
    private final int FREQUENCY;
    private Node leftNode;
    private Node rightNode;

    public Node(Node leftNode, Node rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.FREQUENCY = leftNode.getFREQUENCY() + rightNode.getFREQUENCY();
    }

    public Node(int frequency) {
        this.FREQUENCY = frequency;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public int getFREQUENCY() {
        return FREQUENCY;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(FREQUENCY, node.getFREQUENCY());
    }
}
