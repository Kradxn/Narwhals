package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 17.05.13
 * Time: 21:11
 */
public class Player extends Entity {
    public void update(GameContainer gameContainer, int delta) {
         super.update(gameContainer,delta);
         if(gameContainer.getInput().isKeyDown(Input.KEY_LEFT))posX++;
         if(gameContainer.getInput().isKeyDown(Input.KEY_RIGHT))posX--;
        if(gameContainer.getInput().isKeyDown(Input.KEY_UP))posY++;
        if(gameContainer.getInput().isKeyDown(Input.KEY_DOWN))posY--;
    }
}
