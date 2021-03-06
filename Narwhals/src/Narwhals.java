import EntityP.Player;
import WorldP.TextureProvider;
import WorldP.World;
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
        gameContainer.setVSync(true);
        gameContainer.setSmoothDeltas(true);
        gameContainer.setMinimumLogicUpdateInterval(5);
        gameContainer.setMaximumLogicUpdateInterval(5);
        preloadTextures();
        currentWorld = World.load("world1", new Player(currentWorld, "narwhal"), gameContainer);
    }

    private void preloadTextures() throws SlickException {
        TextureProvider.registerAnimationbyPath("narwhal", "narwhals", 3, 10);
        TextureProvider.registerAnimationbyPath("projectileF", "projectile_F", 1, 10);
        TextureProvider.registerAnimationbyPath("projectileEis", "projectile_eis", 1, 10);
        TextureProvider.registerAnimationbyPath("hostile", "hostile", 3, 10);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        currentWorld.update(gameContainer, delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.setLineWidth(3);
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
