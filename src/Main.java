import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    //Manhattan Distance
    // A = (x1,y1) B = (x2,y2)
    // H(A-B) = |x1 - x2| + |y1 - y2|

    /*   iterate i
        i=0           i=1           i=2
    ..........    .a........    aaa.......
    .A........    aAa.......    aAaa....c.
    ..........    .a......c.    aaad...ccc
    ........C.    ...d...cCc    .adddeccCc
    ...D......    ..dDde..c.    ..dDdeeccc
    .....E....    .b.deEe...    bb.deEeec.
    .B........    bBb..e....    bBb.eee...
    ..........    .b........    bbb..e..f.
    ..........    ........f.    .b.....fff
    ........F.    .......fFf    ......ffFf
    */
    String file = "C:\\Users\\Constantin\\IdeaProjects\\AdventOfCode2018\\src\\Inputs\\Day06Input.txt";
    Day06 d = new Day06();
    long sTime = System.nanoTime();
    d.solvePart1(file);
    long eTime = System.nanoTime();
    System.out.println("Duration: " + (eTime - sTime) / 1000000 + "ms");

    Coordinate c1 = new Coordinate(30, 2);
    Coordinate c2 = new Coordinate(2, 10);
  }
}