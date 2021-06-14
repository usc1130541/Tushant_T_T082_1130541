
package mazerunner;

import java.awt.image.BufferedImage;


public class LeftState extends PlayerState {
    

    @Override
    public BufferedImage[] getState() {
        return Playerssets.Left;
    }

    @Override
    public BufferedImage getStop() {
        return Playerssets.StL;
    }
    
}
