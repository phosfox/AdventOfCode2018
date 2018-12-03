import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class Day03 {

  public ArrayList<Rectangle> parseRectangles(String fileName) throws IOException {
    ArrayList<Rectangle> rectangles = new ArrayList<>();
    Pattern pattern = Pattern.compile("(\\d*)\\s@\\s(\\d*),(\\d*):\\s(\\d*)x(\\d*)");
    Matcher matcher;

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      for (String line; (line = br.readLine()) != null; ) {
        matcher = pattern.matcher(line);
        if (matcher.find()) {
          int number = Integer.parseInt(matcher.group(1));
          int x = Integer.parseInt(matcher.group(2));
          int y = Integer.parseInt(matcher.group(3));
          int width = Integer.parseInt(matcher.group(4));
          int height = Integer.parseInt(matcher.group(5));

          Rectangle r = new Rectangle(number, x, y, width, height);
          rectangles.add(r);
        }
      }
    }
    return rectangles;
  }

  public int solveDay03Part1(String fileName) throws IOException {
    ArrayList<Rectangle> recs = parseRectangles(fileName);
    //recs.forEach(System.out::println);
    int claimedInches = 0;
    int claimedTwice = 0;

    for (int x = 0; x <= 1000; x++) {
      for (int y = 0; y <= 1000; y++) {
        Rectangle oneByOne = new Rectangle(0, x, y, 1, 1);
        for (Rectangle r : recs) {
          if (r.overlapsWith(oneByOne)) {
            claimedTwice++;
          }
          if (claimedTwice >= 2) {
            claimedInches++;
            claimedTwice = 0;
            break;
          }
        }
        claimedTwice = 0;
      }
    }
    return claimedInches;
  }

}


