import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.net.URL;

/**
 * @author Todd Pickell CISS 238
 *         Chapter
 *         Programming Challenge    pg
 */
public class ImageEntity extends BaseGameEntity
{
	//variables
	protected Image image;
	protected JFrame frame;
	protected AffineTransform at;
	protected Graphics2D g2d;

	//constructor
	ImageEntity(JFrame a)
	{
		frame = a;
		setImage(null);
		setAlive(true);
	}

	public Image getImage() { return image; }

	public void setImage(Image image)
	{
		this.image = image;
		double x = frame.getSize().width/2 - width()/2;
		double y = frame.getSize().height/2 - height()/2;
		at = AffineTransform.getTranslateInstance(x, y);
	}

	public int width()
	{
		if (image != null)
		{
			return image.getWidth(frame);
		}
		else
		{
			return 0;
		}
	}

	public int  height()
	{
		if (image != null)
		{
			return image.getHeight(frame);
		}
		else
		{
			return 0;
		}
	}

	public double getCenterX()
	{
		return getX() + width()/2;
	}

	public double getCenterY()
	{
		return getY() + height()/2;
	}

	public void setGraphics(Graphics2D g)
	{
		g2d = g;
	}

	private URL getURL(String filename)
	{
		URL url = null;
		try{
			url = this.getClass().getResource(filename);
		}
		catch (Exception e){
			System.out.println("No File Found!");
		}
		return url;
	}

	public void load(String filename)
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		image = tk.getImage(getURL(filename));
		while (getImage().getWidth(frame) <= 0);
		double x = frame.getSize().width/2 - width()/2;
		double y = frame.getSize().height/2 - height()/2;
		at = AffineTransform.getTranslateInstance(x, y);
	}

	public void transform()
	{
		at.setToIdentity();
		at.translate((int)getX() + width()/2, (int)getY() + height()/2);
		at.rotate(Math.toRadians(getFaceAngle()));
		at.translate(-width()/2, -height()/2);
	}

	public void draw()
	{
		g2d.drawImage(getImage(), at, frame);
	}

	//bounding rectangle
	public Rectangle getBounds()
	{
		Rectangle r;
		r = new Rectangle((int)getX(), (int)getY(), width(), height());
		return r;
	}
}
