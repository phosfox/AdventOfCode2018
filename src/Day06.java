import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Day06 {


  private int[][] grid = new int[400][400];

  public void solvePart1(String fileName) throws IOException {
    ArrayList<Coordinate> coords = getInput(fileName);
    setGrid(coords);
  }

  public int getManhattanDist(Coordinate c1, Coordinate c2) {
    return Math.abs((c1.getX() - c2.getX()) + (c1.getY() - c2.getY()));
  }

  private ArrayList<Coordinate> getInput(String fileName) throws IOException {
    ArrayList<Coordinate> coordinates = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      for (String line; (line = br.readLine()) != null; ) {

        String[] elements = line.split(", ");
        Coordinate c = new Coordinate(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
        coordinates.add(c);
      }
    }
    return coordinates;
  }

  private void setGrid(ArrayList<Coordinate> coords) {
    for (Coordinate c : coords) {
      this.grid[c.getX()][c.getY()] = c.getId();
    }
  }

  private void drawGrid() {
    for (int[] row : this.grid) {
      for (int elem : row) {
        System.out.print((elem == 0) ?  "." : elem );
      }
      System.out.println();
    }
  }
}
