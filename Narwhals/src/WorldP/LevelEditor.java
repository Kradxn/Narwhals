package WorldP;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.geom.Rectangle;


/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 19.05.13
 * Time: 20:38
 */
public class LevelEditor implements MouseListener {

    private World world;
    private GameContainer gameContainer;
    float clickX, clickY;

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
        if (i == Input.MOUSE_LEFT_BUTTON) {
            clickX = (i2 - world.camera.getXTranslation());
            clickY = (i3 - world.camera.getYTranslation());
        }
    }

    @Override
    public void mouseReleased(int i, int i2, int i3) {
        if (i == Input.MOUSE_LEFT_BUTTON) {
            float x = clickX;
            float y = clickY;
            float widht = -(clickX - (i2 - world.camera.getXTranslation()));
            float height = -(clickY - (i3 - world.camera.getYTranslation()));
            if (widht < 0) {
                x = i2 - world.camera.getXTranslation();
                widht = -i2 + clickX + world.camera.getXTranslation();
            }
            if (height < 0) {
                y = i3 - world.camera.getYTranslation();
                height = -i3 + clickY + world.camera.getYTranslation();
            }

            world.collisions.add(new Rectangle(x, y, widht, height));
        } else {
            world.collisions.remove(world.collisions.size() - 1);
        }
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
