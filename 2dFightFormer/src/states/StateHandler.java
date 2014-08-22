package states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import pkg2dfightformer.Main;

/**
 *
 * @author PK
 */
public class StateHandler {

    private static Main main;
    public static final int MAINMENUSTATE = 0;
    public static final int RESERVED = 1;
    public static final int COMBATSTATE = 2;

    public StateHandler(Main main) {
        StateHandler.main = main;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {

    }

    public static void enterState(int id) {
        main.enterState(id);
    }

}
