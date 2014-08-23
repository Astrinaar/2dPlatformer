package input;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import player.Player;
import player.PlayerHandler;

/**
 *
 * @author PK
 */
public class InputReceiver {

    private Input input;
    private PlayerHandler playerHandler;
    private boolean animationLock;

    public InputReceiver(PlayerHandler playerHandler) {
        this.playerHandler = playerHandler;
    }

    public void reactToInput(GameContainer container, int delta) {
        input = container.getInput();
        universalInput(container);
        inputForPlayer(delta);
    }

    public void inputForPlayer(int delta) {
        if (playerHandler.getAnimationLock() <= 0) {
            animationLock = false;
        } else {
            animationLock = true;
        }
        if (playerHandler.isOnGround()) {
            if (!animationLock) {
                if (input.isKeyDown(Input.KEY_D)) {
                    playerHandler.changeHorizontalMomentum(playerHandler.getSpeed());
                }
                if (input.isKeyDown(Input.KEY_A)) {
                    playerHandler.changeHorizontalMomentum(playerHandler.getSpeed() * -1);
                }
                if (input.isKeyDown(Input.KEY_W)) {
                    playerHandler.jump();
                } else if (input.isKeyDown(Input.KEY_S)) {
                    playerHandler.setHorizontalMomentum(15);
                    playerHandler.setVerticalMomentum(-7);
                } else if (input.isKeyDown(Input.KEY_SPACE)) {
                    playerHandler.attack(0);
                }
            }
        } else {
            if (input.isKeyDown(Input.KEY_D)) {
                playerHandler.changeHorizontalMomentum(playerHandler.getAirborneSpeed());
            }
            if (input.isKeyDown(Input.KEY_A)) {
                playerHandler.changeHorizontalMomentum(playerHandler.getAirborneSpeed() * -1);
            }
            if (input.isKeyDown(Input.KEY_W) && playerHandler.isJumping()) {
                playerHandler.jump();
            }
        }

    }

    private void universalInput(GameContainer container) {
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            container.exit();
        }
    }

}
