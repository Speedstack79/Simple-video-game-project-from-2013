package javagame;

import org.lwjgl.input.*; //input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class shopstate1 extends BasicGameState
{
	Animation john, movingUp, movingDown, movingLeft, movingRight;
	Image shopState;
	int[] duration = {200, 200};
	boolean quit = false;
	float johnPositionX = 0;
	float johnPositionY = 0;
	float shiftX = johnPositionX + 450;
	float shiftY = johnPositionY + 300;
	public shopstate1(int state)
	{
		
	}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		shopState = new Image("res/mainState.png");
		
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
		shopState.draw(johnPositionX, johnPositionY);
		john.draw(shiftX, shiftY);
		
		g.drawString("X: " + johnPositionX + " \nY: " + johnPositionY, 800, 50);
		
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
		
	}

	public int getID()
	{
		return 2;
	}

}