import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;

import SimulationModel.goodBoy;

public class Renderer extends Canvas {
    private int WIDTH;
    private int HEIGTH;
    private int scale;

    private boolean future = false;

    private BufferedImage image;

    public Renderer(int width, int height, int scale) {
        // Screen data
        this.WIDTH = width;
        this.HEIGTH = height;
        this.scale = scale;
        image = new BufferedImage(WIDTH/scale, HEIGTH/scale, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(WIDTH, HEIGTH));
    }

    public void render(int widht, int height, int scale, ArrayList<goodBoy> goodBoys) {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }


        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGTH);

        g.setColor(Color.white);
        for (int i = 0; i < goodBoys.size(); i++) {
            g.fillRect(goodBoys.get(i).getX()*scale, goodBoys.get(i).getY()*scale, scale, scale);
        }


        g.dispose();
        bs.show();
    }
}
