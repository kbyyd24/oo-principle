package cc.oobootcamp.length;

public class Length {

  private final int value;

  public Length(int value) {
    this.value = value;
  }

  public boolean isLargerThan(Length target) {
    return this.value > target.value;
  }
}
