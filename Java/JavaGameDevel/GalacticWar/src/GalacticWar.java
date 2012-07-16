import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

/*****************************************************
 * Primary class for the game
 *****************************************************/
public class GalacticWar extends Applet implements Runnable, KeyListener
{
	//global constant
	static int SCREENWIDTH = 800;
	static int SCREENHEIGHT = 600;
	static int CENTERX = SCREENWIDTH/2;
	static int CENTERY = SCREENHEIGHT/2;
	static int ASTEROIDS = 10;
	static int BULLETS = 10;
	static int BULLET_SPEED = 4;
	static double ACCELERATION = 0.05;

	static int SPRITE_NORMAL = 0;
	static int SPRITE_COLLIDED =1;
	static int SPRITE_EXPLODING = 2;

    //the main thread becomes the game loop
    Thread gameloop;
    //use this as a double buffer
    BufferedImage backbuffer;
    //the main drawing object for the back buffer
    Graphics2D g2d;
    //toggle for drawing bounding boxes
    boolean showBounds = false;
	boolean collisionTesting = true;
	long collisionTimer = 0;

    //create the asteroid array
    Sprite[] ast = new Sprite[ASTEROIDS];

    //create the bullet array
    Sprite[] bullet = new Sprite[BULLETS];
    int currentBullet = 0;

	//background
	ImageEntity background;

    //the player's ship
    //ImageEntity ship = new ImageEntity(this);
	Sprite ship;
	//AnimatedSprite explosion;

    //create the identity transform
    AffineTransform identity = new AffineTransform();

    //create a random number generator
    Random rand = new Random();

	//load sound effects
	//SoundClip shoot;
	//SoundClip explode;
	boolean keyDown, keyUp, keyLeft, keyRight, keyFire;

	//frame rate counter
	int frameCount = 0, frameRate = 0;
	long startTime = System.currentTimeMillis();

    /*****************************************************
     * applet init event
     *****************************************************/
    public void init() {
        //create the back buffer for smooth graphics
        backbuffer = new BufferedImage(SCREENWIDTH, SCREENHEIGHT, BufferedImage.TYPE_INT_RGB);
        g2d = backbuffer.createGraphics();

	    //load background
	    background = new ImageEntity(this);
	    background.load("Space.png");

        //set up the ship
	    ship = new Sprite(this, g2d);
	    ship.load("xwing_detail.png");
		ship.setPosition(new Point2D(CENTERX, CENTERY));
	    ship.setAlive(true);

        //set up the bullets
        for (int n = 0; n<BULLETS; n++) {
            bullet[n] = new Sprite(this, g2d);
	        bullet[n].load("plasmashot.png");
        }

        //set up the asteroids
        for (int n = 0; n<ASTEROIDS; n++) {
            ast[n] = new Sprite(this, g2d);
	        ast[n].setAlive(true);
	        ast[n].load("asteroid.png");
	        ast[n].setPosition(new Point2D(rand.nextInt(SCREENWIDTH), rand.nextInt(SCREENHEIGHT)));
	        ast[n].setFaceAngle(rand.nextInt(360));
            ast[n].setMoveAngle(rand.nextInt(360));
	        ast[n].setRotationRate(rand.nextDouble());
            double ang = ast[n].moveAngle() - 90;
            double velX = calcAngleMoveX(ang);
            double velY = calcAngleMoveY(ang);
	        ast[n].setVelocity(new Point2D(velX, velY));
        }

        //load sound files
        //shoot = new SoundClip("zap.wav");
        //explode = new SoundClip("teleport.wav");

	    //load the explosion
	    /*explosion = new  AnimatedSprite(this, g2d);
	    explosion.load("explosion96x96x16.png", 4, 4, 96, 96);
	    explosion.setFrameDelay(2);
	    explosion.setAlive(false);*/

        //start the user input listener
        addKeyListener(this);
    }

    /*****************************************************
     * applet update event to redraw the screen
     *****************************************************/
    public void update(Graphics g) {
	    //calculate frame rate
	    frameCount++;
	    if (System.currentTimeMillis() > startTime + 1000)
	    {
		    startTime = System.currentTimeMillis();
		    frameRate = frameCount;
		    frameCount = 0;
	    }

        //start off transforms at identity
        g2d.setTransform(identity);

	    //draw background
	    g2d.drawImage(background.getImage(), 0, 0, SCREENWIDTH-1, SCREENHEIGHT-1, this);

        /*//erase the background
        g2d.setPaint(Color.BLACK);
        g2d.fillRect(0, 0, getSize().width, getSize().height);*/

        //print some status information
        g2d.setColor(Color.WHITE);
	    g2d.drawString("FPS: " + frameRate, 5, 10);
        g2d.drawString("Ship: " + Math.round(ship.position().X()) + ", " + Math.round(ship.position().Y()) , 5, 25);
        g2d.drawString("Move angle: " + Math.round(ship.moveAngle())+90, 5, 40);
        g2d.drawString("Face angle: " +  Math.round(ship.faceAngle()), 5, 55);

        //draw the game graphics
        drawBullets();
        drawAsteroids();
	    drawShip();
	    //drawExplosions();

	    if (showBounds)
	    {
		    g2d.setColor(Color.GREEN);
		    g2d.drawString("BOUNDING BOXES", SCREENWIDTH-150, 10);
	    }
	    if (collisionTesting)
	    {
		    g2d.setColor(Color.GREEN);
		    g2d.drawString("COLLISION TESTING", SCREENWIDTH-150, 25);
	    }

	    if (ship.state() == SPRITE_NORMAL)
	    {
		    g2d.setColor(Color.MAGENTA);
		    g2d.drawString("State: Normal", SCREENWIDTH-150, 40);
	    }
	    else  if (ship.state() == SPRITE_COLLIDED)
	    {
		    g2d.setColor(Color.MAGENTA);
		    g2d.drawString("State: Collided", SCREENWIDTH-150, 40);
	    }
	    else if (ship.state() == SPRITE_EXPLODING)
	    {
		    g2d.setColor(Color.MAGENTA);
		    g2d.drawString("State: Exploding", SCREENWIDTH-150, 40);
	    }

        //repaint the applet window
        paint(g);
    }

    /*****************************************************
     * drawShip called by applet update event
     *****************************************************/
    public void drawShip() {
       // set the transform for the image
       ship.transform();
       ship.draw();

        //draw bounding rectangle around ship
        if (showBounds) {
			if (ship.state() == SPRITE_COLLIDED)
			{
				ship.drawBounds(Color.RED);
			}
	        else
			{
				ship.drawBounds(Color.BLUE);
			}
        }
    }

    /*****************************************************
     * drawBullets called by applet update event
     *****************************************************/
    public void drawBullets() {
        for (int n = 0; n < BULLETS; n++) {
            if (bullet[n].alive()) {
                //draw the bullet
                bullet[n].transform();
	            bullet[n].draw();
	            if (showBounds)
	            {
		            if (bullet[n].state() == SPRITE_COLLIDED)
		            {
			            bullet[n].drawBounds(Color.RED);
		            }
		            else
		            {
			            bullet[n].drawBounds(Color.BLUE);
		            }
	            }
            }
        }
    }

    /*****************************************************
     * drawAsteroids called by applet update event
     *****************************************************/
    public void drawAsteroids() {
        for (int n = 0; n < ASTEROIDS; n++) {
            if (ast[n].alive()) {
                //draw the asteroid
                ast[n].transform();
	            ast[n].draw();

                //draw bounding rectangle
                if (showBounds) {
	                if (ast[n].state() == SPRITE_COLLIDED)
	                {
		                ast[n].drawBounds(Color.RED);
	                }
	                else
	                {
		                ast[n].drawBounds(Color.BLUE);
	                }
                }
            }
        }
    }

	/*****************************************************
	 * drawExplosions called by applet update event
	 *****************************************************/
	/*public void drawExplosions()
	{
		if (explosion.alive())
		{
			explosion.updateAnimation();
			if (explosion.currentFrame() == explosion.totalFrames()-1)
			{
				explosion.setCurrentFrame(0);
				explosion.setAlive(false);
			}
			else {
				explosion.draw();
			}
		}
	}*/

    /*****************************************************
     * applet window repaint event--draw the back buffer
     *****************************************************/
    public void paint(Graphics g) {
        g.drawImage(backbuffer, 0, 0, this);
    }

    /*****************************************************
     * thread start event - start the game loop running
     *****************************************************/
    public void start() {
        gameloop = new Thread(this);
        gameloop.start();
    }
    /*****************************************************
     * thread run event (game loop)
     *****************************************************/
    public void run() {
        //acquire the current thread
        Thread t = Thread.currentThread();
        //keep going as long as the thread is alive
        while (t == gameloop) {
            try {
                Thread.sleep(15);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            //update the game loop
            gameUpdate();
            repaint();
        }
    }
    /*****************************************************
     * thread stop event
     *****************************************************/
    public void stop() {
        gameloop = null;
    }

    /*****************************************************
     * move and animate the objects in the game
     *****************************************************/
    private void gameUpdate() {
	    checkInput();
        updateShip();
        updateBullets();
        updateAsteroids();
        if (collisionTesting){
	        checkCollisions();
	        handleShipCollisions();
	        handleBulletCollisions();
	        handleAsteroidCollisions();
        }
    }

    /*****************************************************
     * Update the ship position based on velocity
     *****************************************************/
    public void updateShip() {
	    ship.updatePosition();
	    double newx = ship.position().X();
	    double newy = ship.position().Y();

        //update ship's X position, wrap around left/right
        if (ship.position().X() < -10)
            newx = SCREENWIDTH + 10;
        else if (ship.position().X() > SCREENWIDTH + 10)
            newx = -10;

        //update ship's Y position, wrap around top/bottom
        if (ship.position().Y() < -10)
            newy = SCREENHEIGHT + 10;
        else if (ship.position().Y() > SCREENHEIGHT + 10)
            newy = -10;

	    ship.setPosition(new Point2D(newx, newy));
	    ship.setState(SPRITE_NORMAL);
    }

    /*****************************************************
     * Update the bullets based on velocity
     *****************************************************/
    public void updateBullets() {
        //move the bullets
        for (int n = 0; n < BULLETS; n++) {
            if (bullet[n].alive()) {
                //update bullet's x position
                bullet[n].updatePosition();
                //bullet disappears at left/right edge
                if (bullet[n].position().X() < 0 ||
                    bullet[n].position().X() > SCREENWIDTH)
                {
                    bullet[n].setAlive(false);
                }
                //update bullet's y position
                bullet[n].updatePosition();
                //bullet disappears at top/bottom edge
                if (bullet[n].position().Y() < 0 ||
                    bullet[n].position().Y() > SCREENHEIGHT)
                {
                    bullet[n].setAlive(false);
                }
	            bullet[n].setState(SPRITE_NORMAL);
            }
        }
    }

    /*****************************************************
     * Update the asteroids based on velocity
     *****************************************************/
    public void updateAsteroids() {
        //move and rotate the asteroids
        for (int n = 0; n < ASTEROIDS; n++) {
            if (ast[n].alive()) {
                //update the asteroid's X value
                ast[n].updatePosition();
	            ast[n].updateRotation();

	            int w = ast[n].imageWidth()-1;
	            int h = ast[n].imageHeight()-1;
                double newx = ast[n].position().X();
	            double newy = ast[n].position().Y();

	            if (ast[n].position().X() < -w)
                    newx = SCREENWIDTH + w;
                else if (ast[n].position().X() > SCREENWIDTH + w)
                    newx = -w;

                //update the asteroid's Y value
                if (ast[n].position().Y() < -h)
                    newy = SCREENHEIGHT + h;
                else if (ast[n].position().Y() > SCREENHEIGHT + h)
                    newy = -h;

                ast[n].setPosition(new Point2D(newx, newy));
	            ast[n].setState(SPRITE_NORMAL);
            }
        }
    }

    /*****************************************************
     * Test asteroids for collisions with ship or bullets
     *****************************************************/
    public void checkCollisions() {
        //check for ship and bullet collisions with asteroids
        for (int m = 0; m<ASTEROIDS; m++) {
            if (ast[m].alive()) {
                //check for bullet collisions
                for (int n = 0; n < BULLETS; n++) {
                    if (bullet[n].alive()) {
                        //perform the collision test
                        if (ast[m].collidesWith(bullet[n]))
                        {
                            bullet[n].setState(SPRITE_COLLIDED);
                            ast[m].setState(SPRITE_COLLIDED);
                            //explode.play();
                        }
                    }
                }

                //check for ship collision
                if (ship.collidesWith(ast[m])) {
                    ast[m].setState(SPRITE_COLLIDED);
                    ship.setState(SPRITE_COLLIDED);
	                //explode.play();
                }
            }
        }

    }

	/*****************************************************
	 * handle collisions
	 *****************************************************/
	public void handleShipCollisions()
	{
		if (ship.state() == SPRITE_COLLIDED)
		{
			collisionTimer = System.currentTimeMillis();
			ship.setVelocity(new Point2D(0, 0));
			ship.setState(SPRITE_EXPLODING);
			//startExplosion(ship);
		}
		else if (ship.state() == SPRITE_EXPLODING)
		{
			if (collisionTimer + 3000 < System.currentTimeMillis())
			{
				ship.setState(SPRITE_NORMAL);
			}
		}
	}

/*	public void startExplosion(Sprite sprite)
	{
		if (!explosion.alive())
		{
			double x = sprite.position().X() - sprite.getBounds().width / 2;
			double y = sprite.position().Y() - sprite.getBounds().height / 2;
			explosion.setPosition(new Point2D(x, y));
			explosion.setCurrentFrame(0);
			explosion.setAlive(true);
		}
	}*/

	public void handleBulletCollisions()
	{
		for (int n = 0; n < BULLETS; n++)
		{
			if (bullet[n].state() == SPRITE_COLLIDED)
			{
				//nothing yet
			}
		}
	}


	public void handleAsteroidCollisions()
	{
		for (int n = 0; n < ASTEROIDS; n++)
		{
			if (ast[n].state()== SPRITE_COLLIDED)
			{
				//nothing yet
			}
		}
	}


	/*****************************************************
	 * process keys that have been pressed
	 *****************************************************/
	public void checkInput()
	{
		if (keyLeft)
		{
			//left arrow rotates ship left 5 degrees
			ship.setFaceAngle(ship.faceAngle() - 5);
			if (ship.faceAngle() < 0) ship.setFaceAngle(360 - 5);
		}
		else if (keyRight)
		{
			//right arrow rotates ship right 5 degrees
			ship.setFaceAngle(ship.faceAngle() + 5);
			if (ship.faceAngle() > 360) ship.setFaceAngle(5);
		}
		if (keyUp)
		{
			//up arrow adds thrust to ship (1/20 normal speed)
			applyThrust();
		}
		else if (keyDown)
		{
			applyBrake();
		}
	}



	/*****************************************************
     * key listener events
     *****************************************************/
    public void keyTyped(KeyEvent k) { }
    public void keyPressed(KeyEvent k) {
        int keyCode = k.getKeyCode();

        switch (keyCode) {

        case KeyEvent.VK_LEFT:
            keyLeft = true;
            break;

        case KeyEvent.VK_RIGHT:
            keyRight = true;
            break;

        case KeyEvent.VK_UP:
            keyUp = true;
            break;

	    case KeyEvent.VK_DOWN:
		    keyDown = true;
		    break;

        //Space can be used to fire weapon
        case KeyEvent.VK_SPACE:
	        keyFire = true;
	        fireBullet();
            break;

        case KeyEvent.VK_B:
            //toggle bounding rectangles
            showBounds = !showBounds;
            break;
        case KeyEvent.VK_C:
	        //toggle collision testing
	        collisionTesting = !collisionTesting;
	        break;
        }
    }


	public void keyReleased(KeyEvent k) {
		int keyCode = k.getKeyCode();
		switch (keyCode) {
			case KeyEvent.VK_LEFT:
				keyLeft = false;
				break;

			case KeyEvent.VK_RIGHT:
				keyRight = false;
				break;

			case KeyEvent.VK_UP:
				keyUp = false;
				break;

			case KeyEvent.VK_DOWN:
				keyDown = false;
				break;

			case KeyEvent.VK_SPACE:
				keyFire = false;
				break;
		}
	}


	public void applyThrust()
	{
		//up arrow adds thrust to ship (1/20 normal speed)
		ship.setMoveAngle(ship.faceAngle() - 90);
		double velx = ship.velocity().X();
		velx += calcAngleMoveX(ship.moveAngle()) * ACCELERATION;
		double vely = ship.velocity().Y();
		vely += calcAngleMoveY(ship.moveAngle()) * ACCELERATION;
		ship.setVelocity(new Point2D(velx, vely));
	}

	public void applyBrake()
	{
		ship.setMoveAngle(ship.faceAngle() - 90);
		double velx = ship.velocity().X();
		double vely = ship.velocity().Y();
		if (velx != 0.0 && vely != 0.0)
		{
			velx += calcAngleMoveX(ship.moveAngle()) * -ACCELERATION;
			vely += calcAngleMoveY(ship.moveAngle()) * -ACCELERATION;
			ship.setVelocity(new Point2D(velx, vely));
		}
	}

	public void fireBullet()
	{
		currentBullet++;
		if (currentBullet > BULLETS - 1) currentBullet = 0;
		bullet[currentBullet].setAlive(true);

		//set bullets starting point
		int w = bullet[currentBullet].imageWidth();
		int h = bullet[currentBullet].imageHeight();
		double x = ship.center().X() - w/2;
		double y = ship.center().Y() - h/2;
		bullet[currentBullet].setPosition(new Point2D(x, y));

		//point bullet in same direction ship is facing
		bullet[currentBullet].setFaceAngle(ship.faceAngle());
		bullet[currentBullet].setMoveAngle(ship.faceAngle() - 90);

		//fire bullet at angle of the ship
		double angle = bullet[currentBullet].moveAngle();
		double svx = calcAngleMoveX(angle) * BULLET_SPEED;
		double svy = calcAngleMoveY(angle) * BULLET_SPEED;
		bullet[currentBullet].setVelocity(new Point2D(svx, svy));

		//play shoot sound
		//shot.play();
	}


    /*****************************************************
     * calculate X movement value based on direction angle
     *****************************************************/
    public double calcAngleMoveX(double angle) {
	    return Math.cos(angle * Math.PI / 180);
    }

    /*****************************************************
     * calculate Y movement value based on direction angle
     *****************************************************/
    public double calcAngleMoveY(double angle) {
	    return Math.sin(angle * Math.PI / 180);
    }

}
