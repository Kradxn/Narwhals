package Entity;

import World.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 17.05.13
 * Time: 22:48
 */
public class HostileEntity extends Entity {
    public HostileEntity(Image image, World world) {
        super(image, world);
    }

    @Override
    public void update(GameContainer gameContainer, int delta, World world) {
        super.update(gameContainer, delta, world);
        Player player = getPlayerinReach();
        if (player != null && Math.abs(player.getDistanceX(this)) > 100) {
            if (player.getDistanceX(this) < 0) {
                velocityX -= 4;
                if (!canMoveLeft(delta) && !canMoveDown(delta)) velocityY = -80;
            } else {
                velocityX += 4;
                if (!canMoveRight(delta) && !canMoveDown(delta)) velocityY = -80;
            }

        }
    }

    private Player getPlayerinReach() {
        return world.player.isLessPAway(1000, this) ? world.player : null;
    }


}
