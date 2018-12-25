public class Day11 {

  private int[][] grid;
  private int gridSize;
  private int puzzleInput;

  public Day11(int size, int input) {
    this.grid = new int[size + 1][size + 1];
    this.gridSize = size + 1;
    puzzleInput = input;
    setGrid();
  }

  private void setGrid() {
    for (int x = 1; x < this.gridSize; x++) {
      for (int y = 1; y < this.gridSize; y++) {
        this.grid[x][y] =
            getPower(x, y, this.puzzleInput) + this.grid[x][y - 1] + this.grid[x - 1][y]
                - this.grid[x - 1][y - 1];
        //this.grid[x][y] = getPower(x + 1, y + 1, this.puzzleInput);
      }
    }
  }

  private void printGrid() {
    for (int[] row : this.grid) {
      for (int i : row) {
        System.out.printf("%d \t\t", i);
      }
      System.out.println();
    }

  }

  public int getPower(int x, int y, int serial) {
    int rackID = x + 10;
    return (((rackID * y + serial) * rackID) / 100) % 10 - 5;
  }

  private void findLargestSquareWith3() {
    int largest = Integer.MIN_VALUE;
    int squarePower;
    int biggestX = 0, biggestY = 0;
    int size = 3;
    for (int x = 1; x < this.gridSize - size + 1; x++) {
      for (int y = 1; y < this.gridSize - size + 1; y++) {
        squarePower = powerOfSquare(x, y, size);
        if (squarePower > largest) {
          largest = squarePower;
          biggestX = x;
          biggestY = y;
        }
      }
    }

    System.out.printf("Coordinates of largest 3x3 square %d,%d\n", biggestX, biggestY);
  }

  private void findLargestSquare() {
    int largest = Integer.MIN_VALUE;
    int squarePower;
    int biggestX = 0, biggestY = 0;
    int size = 0;
    for (int i = 0; i < this.gridSize; i++) {
      for (int x = 1; x < this.gridSize - i + 1; x++) {
        for (int y = 1; y < this.gridSize - i + 1; y++) {
          squarePower = powerOfSquare(x, y, i);
          if (squarePower > largest) {
            largest = squarePower;
            biggestX = x;
            biggestY = y;
            size = i;
          }
        }
      }
    }

    System.out.printf("Coordinates of largest square %d,%d,%d\n", biggestX, biggestY, size);
  }


  private int powerOfSquare(int x, int y, int size) {
    int x0 = x - 1, x1 = x + size - 1;
    int y0 = y - 1, y1 = y + size - 1;
    return this.grid[x0][y0] + this.grid[x1][y1] - this.grid[x1][y0] - this.grid[x0][y1];
  }

  public void solvePart1() {
    findLargestSquareWith3();
  }

  public void solvePart2() {
    findLargestSquare();
  }

  public void main() {
    solvePart1();
    solvePart2();
  }

  public static void main(String[] args) {
    new Day11(300, 7989).main();
  }
}
