package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 17.05.13
 * Time: 21:07
 */
public class Entity {


    int posX,posY;

    public void render(GameContainer gameContainer, Graphics graphics){

    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
