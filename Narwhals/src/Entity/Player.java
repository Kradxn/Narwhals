package Entity;

import World.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 17.05.13
 * Time: 21:11
 */
public class Player extends Entity {
    public Player(Image image, World world) {
        super(image, world);
    }

    public void update(GameContainer gameContainer, int delta, World world) {
        super.update(gameContainer, delta, world);
        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT) && canMoveLeft(delta)) {
            velocityX -= 20;
            rotation = false;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT) && canMoveRight(delta)) {
            velocityX += 20;
            rotation = true;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP) && canMoveUp(delta) && !canMoveDown(delta))
            velocityY = -80;

        if (gameContainer.getInput().isKeyPressed(Input.KEY_P))
            System.out.println((gameContainer.getInput().getMouseX() + (rect.getX() - gameContainer.getWidth() / 2)) + " " + (-gameContainer.getInput().getMouseY() - (-rect.getY() - gameContainer.getHeight() / 3)));
    }
}
