package mazerunner;

import java.awt.image.BufferedImage;


public class ForwardState extends PlayerState {

    @Override
    public BufferedImage[] getState() {
        
        return Playerssets.Forward;
    }

    @Override
    public BufferedImage getStop() {
        return Playerssets.StF;
    }
    
    
    
    
    
}
