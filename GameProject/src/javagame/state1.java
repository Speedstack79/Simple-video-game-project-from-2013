package javagame;

import org.lwjgl.input.*; //input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

//main menu
public class state1 extends BasicGameState
{
	Image playNow, playNowHover, exitGame, exitGameHover;
	

	public state1(int state)
	{
		
	}
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
   {
	   playNow = new Image("res/playnow.png");
	   playNowHover = new Image("res/playnowhover.png");
	   exitGame = new Image("res/exitgame.png");
	   exitGameHover = new Image("res/exitgamehover.png");
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
   {
	   playNow.draw(300, 50);
	   exitGame.draw(300, 250);
	   int posX = Mouse.getX();
	   int posY = Mouse.getY();
	   g.drawString("X: " + posX + "\nY: " + posY, 800, 50);
	   g.drawString("PROGRAMMED BY:\nJOHNNY CEJA\nWITH JAVA", 650, 518);
	   if((posX > 300 && posX < 650) && (posY > 475 && posY < 550))
		{
			playNowHover.draw(300,50);
		}
	   if((posX > 300 && posX < 650) && (posY > 275 && posY < 350))
		{
			exitGameHover.draw(300, 250);
		}
   }
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
   {
	     
	   int posX = Mouse.getX();
	   int posY = Mouse.getY();
	   if((posX > 300 && posX < 650) && (posY > 475 && posY < 550))
		{
			if(Mouse.isButtonDown(0))
			{
				sbg.enterState(1);
			}
		}
	   if((posX > 300 && posX < 650) && (posY > 275 && posY < 350))
		{
			if(Mouse.isButtonDown(0))
			{
				System.exit(0);
			}
		}
	 
   }  
   
   public int getID()
   {
      return 0;
   }
}