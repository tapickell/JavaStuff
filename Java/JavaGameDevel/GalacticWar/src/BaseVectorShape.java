/**
 * @author Todd Pickell CISS 238
 *         Chapter
 *         Programming Challenge    pg
 */
import java.awt.*;

/**
 * @author Todd Pickell CISS 238
 *         Chapter
 *         Programming Challenge    pg
 */


//Bas vector class for all polygonal shapes in game
public class BaseVectorShape
{
	//variables
	private Shape shape;
	private boolean alive;
	private double x;
	private double y;
	private double velX;
	private double velY;
	private double moveAngle;
	private double faceAngle;

	//Getter & Setter methods
	public Shape getShape()
	{
		return shape;
	}

	public void setShape(Shape shape)
	{
		this.shape = shape;
	}

	public boolean isAlive()
	{
		return alive;
	}

	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}

	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public double getVelX()
	{
		return velX;
	}

	public void setVelX(double velX)
	{
		this.velX = velX;
	}

	public double getVelY()
	{
		return velY;
	}

	public void setVelY(double velY)
	{
		this.velY = velY;
	}

	public double getMoveAngle()
	{
		return moveAngle;
	}

	public void setMoveAngle(double moveAngle)
	{
		this.moveAngle = moveAngle;
	}

	public double getFaceAngle()
	{
		return faceAngle;
	}

	public void setFaceAngle(double faceAngle)
	{
		this.faceAngle = faceAngle;
	}

	//helper methods
	public void incX(double i)
	{
		this.x += i;
	}

	public void incY(double i)
	{
		this.y += i;
	}

	public void incVelX(double i)
	{
		this.velX += i;
	}

	public void incVelY(double i)
	{
		this.velY += i;
	}

	public void incFacingAngle(double i)
	{
		this.faceAngle += i;
	}

	public void incMoveAngle(double i)
	{
		this.moveAngle += i;
	}

	//constructor
	BaseVectorShape()
	{
		setShape(null);
		setAlive(false);
		setX(0.0);
		setY(0.0);
		setVelX(0.0);
		setVelY(0.0);
		setMoveAngle(0.0);
		setFaceAngle(0.0);
	}
}
