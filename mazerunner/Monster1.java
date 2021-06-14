
package mazerunner;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class Monster1 extends Pmonster{
    int rand_x, rand_y;
    Monster monst = new Monster();
    ImageIcon monster = new ImageIcon("Monsters.png");
    ImageIcon dead = new ImageIcon("Death-icon.png");
    Graphics g2;
    Random rand = new Random();
    MazeStatic m = new MazeStatic();
    public static ArrayList <Pmonster> position1 = new ArrayList <Pmonster> ();
    
    
    public Monster1(int monsterx, int monstery , int random_j , int random_i)
    {
        this.monsterx = monsterx;
        this.monstery = monstery;
        this.random_j = random_j;
        this.random_i = random_i;
    }
    
    public Monster1()
    {}
    
    public void random_mons(Graphics g, char [][] maze)
    {
        rand_y = rand.nextInt(12)+3;
        rand_x = rand.nextInt(16)+3;
        
        for (int i = 0 ; i < monst.position.size() ; i++)
        {
            
            if (rand_y == monst.position.get(i).random_i && rand_x == monst.position.get(i).random_j)
            {
                random_mons(g,maze);
            }
        }
        if (maze[rand_x][rand_y] == '0')
        {
            monstery =  rand_y * MazeStatic.Size;
            monsterx =  rand_x * MazeStatic.Size;
            Pmonster mons = new Monster(monsterx, monstery, rand_x, rand_y);
            position1.add(mons);
        }
        else 
        {
            random_mons(g,maze);
        }
    }
    
    
    public void drawmonster(Graphics g, char [][] maze)
    {
     for (int i = 0 ; i < position1.size() ; i++)
     {
         if (position1.get(i).isdied == false)
         {
            g.drawImage(monster.getImage(),position1.get(i).monsterx ,
                    position1.get(i).monstery, null);
         }
          
     }
    } 
    
    
    public void check_position1(String player)
    {
        for (int i = 0 ; i < position1.size() ; i++)
        {
            
            if (player.equalsIgnoreCase("Right"))
            {
                System.out.println(position1.get(i).monsterx);
            if  (MazeStatic.P.PRT.x >= position1.get(i).monsterx && 
                        MazeStatic.P.PRT.x <= position1.get(i).monsterx + 40 &&
                        MazeStatic.P.PRT.y <= position1.get(i).monstery + 40 && 
                    MazeStatic.P.PRB.y >= position1.get(i).monstery)
            {
                if (Bomb.lives > 0) {
                    if(position1.get(i).isdied == false){
                        Bomb.lives--;
                    position1.get(i).isdied = true;
                        
                        MazeStatic.x_start = MazeStatic.x_start - (2 * 46);
                        if (MazeStatic.maze[MazeStatic.x_start/ 46][MazeStatic.y_start/46] == '1')
                       {
                           MazeStatic.x_start = 47;
                           MazeStatic.y_start = 47;
                       }}
                    }
                    System.out.println("lives" + Bomb.lives);
                    if (Bomb.lives == 0) {
                        System.out.println("Player DIED!!!");
                       g2 = MazeStatic.m.getGraphics();
                        g2.drawImage(dead.getImage(), MazeStatic.P.PLT.x, MazeStatic.P.PLT.y, null);

                    }
            }
            }else if (player.equalsIgnoreCase("left")) {
                System.out.println(position1.get(i).monsterx);
                if (MazeStatic.P.PLT.x <=  position1.get(i).monsterx + 40 && 
                        MazeStatic.P.PLT.x >= position1.get(i).monsterx &&
                        MazeStatic.P.PLT.y <= position1.get(i).monstery + 40 && 
                        MazeStatic.P.PLB.y >= position1.get(i).monstery) 
                {
                        if (Bomb.lives > 0) {
                        if(position1.get(i).isdied == false){
                        Bomb.lives--;
                    position1.get(i).isdied = true;
                        
                        MazeStatic.x_start = MazeStatic.x_start + (2 * 46);
                        if (MazeStatic.maze[MazeStatic.x_start/ 46][MazeStatic.y_start/46] == '1')
                       {
                           MazeStatic.x_start = 47;
                           MazeStatic.y_start = 47;
                       }}
                       
                        
                    }
                    System.out.println("lives" + Bomb.lives);
                    if (Bomb.lives == 0) {
                        System.out.println("Player DIED!!!");
                        g2 = MazeStatic.m.getGraphics();
                        g2.drawImage(dead.getImage(), MazeStatic.P.PLT.x, MazeStatic.P.PLT.y, null);

                    }
                    
                }
            } else if (player.equalsIgnoreCase("Forward")) {
                System.out.println(position1.get(i).monsterx);
                if (MazeStatic.P.PLB.y >=  position1.get(i).monstery&& 
                        MazeStatic.P.PLB.y<= position1.get(i).monstery + 40 &&
                        MazeStatic.P.PLB.x <=  position1.get(i).monsterx + 40 &&
                        MazeStatic.P.PRB.x >= position1.get(i).monsterx ) {
                    if (Bomb.lives > 0) {
                        if(position1.get(i).isdied == false){
                        Bomb.lives--;
                    position1.get(i).isdied = true;
                        
                        MazeStatic.y_start = MazeStatic.y_start - (2 * 46);
                        if (MazeStatic.maze[MazeStatic.x_start/ 46][MazeStatic.y_start/46] == '1')
                       {
                           MazeStatic.x_start = 47;
                           MazeStatic.y_start = 47;
                       }}
                        
                    }
                    System.out.println("lives" + Bomb.lives);
                    if (Bomb.lives == 0) {
                        System.out.println("Player DIED!!!");
                        g2 = MazeStatic.m.getGraphics();
                        g2.drawImage(dead.getImage(), MazeStatic.P.PLT.x, MazeStatic.P.PLT.y, null);

                    }
                }
            } else if (player.equalsIgnoreCase("Backward")) {
                System.out.println(position1.get(i).monsterx);
                if (MazeStatic.P.PLT.y <= position1.get(i).monstery + 40 && 
                        MazeStatic.P.PLT.y >= position1.get(i).monstery &&
                        MazeStatic.P.PLT.x <= position1.get(i).monsterx + 40 && 
                        MazeStatic.P.PRT.x >= position1.get(i).monsterx ) {
                     if (Bomb.lives > 0) {
                        if(position1.get(i).isdied == false){
                        Bomb.lives--;
                    position1.get(i).isdied = true;
                        
                        MazeStatic.y_start = MazeStatic.y_start + (2 * 46);
                        if (MazeStatic.maze[MazeStatic.x_start/ 46][MazeStatic.y_start/46] == '1')
                       {
                           MazeStatic.x_start = 47;
                           MazeStatic.y_start = 47;
                       }}
                        
                    }
                    System.out.println("lives" + Bomb.lives);
                    if (Bomb.lives == 0) {
                        System.out.println("Player DIED!!!");
                        g2 = MazeStatic.m.getGraphics();
                        g2.drawImage(dead.getImage(), MazeStatic.P.PLT.x, MazeStatic.P.PLT.y, null);

                    }
                }
        }
    }
    }
}
