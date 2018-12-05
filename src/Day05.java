import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Day05 {

  public void solveDay05Part1(String fileName) throws IOException {
    String input = getInput(fileName);
    input = collapsePolymers(input);
    System.out.println(input);
    System.out.println("Polymer length: " + input.length());
  }

  public void solveDay05Part2(String fileName) throws IOException{
    String input = getInput(fileName);
    String helpInp;
    ArrayList<Integer> polymerSizes = new ArrayList<>();

    for (int i = 97; i <= 122; i++) {
      helpInp = removeCharFromString((char)i, input);
      helpInp = collapsePolymers(helpInp);
      polymerSizes.add(helpInp.length());
    }

    int min = polymerSizes.stream()
        .min(Comparator.comparing(Integer::valueOf))
        .get();

    System.out.println("Length of the shortest polymer: " +min);
  }

  private String removeCharFromString(char rmC, String s) {
    StringBuilder sb = new StringBuilder(s);
    for (int i = sb.length() - 1; i >= 0; i--) {
      if (rmC == Character.toLowerCase(sb.charAt(i))) {
        sb.deleteCharAt(i);
      }
    }
    return sb.toString();
  }

  private String getInput(String fileName) throws IOException {
    StringBuilder input = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      for (String line; (line = br.readLine()) != null; ) {
        input.append(line);
      }
    }
    return input.toString();
  }

  private String collapsePolymers(String s) {
    StringBuilder sb = new StringBuilder(s);
    int lengthBeforeCollapse = 1;
    int lengthAfterCollapse = 0;

    while (lengthBeforeCollapse > lengthAfterCollapse) {
      lengthBeforeCollapse = sb.length();
      for (int i = 0, k = 1; i < sb.length() - 1; i++, k++) {
        if (canCollapse(sb.charAt(i), sb.charAt(k))) {
          sb.delete(i, k+1);
          lengthAfterCollapse = sb.length();
        }
      }
    }
    return sb.toString();
  }


  private boolean canCollapse(char le, char ri) {
    return le + 32 == ri || ri + 32 == le;
  }
}
