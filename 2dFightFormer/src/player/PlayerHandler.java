package player;

import extendables.SlickClass;
import helpers.ImgArchive;
import helpers.MathTool;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class PlayerHandler implements SlickClass {

    private static Player player;
    private boolean dead = false;

    private Image[] defaultAni;
    private Image[] stabAni;

    public PlayerHandler() {
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        initAnimations();
        player = new Player(defaultAni);
        player.init(container, game);
        MathTool.setPlayer(player);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        player.render(container, game, g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        if (player.getLife() <= 0) {
            dead = true;
        }
        player.update(container, game, delta);
    }

    private void initAnimations() {
        defaultAni = new Image[1];
        defaultAni[0] = ImgArchive.getPlayer();
        stabAni = new Image[4];
        stabAni[0] = ImgArchive.getPlayerStab();
        stabAni[1] = ImgArchive.getPlayerStab2();
        stabAni[2] = ImgArchive.getPlayerStab();
        stabAni[3] = ImgArchive.getPlayer();
    }

    public void attack(int id) {
        switch (id) {
            case 0:
                setAnimationLock(19);
                setCurrentAnimation(stabAni, 50);
        }
    }

    public void jump() {
        player.jump();
    }

    public void doubleJump() {
        player.doubleJump();
    }

    public void changeHorizontalMomentum(float momentum) {
        player.changeHorizontalMomentum(momentum);
    }

    public void changeVerticalMomentum(float momentum) {
        player.changeVerticalMomentum(momentum);
    }

    public void setHorizontalMomentum(float momentum) {
        player.setHorizontalMomentum(momentum);
    }

    public void setVerticalMomentum(float momentum) {
        player.setVerticalMomentum(momentum);
    }

    public boolean isOnGround() {
        return player.isOnGround();
    }

    public float getSpeed() {
        return player.getSpeed();
    }

    public float getAirborneSpeed() {
        return player.getAirborneSpeed();
    }

    public boolean isJumping() {
        return player.isJumping();
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public static Player getPlayer() {
        return player;
    }

    public float getAnimationLock() {
        return player.getAnimationLock();
    }

    public void setAnimationLock(float duration) {
        player.setAnimationLock(duration);
    }

    public void setCurrentAnimation(Image[] animation, int duration) {
        player.setCurrentAni(animation, duration);
    }

    public boolean canDoubleJump() {
        if (player.isCanDoubleJump() && player.getDoubleJumpTimer() <= 0) {
            return true;
        }
        return false;
    }
}
