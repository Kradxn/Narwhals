package EntityP;

import WorldP.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 17.05.13
 * Time: 21:11
 */
public class Player extends Entity {
    public Player(World world, String aniName) {
        super(world, aniName);
        rect.setX(1000);
        rect.setY(600);
        team = attr.friendly;
    }

    public void update(GameContainer gameContainer, int delta, World world) {
        super.update(gameContainer, delta, world);
        chechInput(gameContainer, delta, world);
    }

    private void chechInput(GameContainer gameContainer, int delta, World world) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT) && canMoveLeft(delta)) {
            velocityX -= 20;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT) && canMoveRight(delta)) {
            velocityX += 20;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP) && canMoveUp(delta) && !canMoveDown(delta))
            velocityY = -80;

        if (gameContainer.getInput().isKeyPressed(Input.KEY_P))
            System.out.println((gameContainer.getInput().getMouseX() - world.camera.getXTranslation()) + " " + (-gameContainer.getInput().getMouseY() + world.camera.getYTranslation()));
        if (gameContainer.getInput().isKeyPressed(Input.KEY_SPACE)) attack();
        if (gameContainer.getInput().isKeyPressed(Input.KEY_F1)) world.debug = !world.debug;
        if (gameContainer.getInput().isKeyPressed(Input.KEY_F2))
            world.entities.add(new HostileEntity(world, "hostile", 200, 600));


    }

    private void attack() {
        if (stamina > 10) {
            stamina -= 10;
            if (rotation)
                world.entities.add(new Projectile(world, "projectileEis", rect.getX() + rect.getWidth() + 10, rect.getY(), 50F, team));
            else {
                world.entities.add(new Projectile(world, "projectileEis", rect.getX() - 50, rect.getY(), -50F, team));
            }

        }
    }

}
