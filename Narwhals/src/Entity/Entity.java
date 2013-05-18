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
    boolean rotation = false;
    int maxhealth = 100;
    public int health;
    public int stamina = 100;
    boolean dead = false;

    public Entity(Image image) {
        this.image = image;
        health = maxhealth;
    }

    Image image;
    int posX, posY;

    public void render(GameContainer gameContainer, Graphics graphics) {
        image.draw(posX + (rotation ? 0 : (int) (image.getWidth() * 0.1)), posY, (int) (image.getWidth() * 0.1) * (rotation ? 1 : -1), (int) (image.getHeight() * 0.1));
    }

    public void update(GameContainer gameContainer, int delta) {
        if (health < 0) dead = true;
        if (stamina < 100) stamina += delta;
        else stamina = 100;
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
