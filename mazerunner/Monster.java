/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import Viewer.Mazeframe;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class Monster extends Pmonster{
    int flag = 0;
    ImageIcon monster = new ImageIcon("Blue-Monster.png");
    Random rand = new Random();
    MazeStatic m = new MazeStatic();
    ImageIcon dead = new ImageIcon("Death-icon.png");
    Graphics g2;
    //Mazegenerate m1 = new Mazegenerate();
    //Maze m = new Maze ();
    public static ArrayList <Pmonster> position = new ArrayList <Pmonster> ();
    
    public Monster(int monsterx, int monstery , int random_j , int random_i)
    {
        this.monsterx = monsterx;
        this.monstery = monstery;
        this.random_j = random_j;
        this.random_i = random_i;
    }
    
    public Monster()
    {}
    
    public void random_mons(Graphics g, char [][] maze)
    {

        random_i = rand.nextInt(12)+3;
        random_j = rand.nextInt(16)+3;
        
        if (maze[random_j][random_i] == '0')
        {

            monstery =  random_i * MazeStatic.Size;
            monsterx =  random_j * MazeStatic.Size;
            Pmonster mons = new Monster(monsterx, monstery, random_j, random_i);
            position.add(mons);
            
        }
        else 
        {
            random_mons(g,maze);

        }
    }
    
    public void drawmonster(Graphics g, char [][] maze)
    {
     for (int i = 0 ; i < position.size() ; i++)
     {
         if(position.get(i).isdied == false)
         {
            g.drawImage(monster.getImage(),position.get(i).monsterx ,
                    position.get(i).monstery, null);
         }
     }
    }   
   
     public void check_position(String player)
    {
        for (int i = 0 ; i < position.size() ; i++)
        {
            if (player.equalsIgnoreCase("Right"))
            {
            if  (MazeStatic.P.PRT.x >= position.get(i).monsterx && 
                        MazeStatic.P.PRT.x <= position.get(i).monsterx + 40 &&
                        MazeStatic.P.PRT.y <= position.get(i).monstery + 40 && 
                    MazeStatic.P.PRB.y >= position.get(i).monstery )
            {
                System.out.println("Player reached the monster");
                if (Bomb.lives > 0) {
                    if (position.get(i).isdied == false){
                        Bomb.lives--;
                        position.get(i).isdied = true;
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
                if (MazeStatic.P.PLT.x <=  position.get(i).monsterx + 40 && 
                        MazeStatic.P.PLT.x >= position.get(i).monsterx &&
                        MazeStatic.P.PLT.y <= position.get(i).monstery + 40 && 
                        MazeStatic.P.PLB.y >= position.get(i).monstery) {
                        System.out.println("Player reached the monsterlllll");
                        //Observer.updatelives();
                        if (Bomb.lives > 0) {
                        if (position.get(i).isdied == false){
                        Bomb.lives--;
                        position.get(i).isdied = true;
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
                if (MazeStatic.P.PLB.y >=  position.get(i).monstery&& 
                        MazeStatic.P.PLB.y<= position.get(i).monstery + 40 &&
                        MazeStatic.P.PLB.x <=  position.get(i).monsterx + 40 &&
                        MazeStatic.P.PRB.x >= position.get(i).monsterx ) {
                    System.out.println("Player reached the monsterffffff");
                    //0Observer.updatelives();
                    if (Bomb.lives > 0) {
                        if (position.get(i).isdied == false){
                        Bomb.lives--;
                        position.get(i).isdied = true;
                        MazeStatic.y_start = MazeStatic.y_start - (2 * 46);
                        if (MazeStatic.maze[MazeStatic.x_start/ 46][MazeStatic.y_start/ 46] == '1')
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
                if (MazeStatic.P.PLT.y <= position.get(i).monstery + 40 && 
                        MazeStatic.P.PLT.y >= position.get(i).monstery &&
                        MazeStatic.P.PLT.x <= position.get(i).monsterx + 40 && 
                        MazeStatic.P.PRT.x >= position.get(i).monsterx ) {
                    System.out.println("Player reached the monsterbbbb");
                    //Observer.updatelives();
                    if (Bomb.lives > 0) {
                        if (position.get(i).isdied == false){
                        Bomb.lives--;
                        position.get(i).isdied = true;
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
