package EntityP;

import WorldP.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 17.05.13
 * Time: 22:48
 */
public class HostileEntity extends Entity {
    private int attackCoolDown;

    public HostileEntity(Image image, World world) {
        super(image, world);
        team = attr.hostile;
    }

    @Override
    public void update(GameContainer gameContainer, int delta, World world) {
        super.update(gameContainer, delta, world);
        Player player = getPlayerinReach();
        if (player != null) {
            if (Math.abs(player.getDistanceX(this)) > 400) {
                if (player.getDistanceX(this) < 0) {
                    velocityX -= 4;
                    if (!canMoveLeft(delta) && !canMoveDown(delta)) velocityY = -80;
                } else {
                    velocityX += 4;
                    if (!canMoveRight(delta) && !canMoveDown(delta)) velocityY = -80;
                }
            } else if (Math.abs(player.getDistanceY(this)) < 100) {
                if (attackCoolDown == 0) {
                    attack();
                    attackCoolDown = 100;
                }
            }
        }
        if (attackCoolDown > 0) attackCoolDown--;
    }

    private Player getPlayerinReach() {
        return world.player.isLessPAway(1000, this) ? world.player : null;
    }

    private void attack() {
        correctRotation();
        if (rotation)
            try {
                world.entities.add(new Projectile(new Image("res/projectile_F.png"), world, rect.getX() + rect.getWidth() + 10, rect.getY(), 50F, team));
            } catch (SlickException e) {
                e.printStackTrace();
            }
        else {
            try {
                world.entities.add(new Projectile(new Image("res/projectile_F.png"), world, rect.getX() - 50, rect.getY(), -50F, team));
            } catch (SlickException e) {
                e.printStackTrace();
            }

        }
    }

    private void correctRotation() {
        rotation = getPlayerinReach().getDistanceX(this) > 0;
    }
}
