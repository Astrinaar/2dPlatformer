package player;

import extendables.SlickClass;
import helpers.MathTool;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class PlayerHandler implements SlickClass {

    private static Player player;
    private boolean dead = false;

    public PlayerHandler() {
        player = new Player();
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        player.init(container, game);
        MathTool.setPlayer(player);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        player.render(container, game, g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        if (player.getLife() <= 0) {
            dead = true;
        }
        player.update(container, game, delta);
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public static Player getPlayer() {
        return player;
    }

}
