import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day05 {

  public void solveDay05Part1(String fileName) throws IOException {
    String input = getInput(fileName);
    input = collapsePolymers(input);
    System.out.println(input);
    System.out.println("Polymer length: " + input.length());
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
