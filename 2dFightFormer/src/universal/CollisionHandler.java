package universal;

import extendables.SlickClass;
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

    private TestBlock block;
    private Player player;

    public CollisionHandler(TestBlock test) {
        block = test;
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
        if (player.getBounds().intersects(block.getBounds())) {
            if (player.getyPos() < block.getMiddleY() && !player.isJumping()) {
                player.setFooting(block.getBounds().getMinY() - 1);
            }
        }
    }

}
