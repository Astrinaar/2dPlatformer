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

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        //Backgrounds
        plainGrassBG = new Image("res/PlainGrassBG.png");

        //Characters
        player = new Image("res/Player.png");
    }

    //Backgrounds
    public static Image getPlainGrassBG() {
        return plainGrassBG;
    }

    //Characters
    public static Image getPlayer() {
        return player;
    }

}
