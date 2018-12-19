import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day10 {

  public static void main(String[] args) throws IOException {
    new Day10().main();
  }

  private void main() throws IOException {
    solvePart1();
  }

  private void solvePart1() throws IOException {
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



    System.out.println(points);
  }

  public class Point {

    @Override
    public String toString() {
      return "Point{" +
          "posX=" + posX +
          ", posY=" + posY +
          ", velX=" + velX +
          ", velY=" + velY +
          '}';
    }

    private int posX, posY;
    private int velX, velY;

    public Point(int posX, int posY, int velX, int velY) {
      this.posX = posX;
      this.posY = posY;
      this.velX = velX;
      this.velY = velY;
    }

    public void movePoint() {
      this.posX += this.velX;
      this.posY += this.velY;
    }

    public int getPosX() {
      return posX;
    }

    public void setPosX(int posX) {
      this.posX = posX;
    }

    public int getPosY() {
      return posY;
    }

    public void setPosY(int posY) {
      this.posY = posY;
    }

    public int getVelX() {
      return velX;
    }

    public void setVelX(int velX) {
      this.velX = velX;
    }

    public int getVelY() {
      return velY;
    }

    public void setVelY(int velY) {
      this.velY = velY;
    }
  }


}
