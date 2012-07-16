import java.awt.*;

/**
 * @author Todd Pickell CISS 238
 *         Chapter
 *         Programming Challenge    pg
 */
public class Ship extends BaseVectorShape
{
	//define ship polygon
	private int[] shipX = {-6, -3, 0, 3, 6, 0};
	private int[] shipY = {6, 7, 7, 7, 6, -7};

	//bounding rectangle
	public Rectangle getBounds()
	{
		Rectangle r;
		r = new Rectangle((int)getX() - 6, (int)getY() - 6, 12, 12);
		return r;
	}

	Ship()
	{
		setShape(new Polygon(shipX, shipY, shipX.length));
		setAlive(true);
	}

	public void reset()
	{
		this.setX(320);
		this.setY(240);
		this.setFaceAngle(0);
		this.setVelX(0);
		this.setVelY(0);
	}
}

