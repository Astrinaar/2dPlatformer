package states;

import helpers.ImgArchive;
import input.InputReceiver;
import level.LevelManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import player.PlayerHandler;
import universal.CollisionHandler;
import universal.Gravity;

/**
 *
 * @author PK
 */
public class CombatState extends BasicGameState {

    private final int id = StateHandler.COMBATSTATE;
    private InputReceiver inputReceiver;

    private Image background;

    private LevelManager levelManager;
    private PlayerHandler playerHandler;
    private Gravity gravity;
    private CollisionHandler collisionHandler;

    public CombatState() {
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        background = ImgArchive.getPlainGrassBG();
        levelManager = new LevelManager();
        levelManager.init(container, game);
        playerHandler = new PlayerHandler();
        playerHandler.init(container, game);
        gravity = new Gravity();
        gravity.init(container, game);
        collisionHandler = new CollisionHandler(levelManager.getTest());
        collisionHandler.init(container, game);
        inputReceiver = new InputReceiver(PlayerHandler.getPlayer());
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        background.draw(0, 0);
        levelManager.render(container, game, g);
        playerHandler.render(container, game, g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        inputReceiver.reactToInput(container, delta);
        playerHandler.update(container, game, delta);
        gravity.update(container, game, delta);
        collisionHandler.update(container, game, delta);
    }

}
