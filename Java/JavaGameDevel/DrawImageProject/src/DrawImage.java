import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.Random;

/**
 * @author Todd Pickell CISS 238
 *         Chapter
 *         Programming Challenge    pg
 */
public class DrawImage extends JFrame
{
	private Image image1, image2;

	public static void main(String[] args)
	{
		new DrawImage();
	}

	public DrawImage()
	{
		super("DrawImage");
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		image1 = tk.getImage(getURL("wrench.png"));
		image2 = tk.getImage(getURL("peeBag.png"));
	}

	//identity transformation
	AffineTransform identity = new AffineTransform();

	private URL getURL(String filename)
	{
		URL url = null;
		try {
			url = this.getClass().getResource(filename);
		}
		catch (Exception e) {
		System.out.println("Did not find file!");
		}
		return url;
	}

	public void paint(Graphics g)
	{
		//create instance of grahics2d
		Graphics2D g2d = (Graphics2D) g;

		//working transform object
		AffineTransform trans = new AffineTransform();

		//random number generator
		Random rand = new Random();

		//applet window width / height
		int width = getSize().width;
		int height = getSize().height;

		//fill background black
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, getSize().width, getSize().height);

		//draw the image1
		for (int i = 0 ; i < 50; i++)
		{
			trans.setTransform(identity);
			//move, rotate, scale randomly
			trans.translate(rand.nextInt()%width, rand.nextInt()%height);
			trans.rotate(Math.toRadians(360 * rand.nextDouble()));


			if (i%2 == 0)
			{
				//scale for wrench
				double scale = (rand.nextDouble()+1) * 0.2 ;
				trans.scale(scale, scale);
				//draw the image1
				g2d.drawImage(image1, trans, this);
			}
			else
			{
				//scale for peeBag
				double scale = (rand.nextDouble()+1) * 0.5 ;
				trans.scale(scale, scale);
				//draw image2
				g2d.drawImage(image2, trans, this);
			}
		}
	}
}
