package EntityP;

import WorldP.World;
import org.newdawn.slick.GameContainer;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 17.05.13
 * Time: 22:48
 */
public class HostileEntity extends Entity {
    private int attackCoolDown;

    public HostileEntity(World world, String aniName) {
        super(world, aniName);
        team = attr.hostile;
    }

    public HostileEntity(World world, String aniName, int x, int y) {
        this(world, aniName);
        rect.setX(x);
        rect.setY(y);
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
            } else if (Math.abs(player.getDistanceY(this)) < 50) {
                if (attackCoolDown == 0) {
                    attack();
                    attackCoolDown = 400;
                }
            } else {
                velocityX *= 1.43;
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

            world.entities.add(new Projectile(world, "projectileF", rect.getX() + rect.getWidth() + 10, rect.getY(), 50F, team));

        else {
            world.entities.add(new Projectile(world, "projectileF", rect.getX() - 50, rect.getY(), -50F, team));


        }
    }

    private void correctRotation() {
        rotation = getPlayerinReach().getDistanceX(this) > 0;
    }
}
