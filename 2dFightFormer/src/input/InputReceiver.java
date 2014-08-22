
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
    
    public void reactToInput(GameContainer container){
        input = container.getInput();
        if(input.isKeyPressed(Input.KEY_ESCAPE)){
            container.exit();
        }
        if(input.isKeyDown(Input.KEY_D)){
            player.changeHorizontalMomentum(player.getSpeed());
        }
        if(input.isKeyDown(Input.KEY_A)){
            player.changeHorizontalMomentum(player.getSpeed() * -1);
        }
    }

}
