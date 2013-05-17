package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 17.05.13
 * Time: 21:07
 */
public class Entity {

    public Entity(Image image) {
        this.image = image;
    }

    Image image;
    int posX,posY;

    public void render(GameContainer gameContainer, Graphics graphics){
     image.draw(0,0,0.2F);
    }

    public void update(GameContainer gameContainer, int delta) {

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
