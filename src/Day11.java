public class Day11 {

  private int[][] grid;
  private int gridSize;
  private int puzzleInput;

  public Day11(int size, int input) {
    this.grid = new int[size][size];
    this.gridSize = size;
    puzzleInput = input;
    setGrid();
  }

  private void setGrid() {
    for (int x = 0; x < this.gridSize; x++) {
      for (int y = 0; y < this.gridSize; y++) {
        this.grid[x][y] = getPower(x + 1, y + 1, this.puzzleInput);
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
    int powerLvl = rackID * y;
    int buf = (powerLvl + serial) * rackID;
    int digit;
    if (buf > 99) {
      String s = Integer.toString(buf);
      digit = Character.getNumericValue(s.charAt(s.length() - 3));
    } else {
      digit = 0;
    }
    return digit - 5;
  }

  private void findLargestSquareWith3() {
    int largest = Integer.MIN_VALUE;
    int squarePower;
    int biggestX = 0, biggestY = 0;
    for (int x = 0; x < this.gridSize; x++) {
      for (int y = 0; y < this.gridSize; y++) {
        squarePower = powerOfSquare(x, y, 3);
        if (squarePower > largest) {
          largest = squarePower;
          biggestX = x + 1;
          biggestY = y + 1;
        }
      }
    }

    System.out.printf("Coordinates of largest 3x3 square %d,%d", biggestX, biggestY);
  }

  private void findLargestSquare() {
    int largest = Integer.MIN_VALUE;
    int squarePower;
    int biggestX = 0, biggestY = 0;
    int size = 0;
    for (int x = 0; x < this.gridSize; x++) {
      for (int y = 0; y < this.gridSize; y++) {
        for (int i = 1; i < this.gridSize; i++) {
          squarePower = powerOfSquare(x, y, i);
          if (squarePower > largest) {
            largest = squarePower;
            biggestX = x + 1;
            biggestY = y + 1;
            size = i;
          }
        }
      }
    }

    System.out.printf("Coordinates of largest square %d,%d,%d", biggestX, biggestY, size);
  }


  private int powerOfSquare(int x, int y, int size) {
    int total = 0;
    int xBound = x + size, yBound = y + size;
    if (xBound >= this.gridSize - 1) {
      xBound = this.gridSize - 1;
    }
    if (yBound >= this.gridSize - 1) {
      yBound = this.gridSize - 1;
    }

    for (int i = x; i < xBound; i++) {
      for (int j = y; j < yBound; j++) {
        total += this.grid[i][j];
      }
    }

    return total;
  }

  public void solvePart1() {
    findLargestSquareWith3();
  }

  public void solvePart2() {
    findLargestSquare();
  }

  public void main() {
    //solvePart1();
    solvePart2();
  }

  public static void main(String[] args) {
    new Day11(300, 7989).main();
  }
}
