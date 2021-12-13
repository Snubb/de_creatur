import SimulationModel.SimulationModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This is a class
 * Created 2021-10-18
 *
 * @author Magnus Silverdal
 */
public class Controller implements Runnable{
    private Thread thread;
    private boolean running = false;
    private int fps = 30;
    private int ups = 30;
    private int width = 1200;
    private int height = 600;
    private int scale = 4;
    private JFrame frameNative;
    //private JFrame frameSprite;
    private String title = "";
    //private ScreenRenderer viewNative;
    private Renderer viewNative;
    //private ScreenRenderer viewSprite;
    private SimulationModel model;
    private final Rectangle mouse = new Rectangle();



    public Controller() {
        //viewNative = new ScreenRenderer(width,height,scale);
        viewNative = new Renderer(width, height, scale);
        //viewSprite = new ScreenRenderer(width,height,scale);
        model = new SimulationModel();
        // Frame data
        frameNative = new JFrame(title+"Native");
        frameNative.add(viewNative);
        frameNative.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewNative.addKeyListener(new KL());
        frameNative.setResizable(true);
        frameNative.pack();
        frameNative.setLocationRelativeTo(null);
        frameNative.setVisible(true);
        frameNative.requestFocus();

        viewNative.addMouseMotionListener(new MML());
        viewNative.addMouseListener(new ML());
    }

    private class MML implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent mouseEvent) { }
        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            mouse.x = mouseEvent.getX();
            mouse.y = mouseEvent.getY();
        }
    }

    private class ML implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) { }
        @Override
        public void mouseReleased(MouseEvent mouseEvent) { }
        @Override
        public void mouseEntered(MouseEvent mouseEvent) { }
        @Override
        public void mouseExited(MouseEvent mouseEvent) { }
    }

    private class KL implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
        }
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        double nsFPS = 1000000000.0 / fps;
        double nsUPS = 1000000000.0 / ups;
        double deltaFPS = 0;
        double deltaUPS = 0;
        int frames = 0;
        int updates = 0;
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();

        while (running) {
            long now = System.nanoTime();
            deltaFPS += (now - lastTime) / nsFPS;
            deltaUPS += (now - lastTime) / nsUPS;
            lastTime = now;

            while(deltaUPS >= 1) {
                model.update();
                updates++;
                deltaUPS--;
            }

            while (deltaFPS >= 1) {
                viewNative.render();
                //viewSprite.render();
                frames++;
                deltaFPS--;
            }

            if(System.currentTimeMillis() - timer >= 1000) {
                timer += 1000;
                frameNative.setTitle(this.title + "Native  |  " + updates + " ups, " + frames + " fps");
                frames = 0;
                updates = 0;
            }
        }
        stop();
    }

    public static void main(String[] args) {
        Controller c = new Controller();
        c.start();
    }
}
