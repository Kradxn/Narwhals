import org.newdawn.slick.*;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 17.05.13
 * Time: 20:43
 */
public class Narwhals extends BasicGame {
    public Narwhals() {
        super("Narwhals");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

    }

    public static void main(String[] args){


        try {
            AppGameContainer app = new AppGameContainer(new Narwhals());
            app.setDisplayMode(800, 600, false);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }
}
