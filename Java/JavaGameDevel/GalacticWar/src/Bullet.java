import java.awt.*;

/*********************************************************
 * Bullet class derives from BaseVectorShape
 **********************************************************/

public class Bullet extends VectorEntity {

    //bounding rectangle
    public Rectangle getBounds() {
        Rectangle r;
        r = new Rectangle((int)getX(), (int) getY(), 1, 1);
        return r;
    }

    Bullet() {
        //create the bullet shape
        setShape(new Rectangle(0, 0, 1, 1));
        setAlive(false);
    }
}
