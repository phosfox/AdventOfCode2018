import java.util.HashMap;
import java.util.Map;

public class Guard {
    private int id;
    private int timeAsleep;
    private int fallsAsleepAt;
    private int wakesUpAt;
    private HashMap<Integer, Integer> minAsleep;
    private int mostAsleepMin;

  public Guard(int id) {
    this.id = id;
    minAsleep = new HashMap<>();
  }


  @Override
  public String toString() {
    return "Guard{" +
        "id=" + id +
        ", timeAsleep=" + timeAsleep +
        ", fallsAsleepAt=" + fallsAsleepAt +
        ", wakesUpAt=" + wakesUpAt +
        ", mostAsleepMin=" + mostAsleepMin +
        ", minAsleep=" + minAsleep +
        '}';
  }

  public int getMostMinsSlept() {
    int max = 0;
    for (Map.Entry<Integer, Integer> entry : this.minAsleep.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getKey();
      }
    }
    return max;
  }

  public int getMostAsleepMin() {
    int max = 0;
    for (Map.Entry<Integer, Integer> entry : this.minAsleep.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getValue();
        this.mostAsleepMin = entry.getKey();
      }
    }
    return this.mostAsleepMin;
  }

  public int getId() {
    return this.id;
  }

  public void fallsAsleepAt(int t) {
    this.fallsAsleepAt = t;

  }

  public void calcMinsAsleep(int t) {
    if (!this.minAsleep.containsKey(t)) {
      this.minAsleep.put(t, 1);
    } else {
      this.minAsleep.computeIfPresent(t, (k,v) -> v + 1);
    }
  }

  public int getTimeAsleep() {
    return timeAsleep;
  }



  public int getFallsAsleepAt() {
    return fallsAsleepAt;
  }



  public int getWakesUpAt() {
    return wakesUpAt;
  }

  public HashMap<Integer, Integer> getMinAsleep() {
    return minAsleep;
  }


  public void wakesUpAt(int t) {
    this.wakesUpAt = t;
    this.timeAsleep += this.wakesUpAt - this.fallsAsleepAt ;

    for (int i = this.fallsAsleepAt; i < this.wakesUpAt; i++) {
      calcMinsAsleep(i);
    }

  }
}
