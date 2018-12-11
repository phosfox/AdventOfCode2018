import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04 {

  private HashMap<Integer, Guard> guards;

  public Day04() {
    this.guards = new HashMap<>();
  }

  public void solvePart1And2() throws IOException {
    String fileName = "C:\\Users\\Constantin\\IdeaProjects\\AdventOfCode2018\\src\\Inputs\\Day04Input.txt";
    ArrayList<String> input = new ArrayList<>();
    Stack<Integer> guardStack = new Stack<>();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      for (String line; (line = br.readLine()) != null; ) {
        input.add(line);
      }
    }

    Collections.sort(input);

    Pattern guardP = Pattern.compile("Guard #(\\d+)");
    Pattern fallsP = Pattern.compile("(falls)");
    Pattern wakesP = Pattern.compile("(wakes)");
    Matcher guardM, fallsM, wakesM;

    for (String line : input) {
      guardM = guardP.matcher(line);
      fallsM = fallsP.matcher(line);
      wakesM = wakesP.matcher(line);
      if (guardM.find()) {

        if (!guardStack.empty()) {
          guardStack.pop();
        }

        int id = Integer.parseInt(guardM.group(1));

        Guard g = new Guard(id);
        if (!this.guards.containsKey(id)) {
          guards.put(id, g);
        }
        guardStack.push(g.getId());
      }
      if (fallsM.find()) {

        int t = Integer.parseInt(line.substring(15, 17));
        int id = guardStack.peek();
        this.guards.get(id).fallsAsleepAt(t);

      }
      if (wakesM.find()) {

        int t = Integer.parseInt(line.substring(15, 17));
        int id = guardStack.peek();
        this.guards.get(id).wakesUpAt(t);
      }
    }

    //Files.write(Paths.get(sortedFile), input);

    int max = 0;
    int maxGuardID = 0;
    int maxGuardMin = 0;
    int maxGuardSlept = 0;
    for (Map.Entry<Integer, Guard> entry : this.guards.entrySet()) {
      if (entry.getValue().getTimeAsleep() > max) {
        max = entry.getValue().getTimeAsleep();
        maxGuardID = entry.getValue().getId();
        maxGuardMin = entry.getValue().getMostMinsSlept();
        maxGuardSlept = entry.getValue().getMostAsleepMin();
      }
    }
    //Part 1
    System.out.println("Part 1");
    System.out.println("ID * maxGuardSlept: "
        + maxGuardID * maxGuardSlept);

    //Part 2
    max = 0;
    int id = 0;
    maxGuardMin = 0;
    for (Map.Entry<Integer, Guard> entry : this.guards.entrySet()) {
      for (Map.Entry<Integer, Integer> g : entry.getValue().getMinAsleep().entrySet()) {
        if (g.getValue() > max) {
          max = g.getValue();
          id = entry.getKey();
          maxGuardMin = entry.getValue().getMostAsleepMin();
        }
      }
    }
    System.out.println("Part 2");
    System.out.println("ID * maxGuardMin: " + id * maxGuardMin);
  }
}

