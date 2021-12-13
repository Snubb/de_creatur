package SimulationModel;

import java.util.ArrayList;

/**
 * This is a class
 * Created 2021-10-18
 *
 * @author Magnus Silverdal
 */
public class SimulationModel {
    private ArrayList<goodBoy> theGoodBoys = new ArrayList<>();

    public SimulationModel() {

    }

    public void update() {

    }

    public void createGoodBoy(int x, int y) {
        theGoodBoys.add(new goodBoy(x, y));
    }

    public ArrayList<goodBoy> getTheGoodBoys() {
        return theGoodBoys;
    }
}
