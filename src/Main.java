import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    String file = "src\\Day01Input.txt";
    Day01 d1 = new Day01();

    //int freqResult = d1.calibrateFrequency(file);
    //System.out.println(freqResult);

    long sTime = System.nanoTime();
    int freqTwice = d1.calibrateFrequencyTwice(file);
    long eTime = System.nanoTime();

    System.out.println(freqTwice);
    System.out.println("Duration: " + (eTime - sTime) / 1000000 + "ms");
  }
}
