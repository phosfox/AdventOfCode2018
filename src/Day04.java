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
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04 {

  HashSet<Guard> guards;

  public Day04() {
    this.guards = new HashSet<>();
  }

  public void solvePart1() throws IOException {
    String fileName = "C:\\Users\\Constantin\\IdeaProjects\\AdventOfCode2018\\src\\Inputs\\Day04Input.txt";
    ArrayList<String> input = new ArrayList<>();
    Stack<Guard> guardStack = new Stack<>();
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
      System.out.println(line.substring(15,17));
      guardM = guardP.matcher(line);
      fallsM = fallsP.matcher(line);
      wakesM = wakesP.matcher(line);
      if (guardM.find()) {
        if (!guardStack.empty()) {
          guardStack.pop();
        }
        int id = Integer.parseInt(guardM.group(1));
        Guard g = new Guard(id);
        guards.add(g);
        guardStack.push(g);

      }
      if (fallsM.find()) {
        int t = Integer.parseInt(line.substring(15,17));
        guardStack.peek().fallsAsleepAt(t);
      }
      if (wakesM.find()) {

      }
    }
    //Files.write(Paths.get(sortedFile), input);

  }
}
