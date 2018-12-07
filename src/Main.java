import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {


    String file = "C:\\Users\\Constantin\\IdeaProjects\\AdventOfCode2018\\src\\Inputs\\Day07Input.txt";
    Day07 d = new Day07();
    long sTime = System.nanoTime();
    d.getInput();
    long eTime = System.nanoTime();
    System.out.println("Duration: " + (eTime - sTime) / 1000000 + "ms");

  }
}