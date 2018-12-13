import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day08 {
  public static String INPUT_URL = "https://adventofcode.com/2018/day/8/input";
  public static String INPUT_FILE = "C:\\Users\\Constantin\\IdeaProjects\\AdventOfCode2018\\src\\Inputs\\Day08Input.txt";

  class Node {
    // primitive array indexing is *significantly* faster than iterating over collection
    private int metadata[];
    private int metaSum = 0;
    private int addIdx = 0;
    private List<Node> children = new LinkedList<>();

    public Node(int metadataSize) {
      metadata = new int[metadataSize];
    }

    public void addChild(Node node) {
      children.add(node);
    }

    public void addMetadata(Integer data) {
      metadata[addIdx] = data;
      addIdx++;
      metaSum += data;
    }

    public int getMetadataSum() {
      return metaSum;
    }

    public int part2Sum() {
      if (children.isEmpty()) {
        return metaSum;
      }

      int result = 0;
      for (int i = 0; i < metadata.length; i++) {
        if (metadata[i] > 0 && metadata[i] <= children.size()) {
          result += children.get(metadata[i] - 1).part2Sum();
        }
      }
      return result;
    }
  }

  private void parseNode(Queue<Integer> queue, Collection<Node> allNodes, Node parentNode) {
    int childCount = queue.remove();
    int metadataCount = queue.remove();
    Node node = new Node(metadataCount);
    allNodes.add(node);

    if (parentNode != null) {
      parentNode.addChild(node);
    }

    if (childCount != 0) {
      for (int i = 0; i < childCount; i++) {
        parseNode(queue, allNodes, node);
      }
    }

    if (metadataCount > 0) {
      for (int i = 0; i < metadataCount; i++) {
        node.addMetadata(queue.remove());
      }
    }
  }

  private void main() throws IOException {
    List<String> input = Files.readAllLines(Paths.get(INPUT_FILE));

    if (input == null || input.isEmpty()) {
      System.out.println("Input data set is empty!");
      return;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (String line : input) {
      String[] parts = line.split(" ");
      for (String part : parts) {
        queue.add(Integer.parseInt(part));
      }
    }

    List<Node> nodes = new LinkedList<>();
    parseNode(queue, nodes, null);

    System.out.printf("Parsed %d nodes.\n", nodes.size());

    // ********* Part 1
    int sum = 0;
    for (Node node : nodes) {
      sum += node.getMetadataSum();
    }

    System.out.printf("Sum of all metadata values: %d\n", sum);

    // ********* Part 2
    System.out.printf("Sum of the root node: %d\n", nodes.get(0).part2Sum());
  }

  public static void main(String[] args) throws IOException {
    new Day08().main();
  }


}
