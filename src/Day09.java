import java.util.ArrayDeque;
import java.util.Arrays;

public class Day09 {

  public class CircleDeque<T> extends ArrayDeque<T> {
    public void rotate(int num) {
      if (num == 0) {
        return;
      }
      if (num > 0) {
        for (int i = 0; i < num; i++) {
          T t = this.removeLast();
          this.addFirst(t);
        }
      } else {
        for (int i = 0; i < Math.abs(num) - 1; i++) {
          T t = this.remove();
          this.addLast(t);
        }
      }
    }
  }

  private void solvePart1and2() {
    String input = "";
    int players = 463;
    int end = 71787*100;
    CircleDeque<Integer> circle = new CircleDeque<>();
    circle.addFirst(0);
    long[] scores = new long[players];

    for (int i = 1; i <= end ; i++) {
      if (i % 23 == 0) {
        circle.rotate(-7);
        scores[i % players] += i + circle.pop();
      } else {
        circle.rotate(2);
        circle.addLast(i);
      }
    }
    System.out.println(Arrays.stream(scores).max().getAsLong());
  }

  private void main() {
    solvePart1and2();
  }

  public static void main(String[] args) {
    new Day09().main();
  }

}
