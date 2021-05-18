package mousemove;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MouseMove {
    private Integer x, y;
    private final Robot robot;
    MouseMove() throws AWTException {
        x = 100;
        y = 100;
        robot = new Robot();
    }

    void randomMoveAndClick() throws InterruptedException {
        while(true) {
            Thread.sleep(179000L);
            randomizeCoordination();
            robot.mouseMove(x, y);
            // not click , in order not to change anything
            // robot.mousePress(KeyEvent.BUTTON1_MASK);
        }
    }
    private void randomizeCoordination() {
        int plus = Math.random() > 0.5 ? 1 : -1;
        x = (int)(Math.random() * 1000 * plus) + 100;
        y = (int)(Math.random() * 1000 * plus) + 100;
    }

    public static void main(String[] args) {
        try{
            MouseMove mouseMove = new MouseMove();
            mouseMove.randomMoveAndClick();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}

class MyKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        Exit();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Exit();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Exit();
    }
    private void Exit() {
        System.out.println("Got key typed, exit");
        System.exit(0);
    }
}
