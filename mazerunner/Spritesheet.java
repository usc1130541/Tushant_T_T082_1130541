
package mazerunner;

import java.awt.image.BufferedImage;


public class Spritesheet {
    private final BufferedImage Sheet;
    public Spritesheet(BufferedImage Sheet)
    {
        this.Sheet=Sheet;
    }
    
    public BufferedImage Crop(int x,int y,int width,int height)
    {
        
        return Sheet.getSubimage(x, y, width, height);
    }
}
