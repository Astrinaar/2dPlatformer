
package level;

import extendables.SlickClass;
import levelblocks.TestBlock;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class LevelManager implements SlickClass{
    
    private TestBlock test;

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        test = new TestBlock();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        test.render(container, game, g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
    }
    
    public TestBlock getTest(){
        return test;
    }
    
    

}
