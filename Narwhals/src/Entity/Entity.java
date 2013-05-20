package Entity;

import World.World;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

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
    public Rectangle rect;
    Image image;
    public World world;
    float velocityX, velocityY;

    public Entity(Image image, World world) {
        this.image = image;
        this.world = world;
        health = maxhealth;
        rect = new Rectangle(0, -300, 100, 130);
    }


    public void render(GameContainer gameContainer, Graphics graphics) {
        image.draw(rect.getX() + (rotation ? 0 : rect.getWidth()), rect.getY(), rect.getWidth() * (rotation ? 1 : -1), rect.getHeight());
        graphics.setColor(Color.blue);
        graphics.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
    }

    public void update(GameContainer gameContainer, int delta, World world) {
        if (health < 0) dead = true;
        if (stamina < 100) stamina += delta;
        else stamina = 100;


        if (canMoveUp(delta) && velocityY < 0) rect.setY((float) (rect.getY() + velocityY * 0.01 * delta));
        else if (velocityY < 0) velocityY = 0;
        if (canMoveLeft(delta) && velocityX < 0) rect.setX((float) (rect.getX() + velocityX * 0.01 * delta));
        else if (velocityX < 0) velocityX = 0;
        if (canMoveRight(delta) && velocityX > 0) rect.setX((float) (rect.getX() + velocityX * 0.01 * delta));
        else if (velocityX > 0) velocityX = 0;
        if (canMoveDown(delta)) {
            if (velocityY > 0) rect.setY((float) (rect.getY() + velocityY * 0.01 * delta));
            velocityY += delta * 0.2;
        } else if (velocityY > 0) velocityY = 0;
        velocityX *= 0.6;
        velocityY *= 0.99;
    }

    public boolean canMoveLeft(int delta) {
        return !world.isCollided(new Rectangle(rect.getX() + velocityX * 0.01F * delta, rect.getY(), 2, rect.getHeight()));
    }

    public boolean canMoveRight(int delta) {
        return !world.isCollided(new Rectangle(rect.getX() + rect.getWidth() + velocityX * 0.01F * delta, rect.getY(), 2, rect.getHeight()));
    }

    public boolean canMoveUp(int delta) {
        return !world.isCollided(new Rectangle(rect.getX(), rect.getY() + velocityY * 0.01F * delta, rect.getWidth(), 2));
    }

    public boolean canMoveDown(int delta) {
        return !world.isCollided(new Rectangle(rect.getX(), rect.getY() + rect.getHeight() + velocityY * 0.01F * delta, rect.getWidth(), 2));
    }

    public void renderStory(Graphics graphics, String s) throws SlickException {

        Image image = new Image("res/blase.png");
        image.draw(rect.getX() + (rotation ? 0 : 200) - 20, rect.getY() - 100, 200 * (rotation ? 1 : -1), 100);
        if (s.length() < 15) {
            graphics.drawString(s, rect.getX() + 5, rect.getY() - 100 + 10);
        } else if (s.length() < 30) {
            graphics.drawString(s.substring(0, 15), rect.getX() + 5, rect.getY() - 100 + 10);
            graphics.drawString(s.substring(15), rect.getX() + 5, rect.getY() - 100 + 30);
        } else {
            graphics.drawString(s.substring(0, 15), rect.getX() + 5, rect.getY() - 100 + 10);
            graphics.drawString(s.substring(15, 30), rect.getX() + 5, rect.getY() - 100 + 30);
            graphics.drawString(s.substring(30), rect.getX() + 5, rect.getY() - 100 + 50);
        }
    }

}
