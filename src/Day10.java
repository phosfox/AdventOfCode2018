import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Day10 {

  private ArrayList<Point> points;
  private int minX, minY, maxX, maxY;
  private HashMap<Integer, Integer> xyMap;

  public Day10() throws IOException {
    points = getPoints();
    xyMap = new HashMap<>();
  }

  public static void main(String[] args) throws IOException {
    new Day10().main();
  }

  private void main() throws IOException {
    System.out.println(getMinArea());
    displayPoints();
  }

  private void setBounds() {
    minX = points.stream().map(Point::getPosX).min(Integer::compareTo).get();
    minY = points.stream().map(Point::getPosY).min(Integer::compareTo).get();
    maxX = points.stream().map(Point::getPosX).max(Integer::compareTo).get();
    maxY = points.stream().map(Point::getPosY).max(Integer::compareTo).get();
  }

  private BigInteger getArea() {
    setBounds();
    int a = maxX - minX + 1;
    int b = maxY - minY + 1;
    BigInteger area = BigInteger.valueOf(a);
    area = area.multiply(BigInteger.valueOf(b));
    return area;
  }

  private void movePointsBy(int t) {
    for (Point p : this.points) {
      p.movePoint(t);
    }
  }

  private void putPointsIntoMap() {
    for (Point p : points) {
      xyMap.putIfAbsent(p.getPosX(), p.getPosY());
    }
  }

  private boolean isInPoints(int x, int y) {
    for (Point p : points) {
      if (p.getPosX() == x && p.getPosY() == y) {
        return true;
      }
    }
    return false;
  }

  private int getMinArea() {
    BigInteger prev = getArea();
    for (int i = 1; i < 12000; i++) {
      movePointsBy(i);
      BigInteger a = getArea();
      if (a.compareTo(prev) > 0) {
        return i - 1;
      }
      prev = a;
    }
    return -1;
  }


  private void displayPoints() {
    putPointsIntoMap();
    ArrayList<ArrayList<Character>> rows = new ArrayList<>();
    for (int y = minY; y < maxY + 1; y++) {
      ArrayList<Character> row = new ArrayList<>();
      for (int x = minX; x < maxX + 1; x++) {
        if (isInPoints(x, y)) {
          row.add('*');
        } else {
          row.add('_');
        }
      }
      rows.add(row);
    }
    for (ArrayList<Character> row : rows) {
      for (Character c : row) {
        System.out.printf("%c", c);
      }
      System.out.println(" ");
    }
  }


  private ArrayList<Point> getPoints() throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(
        "C:\\Users\\Constantin\\IdeaProjects\\AdventOfCode2018\\src\\Inputs\\Day10Input_2.txt"));

    points = new ArrayList<>();
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
    return points;
  }


}
