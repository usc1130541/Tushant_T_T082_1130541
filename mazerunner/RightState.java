
package mazerunner;

import java.awt.image.BufferedImage;


public class RightState extends PlayerState {

    @Override
    public BufferedImage[] getState() {
        
        return Playerssets.Right;
    }

    @Override
    public BufferedImage getStop() {
       return Playerssets.StR;
    }
    
    
    
    
    
}
