public class Coordinate {
  private int x,y;
  private static int instanceCounter = 0;
  private int id;

  @Override
  public String toString() {
    return "Coordinate{" +
        "x=" + x +
        ", y=" + y +
        ", id=" + id +
        '}';
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
    instanceCounter++;
    this.id = instanceCounter;

  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }


}
