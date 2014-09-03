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
    protected float middleX;
    protected float middleY;
    protected Image texture;
    protected Rectangle bounds;
    protected float life;
    protected float maxLife;
    protected float speed;
    protected float maxSpeed;
    protected boolean onGround = false;
    protected float horizontalMomentum = 0;
    protected float verticalMomentum = 0;
    protected Platform ground = null;

    public GameCharacter(float xPos, float yPos, Image texture) {
        this.xPos = xPos;
        this.yPos = yPos;
        middleX = xPos;
        middleY = yPos;
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
        if (!(ground == null)) {
            checkFooting();
        }
    }

    public void changeHorizontalMomentum(float momentum) {
        if (horizontalMomentum > 0 && momentum < 0) {
            momentum *= 2;
        } else if (horizontalMomentum < 0 && momentum > 0) {
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
        onGround = false;
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
        middleX = bounds.getMinX() + (bounds.getWidth() / 2);
        middleY = bounds.getMinY() + (bounds.getHeight() / 2);
    }

    public void checkFooting() {
        if (middleX < ground.getBounds().getMinX()) {
            ground = null;
            onGround = false;
        } else if (middleX > ground.getBounds().getMaxX()) {
            ground = null;
            onGround = false;
        }
    }

    public void setFooting(Platform ground) {
        this.yPos = ground.getBounds().getMinY() - 1 - (bounds.getHeight() / 2);
        verticalMomentum = 0;
        this.ground = ground;
        onGround = true;
    }

    public void stayUnder(Platform platform) {
        setyPos(platform.getBounds().getMaxY() + 1 + (bounds.getHeight() / 2));
        if (verticalMomentum < 0) {
            verticalMomentum = 0;
        }
    }

    public void stayLeftOf(Platform platform) {
        setMiddleX(platform.getBounds().getMinX() - 1 - (bounds.getWidth() / 2));
        if (horizontalMomentum > 0) {
            horizontalMomentum = 0;
        }
    }

    public void stayRightOf(Platform platform) {
        setMiddleX(platform.getBounds().getMaxX() + 1 + (bounds.getWidth() / 2));
        if(horizontalMomentum < 0){
            horizontalMomentum = 0;
        }
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
        onGround = false;
    }

    public float getMiddleX() {
        return middleX;
    }

    public void setMiddleX(float middleX) {
        this.middleX = middleX;
        bounds.setLocation(middleX - (bounds.getWidth() / 2), middleY - (bounds.getHeight() / 2));
        xPos = bounds.getMinX() + (texture.getWidth() / 2);
    }

    public float getMiddleY() {
        return middleY;
    }

    public void setMiddleY(float middleY) {
        this.middleY = middleY;
        bounds.setLocation(middleX - (bounds.getWidth() / 2), middleY - (bounds.getHeight() / 2));
        xPos = bounds.getMinY() + (texture.getHeight() / 2);
    }

    public Platform getGround() {
        return ground;
    }

    public void setGround(Platform ground) {
        this.ground = ground;
    }

}
