import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author Todd Pickell CISS 238
 *         Chapter
 *         Programming Challenge    pg
 */
public class SpriteTest extends JFrame implements Runnable
{
	//window size variables
	int screenWidth = 640;
	int screenHeight = 480;

	//double buffer objects
	BufferedImage backBuffer;
	Graphics2D g2d;

	Sprite asteroid;
	ImageEntity background;
	Thread gameloop;
	Random rand = new Random();

	public static void main(String[] args)
	{
		new SpriteTest();
	}

	public SpriteTest()
	{
		//setup screen for game
		super("Sprite Test");
		setSize(screenWidth, screenHeight);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//create back buffer for smooth graphics
		backBuffer = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_RGB);
		g2d = backBuffer.createGraphics();

		//load background
		background = new ImageEntity(this);
		background.load("Space.png");

		//load the asteroid sprite
		asteroid = new Sprite(this, g2d);
		asteroid.load("asteroid.png");

		//start game loop
		gameloop = new Thread(this);
		gameloop.start();
	}

	public void run()
	{
		Thread t = Thread.currentThread();
		while (t == gameloop)
		{
			try{
				Thread.sleep(300);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}

			//draw background
			g2d.drawImage(background.getImage(), 0, 0, screenWidth - 1, screenHeight - 1, this);

			int width = screenWidth - asteroid.imageWidth() - 1;
			int height = screenHeight - asteroid.imageHeight() - 1;

			Point point = new Point(rand.nextInt(width), rand.nextInt(height));
			asteroid.setPosition(point);
			asteroid.draw();

            asteroid.transform();

			repaint();
		}
	}

	public void paint(Graphics g)
	{
		//draw the buffer to the screen
		g.drawImage(backBuffer, 0, 0, this);
	}
}
