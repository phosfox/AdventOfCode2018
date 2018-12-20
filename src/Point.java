import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JPanel;

public class Point extends JPanel {

  @Override
  public String toString() {
    return "Point{" +
        "posX=" + posX +
        ", posY=" + posY +
        ", velX=" + velX +
        ", velY=" + velY +
        '}';
  }

  private int posX, posY;
  private int velX, velY;
  private int xCounter = 0;
  private int yCounter = 0;

  public Point(int posX, int posY, int velX, int velY) {
    this.posX = posX;
    this.posY = posY;
    this.velX = velX;
    this.velY = velY;
  }

  public void movePoint() {
    this.posX += this.velX * xCounter++;
    this.posY += this.velY * yCounter++;
  }

  public int getPosX() {
    return posX;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }

  public int getVelX() {
    return velX;
  }

  public void setVelX(int velX) {
    this.velX = velX;
  }

  public int getVelY() {
    return velY;
  }

  public void setVelY(int velY) {
    this.velY = velY;
  }
}