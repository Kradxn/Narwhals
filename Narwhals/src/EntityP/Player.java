package EntityP;

import WorldP.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 17.05.13
 * Time: 21:11
 */
public class Player extends Entity {
    public Player(Image image, World world) {
        super(image, world);
        team = attr.friendly;
    }

    public void update(GameContainer gameContainer, int delta, World world) {
        super.update(gameContainer, delta, world);
        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT) && canMoveLeft(delta)) {
            velocityX -= 20;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT) && canMoveRight(delta)) {
            velocityX += 20;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP) && canMoveUp(delta) && !canMoveDown(delta))
            velocityY = -80;

        if (gameContainer.getInput().isKeyPressed(Input.KEY_P))
            System.out.println((gameContainer.getInput().getMouseX() + (rect.getX() - gameContainer.getWidth() / 2)) + " " + (-gameContainer.getInput().getMouseY() - (-rect.getY() - gameContainer.getHeight() / 3)));
        if (gameContainer.getInput().isKeyPressed(Input.KEY_SPACE)) attack();
    }

    private void attack() {
        if (stamina > 10) {
            stamina -= 10;
            if (rotation)
                try {
                    world.entities.add(new Projectile(new Image("res/hostile.png"), world, rect.getX() + rect.getWidth() + 10, rect.getY(), 50F, team));
                } catch (SlickException e) {
                    e.printStackTrace();
                }
            else {
                try {
                    world.entities.add(new Projectile(new Image("res/hostile.png"), world, rect.getX() - 50, rect.getY(), -50F, team));
                } catch (SlickException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
