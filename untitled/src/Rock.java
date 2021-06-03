import java.awt.*;

public class Rock {
    private int x;
    private int y;
    

    public Rock () {
        this.x = Definitions.ROBOT_HEAD_STARTING_X + 100;
        this.y = Definitions.ROBOT_HEAD_STARTING_Y + 100;
    }
    
    
    
    public void paint (Graphics graphics) {
        graphics.setColor(Color.BLACK);
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
