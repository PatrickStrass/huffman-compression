import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Huffman {
    private Node root;
    private final String TEXT;
    private Map<Character, Integer> charFrequencies;
    private final Map<Character, String> HUFFMAN_CODES;

    public Huffman(String text) {
        this.TEXT = text;
        this.charFrequencies = new HashMap<>();
        this.HUFFMAN_CODES = new HashMap<>();

        fillCharFrequenciesMap();
    }

    private void fillCharFrequenciesMap() {
        for (char character : TEXT.toCharArray()) {
            Integer integer = charFrequencies.get(character);
            charFrequencies.put(character, integer == null ? 1 : integer + 1);
        }
    }

    public String encode() {
        Queue<Node> queue = new PriorityQueue<>();

        charFrequencies.forEach((character, frequency) ->
                queue.add(new Leaf(character, frequency)));

        while (queue.size() > 1) {
            queue.add(new Node(queue.poll(), queue.poll()));
        }

        generateHuffmanCodes(root = queue.poll(), "");

        return getEncodedText();
    }

    public String decode(String encodedText) {
        StringBuilder sb = new StringBuilder();
        Node current = root;

        for (char character : encodedText.toCharArray()) {
            current = character == '0' ? current.getLeftNode() : current.getRightNode();

            if (current instanceof Leaf) {
                sb.append(((Leaf) current).getCHARACTER());
                current = root;
            }
        }

        return sb.toString();
    }

    public void printCodes() {
        HUFFMAN_CODES.forEach((character, code) ->
                System.out.println(character + ": " + code));
    }

    private void generateHuffmanCodes(Node node, String code) {
        if (node instanceof Leaf) {
            HUFFMAN_CODES.put(((Leaf) node).getCHARACTER(), code);

            return;
        }

        generateHuffmanCodes(node.getLeftNode(), code.concat("0"));
        generateHuffmanCodes(node.getRightNode(), code.concat("1"));
    }

    private String getEncodedText() {
        StringBuilder sb = new StringBuilder();

        for (char character : TEXT.toCharArray()) {
            sb.append(HUFFMAN_CODES.get(character));
        }

        return sb.toString();
    }
}
