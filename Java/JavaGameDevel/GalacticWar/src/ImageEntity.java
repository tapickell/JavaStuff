/**
 * @author Todd Pickell CISS 238
 *         Chapter
 *         Programming Challenge    pg
 */
/*********************************************************
 * Base game image class for bitmapped game entities
 **********************************************************/
import java.awt.*;
import java.awt.geom.*;
//************
import java.net.*;
import java.applet.*;

public class ImageEntity extends BaseGameEntity {
    //variables
    protected Image image;
    protected Applet applet;
    protected AffineTransform at;
    protected Graphics2D g2d;

    //default constructor
    ImageEntity(Applet a) {
        applet = a;
        setImage(null);
        setAlive(true);
    }

    public Image getImage() { return image; }

    public void setImage(Image image) { this.image = image; }

    public int width() {
        return getImage().getWidth(applet);
    }
    public int height() {
        return getImage().getHeight(applet);
    }

    public double getCenterX() {
        return getX() + width() / 2;
    }
    public double getCenterY() {
        return getY() + height() / 2;
    }

    public void setGraphics(Graphics2D g) {
        g2d = g;
    }

    private URL getURL(String filename) {
        URL url = null;
        try {
            url = this.getClass().getResource(filename);
        }
        catch (Exception e) { }

        return url;
    }

    public void load(String filename) {
//******************
        setImage(applet.getImage(getURL(filename)));
        while(getImage().getWidth(applet) <= 0);
        double x = applet.getSize().width/2  - width()/2;
        double y = applet.getSize().height/2 - height()/2;
        at = AffineTransform.getTranslateInstance(x, y);
    }

    public void transform() {
        at.setToIdentity();
        at.translate((int)getX() + width()/2, (int)getY() + height()/2);
        at.rotate(Math.toRadians(getFaceAngle()));
        at.translate(-width()/2, -height()/2);
    }

    public void draw() {
        g2d.drawImage(getImage(), at, applet);
    }

    //bounding rectangle
    public Rectangle getBounds() {
        Rectangle r;
        r = new Rectangle((int)getX(), (int)getY(), width(), height());
        return r;
    }

}
