package World;

import Entity.Entity;
import Entity.Player;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.util.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    GUI gui;
    ArrayList<Entity> entities = new ArrayList<Entity>();
    Music music;

    public World(Image firstBackGround, Image secondBackGround, ArrayList<Rectangle> collisions, Player player, Music music) {
        this.firstBackGround = firstBackGround;
        this.secondBackGround = secondBackGround;
        this.collisions = collisions;
        this.player = player;
        this.music = music;
        gui = new GUI(player);
        SoundStore.get().setMusicVolume(0.1F); //TODO OPTION
        music.loop();
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        firstBackGround.draw();
        //Camera Translation:
        graphics.translate(-player.getPosX() + gameContainer.getWidth() / 2, -player.getPosY() + gameContainer.getHeight() / 3);
        secondBackGround.draw();
        for (Entity e : entities) {
            e.render(gameContainer, graphics);
        }
        player.render(gameContainer, graphics);
        player.renderStory(graphics, "Ich bin ein    Narwhal ich binAWESOME");
        graphics.resetTransform();
        gui.render(gameContainer, graphics);
    }

    public void update(GameContainer gameContainer, int delta) {
        for (Entity e : entities) {
            e.update(gameContainer, delta);
        }
        player.update(gameContainer, delta);
    }

    public static World load(String worldname, Player player) throws SlickException {
        return new World(new Image("res/worlds/" + worldname + "/firstbackground.png"), new Image("res/worlds/" + worldname + "/secondbackground.png"), null, player, new Music("res/worlds/" + worldname + "/backgroundmusic.wav"));
    }

    public static ArrayList<Rectangle> loadCollisions(String worldname) {
        ArrayList<Rectangle> collisions = new ArrayList<Rectangle>();
        InputStream inputStream = ResourceLoader.getResourceAsStream("res/worlds/" + worldname + "collisions,txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.startsWith("#")) {
                    String[] coords = line.split(" ");
                    collisions.add(new Rectangle(Integer.getInteger(coords[0]), Integer.getInteger(coords[1]), Integer.getInteger(coords[2]), Integer.getInteger(coords[3])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return collisions;
    }
}
