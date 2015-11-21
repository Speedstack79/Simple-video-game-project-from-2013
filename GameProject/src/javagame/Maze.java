package javagame;

import org.lwjgl.input.*; //input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Maze extends BasicGameState
{
	boolean subm = false;
	Animation john, movingUp, movingDown, movingLeft, movingRight;
	Image mazeState;
	public static final String  gamename = "Skycraft 2.0";
	int[] duration = {200, 200};
	boolean quit = false;
	float johnPositionX = 0;
	float johnPositionY = 0;
	float shiftX = johnPositionX + 450;
	float shiftY = johnPositionY + 262;
	public static int points = 0;
	public Maze(int state)
	{
	
	}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		mazeState = new Image("res/parkour.png");
		
		Image[] walkUp = {new Image("res/back.png"), new Image("res/back.png")};
		Image[] walkDown = {new Image("res/front.png"), new Image("res/front.png")};
		Image[] walkLeft = {new Image("res/left.png"), new Image("res/left.png")};
		Image[] walkRight = {new Image("res/right.png"), new Image("res/right.png")};
		
		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		john = movingDown;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		mazeState.draw(johnPositionX, johnPositionY);
		john.draw(shiftX, shiftY);
		
		g.setColor(Color.black);
		g.drawString("X: " + johnPositionX + " \nY: " + johnPositionY, 800, 50);
		g.drawString("Maze not done yet\nneeds collision detectors.", 600, 90);
		if(subm == true)
		{
			g.drawString("Resume epic game (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 150);
			g.drawString("Quit epic game (Q)", 250, 200);
			if(quit == false)
			{
				g.clear();
			}
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		Input input = gc.getInput();
		Thread waiter = new Thread(new Thread());
		
		if(input.isKeyDown(Input.KEY_A))
		{
			john = movingLeft;
			johnPositionX += delta *.1f;//+ is left
			if(johnPositionX > 455)
			{
				johnPositionX -= delta *.1f;//- is right
				if(johnPositionX < -1010)
				{
					johnPositionX += delta *.1f;
				}
			}
		}
		if(input.isKeyDown(Input.KEY_D))
		{
			john = movingRight;
			johnPositionX -= delta *.1f;
			if(johnPositionX < -1016)
			{
				johnPositionX += delta *.1f;//push left
			}
		}
		if(input.isKeyDown(Input.KEY_SPACE))
		{
			
			for(int i = 0; i <= 3; i++)
			{
				johnPositionY += 2.5;
			}
			try
			{
				waiter.sleep(150);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			for(int i = 0; i >= 1; i--)
			{
				johnPositionY -= 2.5;
			}
		}
		if(input.isKeyDown(Input.KEY_P))
		{
			john = movingUp;
			johnPositionY -= delta * .1f;
		}
		if(input.isKeyDown(Input.KEY_ESCAPE))
		{
			subm = true;
		}
		if(subm == true)
		{
			if(input.isKeyDown(Input.KEY_R))
			{
				subm = false;
			}
			if(input.isKeyDown(Input.KEY_M))
			{
				sbg.enterState(0);
			}
			if(input.isKeyDown(Input.KEY_Q))
			{
				System.exit(0);
			}
		}
		if(johnPositionX < -167 && johnPositionX > -200)
		{
			johnPositionX += delta * .1f;//+ is left
			if(johnPositionY < 28 && johnPositionY >= 0)
			{
				
			}
		}
		if(johnPositionX < -200 && johnPositionX > -249)
		{
			johnPositionX -= delta * .1f;//0 is right
		}
		
	}

	public int getID()
	{
		return 3;
	}

}