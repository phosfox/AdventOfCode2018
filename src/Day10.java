import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Day10 {

  public static void main(String[] args) throws IOException, InterruptedException {
    new Day10().main();
  }

  private void main() throws IOException, InterruptedException {
    solvePart1();
  }

  private void solvePart1() throws IOException, InterruptedException {
    List<String> lines = Files.readAllLines(Paths.get(
        "C:\\Users\\Constantin\\IdeaProjects\\AdventOfCode2018\\src\\Inputs\\Day10Input_test.txt"));

    List<Point> points = new ArrayList<>();
    Pattern pattern = Pattern
        .compile("position=<(\\s*-?\\d+),(\\s*-?\\d+)> velocity=<(\\s*-?\\d+),(\\s*-?\\d+)>");
    Matcher matcher;

    for (String line : lines) {
      matcher = pattern.matcher(line);
      if (matcher.find()) {
        int posX = Integer.parseInt(matcher.group(1).trim());
        int posY = Integer.parseInt(matcher.group(2).trim());
        int velX = Integer.parseInt(matcher.group(3).trim());
        int velY = Integer.parseInt(matcher.group(4).trim());
        Point p = new Point(posX, posY, velX, velY);
        points.add(p);
      }
    }

    JFrame jframe = new JFrame("Drawing Points");
    jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jframe.setSize(600, 600);
    jframe.setLocation(200, 200);
    jframe.setBackground(Color.RED);
    jframe.setVisible(true);

    for (int i = 0; i < 1; i++) {
      for (Point p : points) {
        jframe.add(p);
        p.movePoint();
      }
    }


  }




}
