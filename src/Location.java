public class Location {
  private int x;
  private int y;

  public Location(int x, int y) {
    this.x = x;
    this.y = y;
  }
  // Getter and setter methods for x and y coordinates
  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Location location = (Location) obj;
    return x == location.x && y == location.y;
  }
}
