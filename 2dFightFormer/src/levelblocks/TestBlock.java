package levelblocks;

import extendables.Platform;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author PK
 */
public class TestBlock extends Platform {

    public TestBlock() {
    }

    public TestBlock(Rectangle bounds) {
        super(bounds);
    }

    public TestBlock(float middleX, float middleY, Image texture) {
        super(middleX, middleY, texture);
    }

    public TestBlock(Rectangle bounds, Image texture) {
        super(bounds, texture);
    }
    
    
}
