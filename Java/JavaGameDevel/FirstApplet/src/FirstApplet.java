import javax.swing.*;
import java.awt.*;

/**
 * @author Todd Pickell CISS 238
 *         Chapter
 *         Programming Challenge    pg
 */

public class FirstApplet extends JFrame
{
	public FirstApplet()
	{
		super("JFrameDemo");
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 400);
		g.setColor(Color.orange);
		g.setFont(new Font("Arial", Font.BOLD, 18));
		g.drawString("Hey Buddy w/ a JFrame!", 60, 200);
	}

	public static void main(String[] args)
	{
		new FirstApplet();
	}
}
