package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

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

    public void renderStory(Graphics graphics, String s) throws SlickException {
        float scale = 0.3F;
        graphics.pushTransform();
        graphics.scale(scale, scale);
        Image image = new Image("res/blase.png");
        image.draw(posX / scale + (rotation ? 0 : image.getWidth()), posY / scale - image.getHeight(), image.getWidth() * (rotation ? 1 : -1), image.getHeight());
        graphics.popTransform();
        if (s.length() < 15) {
            graphics.drawString(s, posX + 5, posY - image.getHeight() * scale + 10);
        } else if (s.length() < 30) {
            graphics.drawString(s.substring(0, 15), posX + 5, posY - image.getHeight() * scale + 10);
            graphics.drawString(s.substring(15), posX + 5, posY - image.getHeight() * scale + 30);
        } else {
            graphics.drawString(s.substring(0, 15), posX + 5, posY - image.getHeight() * scale + 10);
            graphics.drawString(s.substring(15, 30), posX + 5, posY - image.getHeight() * scale + 30);
            graphics.drawString(s.substring(30), posX + 5, posY - image.getHeight() * scale + 50);
        }
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
