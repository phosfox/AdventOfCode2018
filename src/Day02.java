import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day02 {

  private int twos = 0;
  private int threes = 0;

  public int getTwos() {
    return twos;
  }

  public void setTwos(int twos) {
    this.twos = twos;
  }

  public int getThrees() {
    return threes;
  }

  public void setThrees(int threes) {
    this.threes = threes;
  }

  private int[] countLetter(String s) {
    int total2 = 0, total3 = 0;
    HashMap<Character, Integer> hs = new HashMap<>();
    int[] totals = new int[2];

    for (Character c : s.toCharArray()) {
      if (hs.containsKey(c)) {
        hs.put(c, hs.get(c) + 1);
      } else {
        hs.put(c, 1);

      }
    }

    for (Map.Entry<Character, Integer> entry : hs.entrySet()) {
      Integer value = entry.getValue();

      if (total2 == 0 && value == 2) {
        total2++;
      }
      if (total3 == 0 && value == 3) {
        total3++;
      }
      if (total2 != 0 && total3 != 0) {
        break;
      }
    }

    totals[0] = total2;
    totals[1] = total3;
    return totals;
  }

  private void addLettersUp(int[] arr) {
    if (arr[0] > 0) {
      this.twos++;
    }
    if (arr[1] > 0) {
      this.threes++;
    }
  }

  public int getChecksum(String s) throws IOException {
    ArrayList<String> fileContent = new ArrayList<>();
    Files.lines(Paths.get(s)).forEach(fileContent::add);
    int[] totals;

    for (String str : fileContent) {
      totals = countLetter(str);
      addLettersUp(totals);
    }

    return this.getTwos() * this.getThrees();
  }

  public String solvePart2(String file) throws IOException {
    ArrayList<String> fileContent = new ArrayList<>();
    Files.lines(Paths.get(file)).forEach(fileContent::add);

    for (String word : fileContent) {
      for (String comp : fileContent) {
        if (!word.equals(comp)) {
          if (diffByOne(word, comp)) {
            return revomeDiffChar(word, comp);
          }
        }
      }
    }
    return "";
  }

  public boolean diffByOne(String word, String comp) {
    int diffs = 0;
    char[] wordArr = word.toCharArray();
    char[] compArr = comp.toCharArray();

    if (word.length() != comp.length()) {
      return false;
    }

    for (int i = 0; i < word.length(); i++) {
      if (diffs > 1) {
        return false;
      }
      if (wordArr[i] != compArr[i]) {
        diffs++;
      }
    }

    return diffs == 1;
  }

  private String revomeDiffChar(String word, String comp) {
    char[] wordArr = word.toCharArray();
    char[] compArr = comp.toCharArray();
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      if (wordArr[i] != compArr[i]) {
        continue;
      }
      s.append(wordArr[i]);
    }
    return s.toString();
  }
}
