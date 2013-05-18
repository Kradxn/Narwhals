package World;

import Entity.Entity;
import Entity.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.openal.SoundStore;

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
    ArrayList<Entity> entities = new ArrayList<Entity>();
    Music music;

    public World(Image firstBackGround, Image secondBackGround, ArrayList<Rectangle> collisions, Player player, Music music) {
        this.firstBackGround = firstBackGround;
        this.secondBackGround = secondBackGround;
        this.collisions = collisions;
        this.player = player;
        this.music = music;
        SoundStore.get().setMusicVolume(0.1F); //TODO OPTION
        music.loop();
    }

    public void render(GameContainer gameContainer, Graphics graphics) {
        firstBackGround.draw();
        //Camera Translation:
        gameContainer.getGraphics().translate(-player.getPosX() + gameContainer.getWidth() / 2, -player.getPosY() + gameContainer.getHeight() / 3);
        secondBackGround.draw();
        for (Entity e : entities) {
            e.render(gameContainer, graphics);
        }
        player.render(gameContainer, graphics);
    }

    public void update(GameContainer gameContainer, int delta) {
        for (Entity e : entities) {
            e.update(gameContainer, delta);
        }
        player.update(gameContainer, delta);
    }
}
