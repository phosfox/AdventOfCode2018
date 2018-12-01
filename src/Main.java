import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    String file = "src\\Day01Input.txt";
    Day01 d1 = new Day01();

    //int freqResult = d1.calibrateFrequency(file);
    //System.out.println(freqResult);

    int freqTwice = d1.calibrateFrequencyTwice(file);
    System.out.println(freqTwice);
  }
}
