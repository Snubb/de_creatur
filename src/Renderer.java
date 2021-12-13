import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;

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

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }


        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGTH);

        g.setColor(Color.white);
        g.fillRect(200, 200, 50, 50);

        g.dispose();
        bs.show();
    }
}
