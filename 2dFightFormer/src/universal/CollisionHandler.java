package universal;

import extendables.Platform;
import extendables.SlickClass;
import java.util.ArrayList;
import levelblocks.TestBlock;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import player.Player;
import player.PlayerHandler;

/**
 *
 * @author PK
 */
public class CollisionHandler implements SlickClass {

    private ArrayList<Platform> platforms;
    private Player player;

    public CollisionHandler(ArrayList<Platform> platforms) {
        this.platforms = platforms;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        player = PlayerHandler.getPlayer();

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        playerCollision();
    }

    private void playerCollision() {
        for (Platform p : platforms) {
            if (player.getBounds().intersects(p.getBounds())) {
                if (player.getyPos() < p.getMiddleY() && !player.isJumping()) {
                    player.setFooting(p);
                }
            }
        }
    }

}
