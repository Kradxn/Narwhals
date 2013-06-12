package WorldP;

import EntityP.Player;
import org.newdawn.slick.GameContainer;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 19.05.13
 * Time: 21:18
 */
public class Camera {
    Player player;
    GameContainer gameContainer;
    float Xtrans, Ytrans;

    public Camera(Player player, GameContainer gameContainer) {
        this.player = player;
        this.gameContainer = gameContainer;
    }

    public float getXTranslation() {
        return Xtrans;
    }

    public float getYTranslation() {
        return Ytrans;
    }


    public void update() {
        if (Xtrans > -player.rect.getX() + gameContainer.getWidth() - gameContainer.getWidth() / 2)
            Xtrans = -player.rect.getX() + gameContainer.getWidth() - gameContainer.getWidth() / 2;
        if (Xtrans < -player.rect.getX() + gameContainer.getWidth() / 4)
            Xtrans = -player.rect.getX() + gameContainer.getWidth() / 4;
        if (Ytrans < -player.rect.getY() + gameContainer.getHeight() / 5)
            Ytrans = -player.rect.getY() + gameContainer.getHeight() / 5;
        if (Ytrans > -player.rect.getY() + gameContainer.getHeight() - gameContainer.getHeight() / 2.5)
            Ytrans = -player.rect.getY() + gameContainer.getHeight() - gameContainer.getHeight() / 2.5F;
    }
}
