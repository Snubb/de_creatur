package SimulationModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * This is a class
 * Created 2021-10-18
 *
 * @author Magnus Silverdal
 */
public class SimulationModel {
    private ArrayList<goodBoy> theGoodBoys = new ArrayList<>();
    private ArrayList<food> yummyFood = new ArrayList<>();

    public SimulationModel() {

    }

    public void update() {
        for (int i = 0; i < theGoodBoys.size(); i++) {
            theGoodBoys.get(i).move();
        }
    }

    public void createGoodBoy(int x, int y) {
        theGoodBoys.add(new goodBoy(x, y));
    }
    public void createFood(int x, int y) {
        yummyFood.add(new food(x, y));
    }

    public ArrayList<goodBoy> getTheGoodBoys() {
        return theGoodBoys;
    }
    public ArrayList<food> getYummyFood() {
        return yummyFood;
    }
}
