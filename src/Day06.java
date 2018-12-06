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

    //coords = setManhattanDistForAll(coords);
    //int max = coords.stream().mapToInt(Coordinate::getDist).max().getAsInt();
    //coords.forEach(System.out::println);

    setGrid(coords);

    for (int i = 0; i < 50; i++) {
      for (Coordinate c : coords) {
        spreadCoordinate(c);
      }
    }

    drawGrid();

  }

  private int getManhattanDist(Coordinate c1, Coordinate c2) {
    return Math.abs((c1.getX() - c2.getX()) + (c1.getY() - c2.getY()));
  }


  private ArrayList<Coordinate> setManhattanDistForAll(ArrayList<Coordinate> cords) {
    int manhDist;

    for (Coordinate c1 : cords) {
      for (Coordinate c2 : cords) {
        if (c1.getId() == c2.getId()) {
          continue;
        }

        manhDist = getManhattanDist(c1, c2);

        if (manhDist < c1.getDist()) {
          c1.setDist(manhDist);
        }
      }
    }

    return cords;
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

  private void spreadCoordinate(Coordinate coordinate) {
    int x = coordinate.getX();
    int y = coordinate.getY();
    int id = coordinate.getId();
    int dist = coordinate.getDist();

    if (canSpread(coordinate)) {
      this.grid[x - dist][y] = id;
      this.grid[x + dist][y] = id;
      this.grid[x][y - dist] = id;
      this.grid[x][y + dist] = id;
      coordinate.setDist(dist+1);
    }
  }

  private boolean canSpread(Coordinate c) {
    int x = c.getX();
    int y = c.getY();
    int dist = c.getDist();

    return this.grid[x - dist][y] == 0 &&
        this.grid[x + dist][y] == 0 &&
        this.grid[x][y - dist] == 0 &&
        this.grid[x][y + dist] == 0;
  }

  private void setGrid(ArrayList<Coordinate> coords) {
    for (Coordinate c : coords) {
      this.grid[c.getX()][c.getY()] = c.getId();
    }
  }

  private void drawGrid() {
    for (int[] row : this.grid) {
      for (int elem : row) {
        System.out.print((elem == 0) ? "." : elem);
      }
      System.out.println();
    }
  }
}
