package player;

import extendables.GameCharacter;
import helpers.ImgArchive;
import helpers.MathTool;
import org.newdawn.slick.Animation;
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
public class Player extends GameCharacter {

    private boolean horizontalInput;
    private float airborneSpeed;
    private float jumpSpeed;
    private boolean jumping = false;
    private float jumpTimer = 0;
    private float animationLock = 0;

    private Animation currentAni;
    private Image[] defaultAni;

    public Player(Image[] defaultAni) {
        super(50, 100, ImgArchive.getPlayer());
        this.defaultAni = defaultAni;
        bounds = new Rectangle(xPos - (texture.getWidth() / 2), yPos - (texture.getHeight() / 2), 35, texture.getHeight());
        speed = 0.5f;
        maxSpeed = 5;
        jumpSpeed = 2.5f;
        airborneSpeed = 0.1f;
        currentAni = new Animation(this.defaultAni, 10000);
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        currentAni.setAutoUpdate(true);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        g.drawAnimation(currentAni, xPos - (texture.getWidth() / 2), yPos - (texture.getHeight() / 2));
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        if (!horizontalInput && horizontalMomentum != 0) {
            stopHorizontalMovement();
        }
        super.update(container, game, delta);
        horizontalInput = false;
        updateTimers(delta);
    }

    @Override
    public void changeHorizontalMomentum(float momentum) {
        super.changeHorizontalMomentum(momentum);
        horizontalInput = true;
    }

    public void stopHorizontalMovement() {
        float stoppingSpeed;
        if (onGround) {
            stoppingSpeed = maxSpeed / 10;
        } else {
            stoppingSpeed = maxSpeed / 50;
        }
        if (horizontalMomentum > 0) {
            if (horizontalMomentum > 0 + stoppingSpeed) {
                horizontalMomentum -= stoppingSpeed;
            } else {
                horizontalMomentum = 0;
            }
        } else if (horizontalMomentum < 0 - stoppingSpeed) {
            horizontalMomentum += stoppingSpeed;
        } else {
            horizontalMomentum = 0;
        }
    }

    public void jump() {
        if (jumpTimer == 0 && !jumping) {
            jumpTimer = 5;
            jumping = true;
            onGround = false;
        }
        changeVerticalMomentum(jumpSpeed * -1);
    }

    public boolean isJumping() {
        return jumping;
    }

    private void updateTimers(int delta) {
        if (jumpTimer > 0) {
            jumpTimer -= MathTool.hundredPerSec * delta;
            if (jumpTimer <= 0) {
                jumping = false;
                jumpTimer = 0;
            }
        }
        if(animationLock > 0){
            animationLock -= MathTool.hundredPerSec * delta;
            if(animationLock <= 0){
                animationLock = 0;
                setAnimationToDefault();
            }
        }
    }

    public float getAirborneSpeed() {
        return airborneSpeed;
    }

    public float getAnimationLock() {
        return animationLock;
    }

    public void setAnimationLock(float animationLock) {
        this.animationLock = animationLock;
    }

    public Animation getCurrentAni() {
        return currentAni;
    }

    public void setCurrentAni(Image[] animation, int duration) {
        currentAni = new Animation(animation, duration);
    }

    public void setAnimationToDefault() {
        currentAni = new Animation(defaultAni, 1000);        
    }

    public void setDefaultAni(Image[] defaultAni) {
        this.defaultAni = defaultAni;
    }
    
    

}
