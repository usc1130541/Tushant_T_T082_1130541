package mazerunner;

import java.awt.image.BufferedImage;


public class BackwardState extends PlayerState {

    @Override
    public BufferedImage[] getState() {
        
        return Playerssets.Backward;
    }

    
    @Override
    public BufferedImage getStop() {
        return Playerssets.StB;
    }
    
    
    
    
    
}

