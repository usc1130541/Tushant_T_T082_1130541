/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class Bomb2 extends Bomb {
    
     Random rn = new Random();
    public static ArrayList<String> x = new ArrayList<String>();
    public static ArrayList<String> y = new ArrayList<String>();

    ImageIcon bomb2 = new ImageIcon("bomb2.png");
    public static int counter2=3;
    
    int ranx, rany;
    int i;
    int x1,y1,x2,y2,x3,y3;
    Graphics g2;
    ImageIcon dead = new ImageIcon("Death-icon.png");
    
    public Bomb2()
    {
        
    }
    
     
    
    
     public void randomizebombs(char[][] maze) {

        i = 0;
        int k,l,m;
        boolean found = false;

        while (!found) {
            boolean foundInCoins = false;
            boolean foundInRings = false;
            boolean foundInBombs = false;

            
            ranx = rn.nextInt(17)+2;
        rany = rn.nextInt(13) + 2;
            //Gifts.setRandi(numb.nextInt(13) + 2);
            //Gifts.setRandj(numb.nextInt(20));
            if (MazeStatic.maze[ranx][rany] == '0') {
                for (k = 0; k < Coins.coinposi.size(); k++) {
                    if (ranx == Integer.parseInt(Coins.coinposj.get(k))
                            && rany == Integer.parseInt(Coins.coinposi.get(k))) {
                        foundInCoins = true;
                        break;

                    }
                }
                found = !foundInCoins;
                
                for (l=0;l<Rings.ringposi.size();l++)
                {
                    if (ranx == Integer.parseInt(Rings.ringposj.get(l))
                            && rany == Integer.parseInt(Rings.ringposi.get(l))){
                    
                    foundInRings=true;
                    break;
                    
                    }
                
                }
                found= !foundInRings;
                
                
                for (m=0;m<Bomb1.x.size();m++)
                {
                    
                    if (ranx == Integer.parseInt(Bomb1.x.get(m))
                            && rany == Integer.parseInt(Bomb1.y.get(m))){
                    
                    foundInBombs= true;
                    break;
                    
                    
                    }
                
                
                
                }
                found = !foundInBombs;

            }
        }
        Bomb2.x.add(Integer.toString(ranx));
        Bomb2.y.add(Integer.toString(rany));
    }
    
    public void draw(Graphics g) {

       int m=0;

       while (m<x.size())
       {
           
           g.drawImage(bomb2.getImage(),  Integer.parseInt(x.get(m)) * MazeStatic.Size,  Integer.parseInt(y.get(m)) * MazeStatic.Size, null);
           
           m++;
       }
    }
       
     @Override
        public void bombaction(String Position)
    {
        for (int k = 0; k < x.size();k++) {
            if (Position.equalsIgnoreCase("Right")) {

                if (MazeStatic.P.PRT.x >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.x <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRT.y <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.y >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PRT.y >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.y <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRT.x <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRT.x >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        || (MazeStatic.P.PRB.y >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.y <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRB.x <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRB.x >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size))) {
                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
                    
                    Bomb2.x.remove(k);
                    Bomb2.y.remove(k);
                    if(Bomb.lives>0)
                    Bomb.lives--;
                    System.out.println("lives" +Bomb.lives);
                    if (Bomb.lives ==0)
                    {
                        System.out.println("Player DIED!!!");
                 //      Mazeframe.RUN=false;
                       
                        g2= MazeStatic.m.getGraphics();
                        g2.drawImage(dead.getImage(),MazeStatic.P.PLT.x,MazeStatic.P.PLT.y,null);
                    }
                    
                }
            } else if (Position.equalsIgnoreCase("left")) {
                if (MazeStatic.P.PLT.x <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size+ MazeStatic.Size
                        && MazeStatic.P.PLT.x >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size 
                        && MazeStatic.P.PLT.y <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.y >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PLT.y <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLT.y >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLT.x >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLT.x <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PLB.y >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.y <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLB.x >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.x <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size))) {

                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
                    
                    Bomb2.x.remove(k);
                    Bomb2.y.remove(k);
                    if(Bomb.lives>0)
                    Bomb.lives--;
                    System.out.println("lives" +Bomb.lives);
                    if (Bomb.lives ==0)
                    {
                        System.out.println("Player DIED!!!");
                        
                   //     Mazeframe.RUN=false;
                        g2= MazeStatic.m.getGraphics();
                        g2.drawImage(dead.getImage(),MazeStatic.P.PLT.x,MazeStatic.P.PLT.y,null);
                    }
                    
                }
            } else if (Position.equalsIgnoreCase("Forward")) {
                if (MazeStatic.P.PLB.y >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.y <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLB.x <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.x >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PLB.x >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.x <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLB.y >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLB.y <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        || (MazeStatic.P.PRB.x >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.x <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRB.y >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRB.y <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size))) {
                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
                    
                    Bomb2.x.remove(k);
                    Bomb2.y.remove(k);
                    if(Bomb.lives>0)
                    Bomb.lives--;
                    System.out.println("lives" +Bomb.lives);
                    if (Bomb.lives ==0)
                    {
                        System.out.println("Player DIED!!!");
                        
                       // Mazeframe.RUN=false;
                        g2= MazeStatic.m.getGraphics();
                        g2.drawImage(dead.getImage(),MazeStatic.P.PLT.x,MazeStatic.P.PLT.y,null);
                    }
                    
                }
            } else if (Position.equalsIgnoreCase("Backward")) {
               if (MazeStatic.P.PLT.y <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLT.y >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLT.x <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.x >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        || (MazeStatic.P.PLT.x >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PLT.x <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLT.y <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PLT.y >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        || (MazeStatic.P.PRT.x >= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.x <= Integer.parseInt(Bomb2.x.get(k)) * MazeStatic.Size + MazeStatic.Size
                        && MazeStatic.P.PRT.y >= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size
                        && MazeStatic.P.PRT.y <= Integer.parseInt(Bomb2.y.get(k)) * MazeStatic.Size + MazeStatic.Size))) {
                    //System.out.println(Position+"NOURHAAAAAAAAAAAAAAN");
                    
                    Bomb2.x.remove(k);
                    Bomb2.y.remove(k);
                    if(Bomb.lives>0)
                    Bomb.lives--;
                    System.out.println("lives" +Bomb.lives);
                    if (Bomb.lives ==0)
                    {
                        System.out.println("Player DIED!!!");
                        
                        /*try {
                            System.out.println(MazeStatic.P.P1);
                            MazeStatic.P.P1=ImageIO.read(new File("Death-icon.png"));
                            System.out.println(MazeStatic.P.P1);
                        } catch (IOException ex) {
                            Logger.getLogger(Bomb2.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Mazeframe.RUN=false;
                        MazeStatic.rc.update();*/
                     //   Mazeframe.RUN=false;
                        g2= MazeStatic.m.getGraphics();
                        g2.drawImage(dead.getImage(),MazeStatic.P.PLT.x,MazeStatic.P.PLT.y,null);
                    }
                    
                }
            }
        }
    
    }
}

