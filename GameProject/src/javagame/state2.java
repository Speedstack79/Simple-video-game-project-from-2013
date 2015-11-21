package javagame;

//import org.lwjgl.input.*; //input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

//gameplay state one
public class state2 extends BasicGameState
{
	boolean subm = false;
	Animation john, movingUp, movingDown, movingLeft, movingRight;
	int maze = 0;
	Image world1;
	int[] duration = {200, 200};
	boolean quit = false;
	float johnPositionX = -1*0;
	float johnPositionY = 0;
	float shiftX = johnPositionX + 450;
	float shiftY = johnPositionY + 300;
	public state2(int state)
	{
		
	}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		world1 = new Image("res/mainState.png");
		Image[] walkUp = {new Image("res/back.png"), new Image("res/back.png")};
		Image[] walkDown = {new Image("res/front.png"), new Image("res/front.png")};
		Image[] walkLeft = {new Image("res/left.png"), new Image("res/left.png")};
		Image[] walkRight = {new Image("res/right.png"), new Image("res/right.png")};

		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		john = movingDown;
		
		johnPositionX = 0;
		johnPositionY = 0;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		
		world1.draw(johnPositionX, johnPositionY);
		john.draw(shiftX, shiftY);
		g.drawString("X: " + -1*johnPositionX + " \nY: " + johnPositionY, 800, 50);
		
		if(subm == true)//working but screen turns black
		{
			g.drawString("Resume epic game (R)", 0, 0);
			g.drawString("Main Menu (M)", -0, 50);
			g.drawString("Quit epic game (Q)", -0, 100);
			
			if(quit == false)
			{
				g.clear();
			}
		}
		}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_W))
		{
			john = movingUp;
			johnPositionY += delta *.1f;
			if(johnPositionY > 300)
			{
				johnPositionY -= delta *.1f;
			}
		}
		if(input.isKeyDown(Input.KEY_A))
		{
			john = movingLeft;
			johnPositionX += delta *.1f;
			if(johnPositionX > 455)
			{
				johnPositionX -= delta *.1f;
				if(johnPositionX < -1010)
				{
					johnPositionX += delta *.1f;
				}
			}
		}
		if(input.isKeyDown(Input.KEY_S))
		{
			john = movingDown;
			johnPositionY -= delta *.1f;
			if(johnPositionY < -1163)
			{;
				johnPositionY +=delta *.1f;
			}
		}
		if(input.isKeyDown(Input.KEY_D))
		{
			john = movingRight;
			johnPositionX -= delta *.1f;
			if(johnPositionX < -1016)
			{
				johnPositionX += delta *.1f;
			}
		}
	
		//for X coords, make negative and invert symbol
			if((johnPositionX < -205 && johnPositionX > -274)&&(johnPositionY < -380 && johnPositionY > -433))
			{
				
				System.out.print("enter attempt");
				int counter;
				sbg.enterState(Game.maze);		
				
				
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
	}

	public int getID()
	{
		return 1;
	}

}
