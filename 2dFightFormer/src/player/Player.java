
package player;

import extendables.GameCharacter;
import helpers.ImgArchive;
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
public class Player extends GameCharacter{
    
    

    public Player() {
        super(50, 100, ImgArchive.getPlayer());
        bounds = new Rectangle(xPos - (texture.getWidth() / 2), yPos - (texture.getHeight() / 2), 35, texture.getHeight());
        speed = 0.25f;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
    }


    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        super.render(container, game, g);
        g.draw(bounds);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        super.update(container, game, delta);        
    }
    
    


}
