package World;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.geom.Rectangle;

//import org.newdawn.slick.Input;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 19.05.13
 * Time: 20:38
 */
public class LevelEditor implements MouseListener {

    private World world;
    private GameContainer gameContainer;
    int clickX, clickY;

    public LevelEditor(World world, GameContainer gameContainer) {
        this.world = world;
        this.gameContainer = gameContainer;
        gameContainer.getInput().addMouseListener(this);
    }

    @Override
    public void mouseWheelMoved(int i) {
    }

    @Override
    public void mouseClicked(int i, int i2, int i3, int i4) {
    }

    @Override
    public void mousePressed(int i, int i2, int i3) {
        clickX = (int) (i2 - world.camera.getXTranslation());
        clickY = (int) (i3 - world.camera.getYTranslation());
    }

    @Override
    public void mouseReleased(int i, int i2, int i3) {
        world.collisions.add(new Rectangle(clickX, clickY, -(clickX - (i2 - world.camera.getXTranslation())), -(clickY - (i3 - world.camera.getYTranslation()))));

    }

    @Override
    public void mouseMoved(int i, int i2, int i3, int i4) {
    }

    @Override
    public void mouseDragged(int i, int i2, int i3, int i4) {

    }

    @Override
    public void setInput(Input input) {
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
    }
}
