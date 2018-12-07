import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Day06 {

  private int maxX, maxY;
  private int[][] grid;
  private HashMap<Integer, Coordinate> coordinates = new HashMap<>();
  private HashMap<Integer, Integer> regions;

  public void solvePart1(String fileName) throws IOException {
    ArrayList<Coordinate> coords = getInput(fileName);

    int numOfCoords = 0;

    coords.forEach(c -> this.coordinates.put(c.getId(), c));

    maxX = coords.stream().max(Comparator.comparing(Coordinate::getX)).get().getX();
    maxY = coords.stream().max(Comparator.comparing(Coordinate::getY)).get().getY();
    numOfCoords = coords.stream().max(Comparator.comparing(Coordinate::getId)).get().getId();
    System.out.println("maxX: " + maxX + " maxY: " + maxY + " numOfCoords: " + numOfCoords);

    setGrid(maxX, maxY);
    regions = new HashMap<>();

    for (int x = 0; x <= maxX; x++) {
      for (int y = 0; y <= maxY; y++) {
        int best = maxX + maxY;
        int bestNum = -1;

        for (Coordinate c : coords) {
          int dist = getManhattanDist(x, y, c.getX(), c.getY());

          if (dist < best) {
            best = dist;
            bestNum = c.getId();
          } else if (dist == best) {
            bestNum = -1;
          }
        }

        this.grid[x][y] = bestNum;
        Integer total = regions.get(bestNum);

        if (total == null) {
          total = 1;
        } else {
          total = total + 1;
        }
        regions.put(bestNum, total);
      }
    }

    removeBads();

    int biggest = regions.values().stream().mapToInt(Integer::intValue).max().getAsInt();

    System.out.println("Biggest: " + biggest);

    int inArea = 0;

    for (int x = 0; x <= maxX; x++) {
      for (int y = 0; y <= maxY; y++) {
        int size = 0;

        for (int i = 1; i <= numOfCoords; i++) {
          Coordinate c = this.coordinates.get(i);

          int dist = getManhattanDist(x, y, c.getX(), c.getY());
          size += dist;
        }

        if (size < 10000) {
          inArea++;
        }
      }
    }

    System.out.println("Area Size: " + inArea);
    //drawGrid();
  }

  /**
   * removeBads removes the outer ring of coordinates from the regionmap, those that would be
   * infinite
   */
  private void removeBads() {
    int bad;

    for (int x = 0; x <= maxX; x++) {
      bad = this.grid[x][0];
      regions.remove(bad);
      bad = this.grid[x][maxY];
      regions.remove(bad);
    }

    for (int y = 0; y <= maxY; y++) {
      bad = this.grid[0][y];
      regions.remove(bad);
      bad = this.grid[maxX][y];
      regions.remove(bad);
    }
  }

  private int getManhattanDist(int x1, int y1, int x2, int y2) {
    return Math.abs(x1 - x2) + Math.abs((y1 - y2));
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
      coordinate.setDist(dist + 1);
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

  private void setGrid(int maxX, int maxY) {
    this.grid = new int[maxX + 1][maxY + 1];

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
