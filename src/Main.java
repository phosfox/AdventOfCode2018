import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {


    String file = "C:\\Users\\Constantin\\IdeaProjects\\AdventOfCode2018\\src\\Inputs\\Day07Input.txt";

    long sTime = System.nanoTime();
    long eTime = System.nanoTime();

    Guard g = new Guard(1);
    g.fallsAsleepAt(24);
    g.wakesUpAt(28);
    System.out.println(g.getTimeAsleep());
    System.out.println(g.getMinAsleep());
    System.out.println("Duration: " + (eTime - sTime) / 1000000 + "ms");

  }
}