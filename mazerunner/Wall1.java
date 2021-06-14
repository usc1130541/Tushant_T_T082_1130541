
package mazerunner;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;

public class Wall1 extends Pwall{
    
    ImageIcon img1 = new ImageIcon("black pebbles.jpg");
    ImageIcon img2 = new ImageIcon("sand.jpg");

    
    //Pwall wall = new Pwall();
    
    
    
    
    public Wall1()
    {
    }
    

    
    
    public void Draw_wall (Graphics g , char [][] maze ,int [][] rand_wall)
    {
        for (int i = 0 ; i < 16 ; i ++)
        {
            for (int j = 0 ; j < 23 ; j ++)
            {
                //System.out.println(rand_wall[j][i]);
                if (maze[j][i] == '1')
                {
                    if (rand_wall[j][i] == 1 )
                    {
                        g.drawImage(img1.getImage(), startx + j * size, starty + i * size, null);
                    }
                    
                }
                else 
                {
                    g.drawImage(img2.getImage(), startx + j *size, starty + i * size, null);
                }
            }
        }
    }
    
}
