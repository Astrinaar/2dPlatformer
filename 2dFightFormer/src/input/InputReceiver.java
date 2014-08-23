package input;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import player.Player;

/**
 *
 * @author PK
 */
public class InputReceiver {

    private Input input;
    private Player player;

    public InputReceiver(Player player) {
        this.player = player;
    }

    public void reactToInput(GameContainer container, int delta) {
        input = container.getInput();
        universalInput(container);
        inputForPlayer(delta);
    }

    public void inputForPlayer(int delta) {
        if (player.isOnGround()) {
            if (input.isKeyDown(Input.KEY_D)) {
                player.changeHorizontalMomentum(player.getSpeed());
            }
            if (input.isKeyDown(Input.KEY_A)) {
                player.changeHorizontalMomentum(player.getSpeed() * -1);
            }
            if (input.isKeyDown(Input.KEY_W)) {
                player.jump();
            }
        } else {
            if (input.isKeyDown(Input.KEY_D)) {
                player.changeHorizontalMomentum(player.getAirborneSpeed());
            }
            if (input.isKeyDown(Input.KEY_A)) {
                player.changeHorizontalMomentum(player.getAirborneSpeed() * -1);
            }
            if (input.isKeyDown(Input.KEY_W) && player.isJumping()) {
                player.jump();
            }
        }
    }

    private void universalInput(GameContainer container) {
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            container.exit();
        }
    }

}
