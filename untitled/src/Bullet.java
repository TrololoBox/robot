import java.awt.*;

public class Bullet {
	
	private int x;
    private int y;

    
    public Bullet () {
    	this.x = Definitions.ROBOT_HEAD_STARTING_X;
        this.y = Definitions.ROBOT_HEAD_STARTING_Y;
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
	
	public void paint (Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(
                this.x,
                this.y,
                20,
                20);
        
//        graphics.setColor(Color.BLUE);
//        graphics.fillRect(
//                Definitions.ROBOT_HEAD_STARTING_X - Definitions.ROBOT_SHOULDER_WIDTH + this.x,
//                Definitions.ROBOT_HEAD_STARTING_Y + Definitions.ROBOT_HEAD_SIZE + this.y,
//                Definitions.ROBOT_HEAD_SIZE + 2 * Definitions.ROBOT_SHOULDER_WIDTH,
//                Definitions.ROBOT_HEAD_SIZE + 2 * Definitions.ROBOT_SHOULDER_WIDTH
//        );
    }



	
    
    

}
