
package mazerunner;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Wall2 extends Pwall{
    
    ImageIcon img3 = new ImageIcon("sea1.jpg");
    ImageIcon img2 = new ImageIcon("sand.jpg");
    //Pwall wall = new Pwall();
    
    public Wall2()
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
                    if (rand_wall[j][i] == 0 )
                    {
                        g.drawImage(img3.getImage(), startx + j * size, starty + i * size, null);
                    }
                    
                }
                
                
            }
        }
    }
    
}
