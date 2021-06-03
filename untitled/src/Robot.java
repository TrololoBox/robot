import java.awt.*;
import java.awt.event.KeyEvent;


public class Robot {
    private int x;
    private int y;
    private int direction;
    

    public Robot () {
        this.x = Definitions.ROBOT_HEAD_STARTING_X;
        this.y = Definitions.ROBOT_HEAD_STARTING_Y;
        this.direction = Definitions.DIRECTION_RIGHT;
    }

    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private void moveRight () {
        this.x++;
    }

    private void moveLeft () {
        this.x--;
    }

    private void moveUp () {
        this.y--;
    }

    private void moveDown () {
        this.y++;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void paint (Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(
                this.x,
                this.y,
                Definitions.ROBOT_HEAD_SIZE,
                Definitions.ROBOT_HEAD_SIZE);
        
//        graphics.setColor(Color.BLUE);
//        graphics.fillRect(
//                Definitions.ROBOT_HEAD_STARTING_X - Definitions.ROBOT_SHOULDER_WIDTH + this.x,
//                Definitions.ROBOT_HEAD_STARTING_Y + Definitions.ROBOT_HEAD_SIZE + this.y,
//                Definitions.ROBOT_HEAD_SIZE + 2 * Definitions.ROBOT_SHOULDER_WIDTH,
//                Definitions.ROBOT_HEAD_SIZE + 2 * Definitions.ROBOT_SHOULDER_WIDTH
//        );
    }
}
