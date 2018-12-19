import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JPanel;

public class Point extends JPanel{

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

  public Point(int posX, int posY, int velX, int velY) {
    this.posX = posX;
    this.posY = posY;
    this.velX = velX;
    this.velY = velY;
  }

  public void movePoint() {
    this.posX += this.velX;
    this.posY += this.velY;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.draw(g);
  }

  public void draw(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    Rectangle2D.Double rect = new Rectangle2D.Double(this.posX, this.posY, 5, 5);

    g2d.setColor(Color.BLACK);
    g2d.fill(rect);
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