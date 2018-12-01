import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {

    Day01 d1 = new Day01();
    int freqResult = d1.calibrateFrequency("src\\Day01Input.txt");
    System.out.println(freqResult);
  }
}
