public class Main {
    public static void main(String[] args) {
        Huffman huffman = new Huffman("aaaaaaaabbbbbbbccccdd");

        String encodedText = huffman.encode();
        System.out.println("Encoded text: " + encodedText);

        huffman.printCodes();

        String decodedText = huffman.decode(encodedText);
        System.out.println("Decoded text:" + decodedText);
    }
}
