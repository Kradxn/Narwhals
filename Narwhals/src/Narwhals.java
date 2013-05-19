import Entity.Player;
import World.World;
import org.newdawn.slick.*;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 17.05.13
 * Time: 20:43
 */
public class Narwhals extends BasicGame {
    World currentWorld;

    public Narwhals() {
        super("Narwhals");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        currentWorld = World.load("world1", new Player(new Image("res/narwhals.png")));
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        currentWorld.update(gameContainer, delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        currentWorld.render(gameContainer, graphics);
    }

    public static void main(String[] args) {


        try {
            AppGameContainer app = new AppGameContainer(new Narwhals());
            app.setDisplayMode(800, 600, false);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }
}
