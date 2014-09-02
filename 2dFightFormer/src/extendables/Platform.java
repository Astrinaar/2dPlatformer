package extendables;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public abstract class Platform implements SlickClass {

    protected Rectangle bounds;
    protected float middleX;
    protected float middleY;
    protected Image texture;

    public Platform() {
    }

    public Platform(Rectangle bounds) {
        this.bounds = bounds;
        middleX = bounds.getCenterX();
        middleY = bounds.getCenterY();
    }

    public Platform(float middleX, float middleY, Image texture) {
        this.texture = texture;
        this.middleX = middleX;
        this.middleY = middleY;
        bounds = new Rectangle(middleX - (texture.getWidth() / 2), middleY - (texture.getHeight() / 2), texture.getWidth(), texture.getHeight());
    }

    public Platform(Rectangle bounds, Image texture) {
        this.bounds = bounds;
        middleX = bounds.getCenterX();
        middleY = bounds.getCenterY();
        this.texture = texture;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        if (!(texture == null)) {
            texture.draw(middleX - (texture.getWidth() / 2), middleY - (texture.getHeight() / 2));
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
        middleX = bounds.getCenterX();
        middleY = bounds.getCenterY();
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
