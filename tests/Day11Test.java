import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day11Test {

  private Day11 d;

  @BeforeEach
  void setUp() {
    d = new Day11(300, 7989);
  }

  @Test
  void getPower() {
    assertEquals(4, d.getPower(3, 5, 8));
    assertEquals(0, d.getPower(217, 196, 39));
    assertEquals(4, d.getPower(101, 153, 71));
    assertEquals(-5, d.getPower(122, 79, 57));
  }

}