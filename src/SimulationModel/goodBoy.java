package SimulationModel;

public class goodBoy {
    private int x;
    private int y;
    private int color;

    public goodBoy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void move() {
        this.x++;
        this.y++;
    }
}
