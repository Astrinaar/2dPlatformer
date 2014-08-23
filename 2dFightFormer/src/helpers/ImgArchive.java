package helpers;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class ImgArchive {

    //Backgrounds
    private static Image plainGrassBG;

    //Characters
    private static Image player;

    //Animations
    private static Image playerStab;
    private static Image playerStab2;

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        //Backgrounds
        plainGrassBG = new Image("res/PlainGrassBG.png");

        //Characters
        player = new Image("res/Player.png");

        //Animations
        playerStab = new Image("res/PlayerStab.png");
        playerStab2 = new Image("res/PlayerStab2.png");

    }

    //Backgrounds
    public static Image getPlainGrassBG() {
        return plainGrassBG;
    }

    //Characters
    public static Image getPlayer() {
        return player;
    }

    //Animaitons
    public static Image getPlayerStab() {
        return playerStab;
    }
    
    public static Image getPlayerStab2() {
        return playerStab2;
    }

}
