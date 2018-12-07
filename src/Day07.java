import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day07 {

  public ArrayList<String> getInput() throws IOException {
    String fileName = "C:\\Users\\Constantin\\IdeaProjects\\AdventOfCode2018\\src\\Inputs\\Day07Input.txt";
    ArrayList<String> input = new ArrayList<>();
    Files.lines(Paths.get(fileName)).forEach(input::add);

    HashMap<String, String> pairs = new HashMap<>();
    Pattern pattern = Pattern.compile("Step (.) must be finished before step (.) can begin\\.");
    Matcher matcher;

    for (String line : input) {
      matcher = pattern.matcher(line);
      if (matcher.find()) {
        pairs.put(matcher.group(1), matcher.group(2));
      }
    }



    input.forEach(System.out::println);
    for (Map.Entry<String, String> entry : pairs.entrySet()) {
      System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());

    }
    return input;
  }
}
