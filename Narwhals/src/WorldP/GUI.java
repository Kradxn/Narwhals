package WorldP;

import EntityP.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * Created with IntelliJ IDEA.
 * User: Fritz
 * Date: 18.05.13
 * Time: 15:58
 */
public class GUI {
    Player player;

    public GUI(Player player) {
        this.player = player;
    }


    public void render(GameContainer gameContainer, Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillRect(gameContainer.getWidth(), gameContainer.getHeight(), -player.health * 2, -15);


        graphics.setColor(Color.yellow);
        graphics.fillRect(gameContainer.getWidth(), gameContainer.getHeight() - 25, -player.stamina * 2, -15);
    }
}
