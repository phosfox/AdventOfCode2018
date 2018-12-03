import org.w3c.dom.css.Rect;

public class Rectangle {

  private int number;
  private int x, y;
  private int width, height;

  public boolean overlapsWith(Rectangle other) {
    //https://stackoverflow.com/a/306379
    boolean xOverlap = valueInRange(this.x, other.x, other.x + other.width) ||
        valueInRange(other.x, this.x, this.x + this.width);

    boolean yOverlap = valueInRange(this.y, other.y, other.y + other.height) ||
        valueInRange(other.y, this.y, this.y + this.height);

    return xOverlap && yOverlap;
  }

  private boolean valueInRange(int value, int min, int max) {
    return (value >= min) && (value < max);
  }

  @Override
  public String toString() {
    return "Rectangle{" +
        "number=" + number +
        ", x=" + x +
        ", y=" + y +
        ", width=" + width +
        ", height=" + height +
        '}';
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
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

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public Rectangle(int number, int x, int y, int width, int height) {
    this.number = number;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }
}
