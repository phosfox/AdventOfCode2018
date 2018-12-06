import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    //DAY 01
    //String file = "src\\Day01Input.txt";
    //Day01 d1 = new Day01();
    //int freqResult = d1.calibrateFrequency(file);
    //int freqTwice = d1.calibrateFrequencyTwice(file);

    //Day02
    //Day02 d2 = new Day02();
    //String file = "src\\Day02Input.txt";

    //Manhattan Distance
    // A = (x1,y1) B = (x2,y2)
    // H(A-B) = |x1 - x2| + |y1 - y2|

    String file = "C:\\Users\\Constantin\\IdeaProjects\\AdventOfCode2018\\src\\Inputs\\Day06Input.txt";
    Day06 d = new Day06();
    long sTime = System.nanoTime();
    d.solvePart1(file);
    long eTime = System.nanoTime();
    System.out.println("Duration: " + (eTime - sTime) / 1000000 + "ms");

    Coordinate c1 = new Coordinate(30, 2);
    Coordinate c2 = new Coordinate(2, 10);
    System.out.println(d.getManhattanDist(c1, c2));
  }
}