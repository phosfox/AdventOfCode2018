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

    String file = "src\\\\Day03Input.txt";
    Day03 d3 = new Day03();
    long sTime = System.nanoTime();
    int inches = d3.solveDay03Part1(file);
    long eTime = System.nanoTime();

    System.out.println("Claimed Inches:" + inches);

    Rectangle r1 = new Rectangle(1, 1, 3, 4, 4);
    Rectangle r2 = new Rectangle(2, 3, 1, 4, 4);
    Rectangle r3 = new Rectangle(3, 5, 5, 2, 2);
    Rectangle r4 = new Rectangle(4, 1, 1, 1, 1);

    System.out.println(r1.overlapsWith(r2));
    System.out.println(r1.overlapsWith(r3));
    System.out.println(r2.overlapsWith(r3));
    System.out.println(r4.overlapsWith(r1));

    System.out.println("Duration: " + (eTime - sTime) / 1000000 + "ms");


  }
}