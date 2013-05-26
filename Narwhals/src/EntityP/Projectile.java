package EntityP;

import WorldP.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

import java.util.ArrayList;

/**
 * User: Fritz
 * Date: 23.05.13
 * Time: 23:20
 */
public class Projectile extends Entity {
    int ticks = 0;

    public Projectile(Image image, World world) {
        super(image, world);
        rect.setWidth(50);
        rect.setHeight(70);
        gravity = 0;
        frictionX = 1;

    }

    public Projectile(Image image, World world, float x, float y, float velocityX, attr team) {
        this(image, world);
        rect.setX(x);
        rect.setY(y);
        this.velocityX = velocityX;
        this.team = team;
    }

    @Override
    public void update(GameContainer gameContainer, int delta, World world) {
        super.update(gameContainer, delta, world);
        ticks++;
        if (ticks > 200) dead = true;
        ArrayList<Entity> list = world.getEntitiesinRectangle(rect);
        if (list.size() > 0) explode(list);
    }

    private void explode(ArrayList<Entity> list) {
        for (Entity e : list) {
            if (!(e.team == team)) {
                e.health -= 10;
                dead = true;
            }

        }

    }


}
