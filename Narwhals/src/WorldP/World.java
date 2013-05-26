package WorldP;

import EntityP.Entity;
import EntityP.HostileEntity;
import EntityP.Player;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.util.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

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
    public Player player;
    GUI gui;
    public CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<Entity>();
    Music music;
    Camera camera;

    public World(Image firstBackGround, Image secondBackGround, ArrayList<Rectangle> collisions, Player player, Music music, GameContainer gameContainer) throws SlickException {
        this.firstBackGround = firstBackGround;
        this.secondBackGround = secondBackGround;
        this.collisions = collisions;
        this.player = player;
        entities.add(player);
        this.music = music;
        gui = new GUI(player);
        SoundStore.get().setMusicVolume(0.1F); //TODO OPTION
        music.loop();
        player.world = this;
        camera = new Camera(player, gameContainer);
        entities.add(new HostileEntity(new Image("res/hostile.png"), this));
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        firstBackGround.draw();
        //Camera Translation:
        camera.update();
        graphics.translate(camera.getXTranslation(), camera.getYTranslation());
        secondBackGround.draw();
        graphics.setColor(Color.orange);
        for (Rectangle r : collisions) {
            graphics.draw(r);
        }
        for (Entity e : entities) {
            e.render(gameContainer, graphics);
        }
        //player.renderStory(graphics, "Ich bin ein    Narwhal ich binAWESOME");

        graphics.resetTransform();
        gui.render(gameContainer, graphics);
    }

    public void update(GameContainer gameContainer, int delta) {
        if (gameContainer.getInput().isKeyPressed(Input.KEY_E)) new LevelEditor(this, gameContainer);
        for (Entity e : entities) {
            e.update(gameContainer, delta, this);
            if (e.dead) entities.remove(e);
        }
    }

    public boolean isCollided(Shape shape) {
        for (Rectangle e : collisions) {
            if (e.intersects(shape)) return true;
        }
        return false;
    }

    public static World load(String worldname, Player player, GameContainer gameContainer) throws SlickException {
        return new World(new Image("res/worlds/" + worldname + "/firstbackground.png"), new Image("res/worlds/" + worldname + "/secondbackground.png"), loadCollisions(worldname), player, new Music("res/worlds/" + worldname + "/backgroundmusic.wav"), gameContainer);
    }

    public static ArrayList<Rectangle> loadCollisions(String worldname) {
        ArrayList<Rectangle> collisions = new ArrayList<Rectangle>();
        InputStream inputStream = ResourceLoader.getResourceAsStream("res/worlds/" + worldname + "/collisions.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.startsWith("#")) {
                    String[] coords = line.split(" ");
                    collisions.add(new Rectangle(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2]), Integer.parseInt(coords[3])));
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return collisions;
    }

    public ArrayList<Entity> getEntitiesinRectangle(Rectangle rect) {
        ArrayList<Entity> list = new ArrayList<Entity>();
        for (Entity e : entities) {
            if (rect.intersects(e.rect)) list.add(e);
        }
        return list;
    }
}
