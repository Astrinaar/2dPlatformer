
package pkg2dfightformer;

import helpers.ImgArchive;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import states.CombatState;
import states.StateHandler;

/**
 *
 * @author PK
 */
public class FightFormer extends StateBasedGame{
    
    private StateHandler stateHandler;
    private CombatState combatState;
    
    private ImgArchive imgArchive;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new FightFormer("Namae"));
        app.setDisplayMode(1280, 720, false);
        app.setShowFPS(true);
        app.setTargetFrameRate(59);
        app.setSmoothDeltas(true);
        app.setVSync(true);
        app.start();
    }

    private FightFormer(String name) {
        super(name);
        imgArchive = new ImgArchive();
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        initHelpers(container, this);
        stateHandler = new StateHandler(this);
        stateHandler.init(container, this);
        combatState = new CombatState();
        addState(combatState);
        getState(StateHandler.COMBATSTATE).init(container, this);
        enterState(StateHandler.COMBATSTATE);
    }
    
    public void initHelpers(GameContainer container, StateBasedGame game) throws SlickException {
        imgArchive.init(container, game);     
    }

}
