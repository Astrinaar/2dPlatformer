package universal;

import extendables.GameCharacter;
import extendables.Platform;
import extendables.SlickClass;
import java.util.ArrayList;
import levelblocks.TestBlock;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
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
        Rectangle playerBounds = player.getBounds();
        for (Platform p : platforms) {
            if (playerBounds.intersects(p.getBounds())) {
                if (isAboveOrUnder(p, player)) {
                    if (player.getMiddleY() < p.getMiddleY() && !player.isJumping()) {
                        player.setFooting(p);
                    } else if(player.getMiddleY() > p.getMiddleY()){
                        player.stayUnder(p);
                    }
                }
                 else if (player.getMiddleX() < p.getBounds().getMinX()){
                     player.stayLeftOf(p);
                 } else if (player.getMiddleX() > p.getBounds().getMaxX()){
                     player.stayRightOf(p);
                 }
            }
        }
    }

    public boolean isAboveOrUnder(Platform platform, GameCharacter gameCharacter) {
        if (gameCharacter.getMiddleX() > platform.getBounds().getMinX() && gameCharacter.getMiddleX() < platform.getBounds().getMaxX()) {
            return true;
        }
        return false;
    }

}
