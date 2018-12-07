import java.util.HashMap;

public class Guard {
    private int id;
    private int timeAsleep;
    private int fallsAsleepAt;
    private int wakesUpAt;
    private HashMap<Integer, Integer> minAsleep;

  public Guard(int id) {
    this.id = id;
    minAsleep = new HashMap<>();
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
    this.timeAsleep += this.wakesUpAt - this.fallsAsleepAt +1;

    for (int i = this.fallsAsleepAt; i <= this.wakesUpAt; i++) {
      calcMinsAsleep(i);
    }

  }
}
