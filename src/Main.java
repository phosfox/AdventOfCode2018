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

    String file = "C:\\Users\\Constantin\\IdeaProjects\\AdventOfCode2018\\src\\Inputs\\Day05Input.txt";
    Day05 d = new Day05();
    long sTime = System.nanoTime();
    d.solveDay05Part1(file);
    long eTime = System.nanoTime();



    //Rectangle r1 = new Rectangle(1, 1, 3, 4, 4);
    //Rectangle r2 = new Rectangle(2, 3, 1, 4, 4);
    //Rectangle r3 = new Rectangle(3, 5, 5, 2, 2);
    //Rectangle r4 = new Rectangle(4, 1, 1, 1, 1);
    //System.out.println(r1.overlapsWith(r2) + " should true");
    //System.out.println(r1.overlapsWith(r3) + " should false");
    //System.out.println(r2.overlapsWith(r3) + " should false");
    //System.out.println(r4.overlapsWith(r1) + " should false");

    System.out.println("Duration: " + (eTime - sTime) / 1000000 + "ms");


  }
}