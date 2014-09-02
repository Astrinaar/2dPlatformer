package level;

import extendables.Platform;
import extendables.SlickClass;
import helpers.ImgArchive;
import java.util.ArrayList;
import levelblocks.TestBlock;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class LevelManager implements SlickClass {

    private ArrayList<Platform> platforms;

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        platforms = new ArrayList<>();
        platforms.add(new TestBlock(new Rectangle(0, 1010, 1920, 70)));
        platforms.add(new TestBlock(500, 900, ImgArchive.getTestBlock()));
        platforms.add(new TestBlock(1000, 750, ImgArchive.getTestBlock()));
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        for(Platform p : platforms){
            p.render(container, game, g);
            g.draw(p.getBounds());
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

}
