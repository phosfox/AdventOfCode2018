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
    d.solveDay05Part2(file);
    long eTime = System.nanoTime();

    System.out.println("Duration: " + (eTime - sTime) / 1000000 + "ms");


  }
}