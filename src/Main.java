import java.io.IOException;


public class Main {

  public static void main(String[] args) throws IOException {

    Day07 d = new Day07();
    long sTime = System.nanoTime();
    //d.getInput();
    long eTime = System.nanoTime();

    System.out.println("Duration: " + (eTime - sTime) / 1000000 + "ms");

  }
}