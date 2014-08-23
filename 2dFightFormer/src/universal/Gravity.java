package universal;

import extendables.SlickClass;
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
public class Gravity implements SlickClass {

    private float gravityPull = 0.25f;
    private Player player;

    public Gravity() {
        player = PlayerHandler.getPlayer();
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        pullPlayer();
    }
    
    private void pullPlayer(){
        if(!player.isOnGround() && !player.isJumping()){
            player.changeVerticalMomentum(gravityPull);
        }
    }

    public float getGravityPull() {
        return gravityPull;
    }

    public void setGravityPull(float gravityPull) {
        this.gravityPull = gravityPull;
    }
    
    

}
