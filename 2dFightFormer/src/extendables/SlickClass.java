package extendables;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public interface SlickClass {
    
    public void init(GameContainer container, StateBasedGame game) throws SlickException;
    public void render(GameContainer container, StateBasedGame game, Graphics g);
    public void update(GameContainer container, StateBasedGame game, int delta);
}
