package extendables;

import helpers.MathTool;
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
public abstract class GameCharacter implements SlickClass {

    protected float xPos;
    protected float yPos;
    protected Image texture;
    protected Rectangle bounds;
    protected float life;
    protected float maxLife;
    protected float speed;
    protected float maxSpeed;
    protected boolean onGround = false;
    protected float horizontalMomentum = 0;
    protected float verticalMomentum = 0;

    public GameCharacter(float xPos, float yPos, Image texture) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.texture = texture;
        bounds = new Rectangle(xPos - (texture.getWidth() / 2), yPos - (texture.getHeight() / 2), texture.getWidth(), texture.getHeight());
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        texture.draw(xPos - (texture.getWidth() / 2), yPos - (texture.getHeight() / 2));
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        setxPos(xPos += (horizontalMomentum * MathTool.hundredPerSec * delta));
        setyPos(yPos += (verticalMomentum * MathTool.hundredPerSec * delta));
    }

    public void changeHorizontalMomentum(float momentum) {
        if(horizontalMomentum > 0 && momentum < 0){
            momentum *= 2;
        } else if(horizontalMomentum < 0 && momentum > 0){
            momentum *= 2;
        }
        horizontalMomentum += momentum;
        if (horizontalMomentum > maxSpeed) {
            horizontalMomentum = maxSpeed;
        } else if (horizontalMomentum < maxSpeed * -1) {
            horizontalMomentum = maxSpeed * -1;
        }
    }

    public void changeVerticalMomentum(float momentum) {
        verticalMomentum += momentum;
    }

    public void receiveDamage(float damage) {
        setLife(life - damage);
    }

    public void setMaxLife(float life) {
        this.life = life;
        maxLife = life;
    }

    public void updateBounds() {
        bounds.setLocation(xPos - (texture.getWidth() / 2), yPos - (texture.getHeight() / 2));
    }

    public void setFooting(float yPos) {
        this.yPos = yPos - (texture.getHeight() / 2);
        verticalMomentum = 0;
        onGround = true;
    }

    public float getxPos() {
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
        updateBounds();
    }

    public float getyPos() {
        return yPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
        updateBounds();
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Image getTexture() {
        return texture;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public float getLife() {
        return life;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public void setOnGround(boolean OnGround) {
        this.onGround = OnGround;
    }

    public float getHorizontalMomentum() {
        return horizontalMomentum;
    }

    public void setHorizontalMomentum(float horizontalMomentum) {
        this.horizontalMomentum = horizontalMomentum;
    }

    public float getVerticalMomentum() {
        return verticalMomentum;
    }

    public void setVerticalMomentum(float verticalMomentum) {
        this.verticalMomentum = verticalMomentum;
    }

}
