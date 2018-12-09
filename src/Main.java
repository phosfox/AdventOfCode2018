import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {


    String file = "C:\\Users\\Constantin\\IdeaProjects\\AdventOfCode2018\\src\\Inputs\\Day07Input.txt";
    Day04 d = new Day04();
    long sTime = System.nanoTime();
    d.solvePart1And2();
    long eTime = System.nanoTime();

    System.out.println("Duration: " + (eTime - sTime) / 1000000 + "ms");

  }
}