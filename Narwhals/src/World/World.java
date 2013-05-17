package World;

import Entity.Entity;
import Entity.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 17.05.13
 * Time: 21:02
 */
public class World {
    Image firstBackGround;
    Image secondBackGround;
    ArrayList<Rectangle> collisions;
    Player player;
    ArrayList<Entity> entities=new ArrayList<Entity>();

    public World(Image firstBackGround, Image secondBackGround, ArrayList<Rectangle> collisions, Player player) {
        this.firstBackGround = firstBackGround;
        this.secondBackGround = secondBackGround;
        this.collisions = collisions;
        this.player = player;
    }

    public void render(GameContainer gameContainer, Graphics graphics){
       firstBackGround.draw();
       secondBackGround.draw(player.getPosX(),player.getPosY());
        for(Entity e:entities){
            e.render(gameContainer,graphics);
        }
    }

    public void update(GameContainer gameContainer, int delta){
        for(Entity e:entities){
            e.update(gameContainer,delta);
        }
        player.update(gameContainer,delta);
    }
}
