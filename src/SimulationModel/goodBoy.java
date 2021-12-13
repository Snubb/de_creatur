package SimulationModel;

import java.util.ArrayList;

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
    public void move(ArrayList<food> foods) {
        for (int i = 0; i < foods.size(); i++) {
            if ((foods.get(i).getX() - this.x < 50 && foods.get(i).getX() - this.x >= 0) && (foods.get(i).getY() - this.y < 10 && foods.get(i).getY() - this.y >= 0)) {
                this.x = foods.get(i).getX();
            }
        }
    }
}
