package levelblocks;

import extendables.SlickClass;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class TestBlock implements SlickClass {

    private Rectangle bounds;
    private float middleX;
    private float middleY;

    public TestBlock() {
        bounds = new Rectangle(0, 1010, 1920, 70);
        middleX = bounds.getCenterX();
        middleY = bounds.getCenterY();
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public float getMiddleX() {
        return middleX;
    }

    public float getMiddleY() {
        return middleY;
    }
    
    

}
