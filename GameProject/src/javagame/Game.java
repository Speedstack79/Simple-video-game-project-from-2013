package javagame;

import org.lwjgl.input.*; //input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame
{
	public static final int points = 0;
	public static final String  gamename = "Skycraft 2.0";
	public static final int menu = 0; //menu, class is state1
	public static final int state1 = 1;//main state, class is state2
	public static final int shop = 2;//shop or maze state is shopstate1
	public static final int maze = 3;
	
	public Game(String gamename)
	{
		super(gamename + " Points: " + points);
		this.addState(new state1(menu)); //class is MainMenu variable is menu
		this.addState(new state2(state1));//state2 is the class state1 is the int
		this.addState(new shopstate1(shop));
		this.addState(new Maze(maze));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException 
	{
		this.getState(menu).init(gc, this);
		this.getState(state1).init(gc, this);
		this.getState(shop).init(gc, this);
		this.getState(maze).init(gc, this);
		this.enterState(menu); //default screen is menu screen
	}
	
	public static void main(String args[])
	{
		AppGameContainer appgc;
		try
		{
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(900, 600, false);
			appgc.start();
			
		}
		catch(SlickException e)
		{
			e.printStackTrace(); //if get error, hopefully will not happen
		}
	}
}