
package mazerunner;

import java.awt.Graphics;
import java.util.Random;

public class Pwall {

    
    public int flag;
    private static int [][] rand_wall = new int [23][16];
    Random rand = new Random();
    public int startx = 0;
    public int starty = 0;
    public int size = MazeStatic.Size =46;
    
    
    public Pwall ()
    {}
    
    public void random_wall()
    {
         for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 23; j++) {
                flag = rand.nextInt(2);
                getRand_wall()[j][i] = flag;
            }
            }
    }
    
    
    public  int[][] getRand_wall() {
        return rand_wall;
    }

    
    public  void setRand_wall(int[][] aRand_wall) {
        rand_wall = aRand_wall;
    }
            
    
}
