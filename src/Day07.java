import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.corba.se.impl.orbutil.graph.GraphImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day07 {

  public ArrayList<String> getInput() throws IOException {
    String fileName = "C:\\Users\\Constantin\\IdeaProjects\\AdventOfCode2018\\src\\Inputs\\Day07Input_test.txt";
    ArrayList<String> input = new ArrayList<>();
    Files.lines(Paths.get(fileName)).forEach(input::add);

    ArrayList<Character> right = new ArrayList<>();
    ArrayList<Character> left = new ArrayList<>();
    HashMap<Character, HashSet<Character>> adjList = new HashMap<>();

    HashMap<String, String> pairs = new HashMap<>();
    Pattern pattern = Pattern.compile("Step (.) must be finished before step (.) can begin\\.");
    Matcher matcher;

    for (String line : input) {
      matcher = pattern.matcher(line);
      if (matcher.find()) {
        pairs.put(matcher.group(1), matcher.group(2));
        left.add(matcher.group(1).charAt(0));
        right.add(matcher.group(2).charAt(0));
      }
    }

    System.out.println(left);
    System.out.println(right);

    for (Map.Entry<String, String> entry : pairs.entrySet()) {
      System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());

    }
    return input;
  }
}
